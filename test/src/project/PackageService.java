package project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import tools.ConnectToDataBase;
import tools.MySqlUtil;

public class PackageService {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		int package_id = 28;// 套餐id
		// int[] standardArray = getStandardUsable(3);// 标品id
		int[] standardArray = { 456, 461 };

		// 1.插入套餐、标品
		for (int i = 0; i < standardArray.length; i++) {
			int id = standardArray[i];
			if (id > 0) {
				packageWithSpu(package_id, id);
			} else {
				System.out.println("标品id为" + id + ",插入失败！");
			}

			// 2.插入标品、服务商
			Set<Integer> provider = getStandardIdUsable().get(standardArray[i]);
			if (provider != null && !provider.isEmpty()) {
				Iterator<Integer> it = provider.iterator();
				while (it.hasNext()) {
					spuWithProvider(standardArray[i], it.next());
				}
			}

			System.out.println("\t\t");
		}

		// System.out.println(isSpuInPackage(5));
	}

	// 1.关联套餐id与spu标品id
	public static void packageWithSpu(int package_id, int standard_id) throws SQLException {
		String sql = "INSERT INTO zhubajie_shop.sp_service_spu_pack_re (`package_id`, `standard_id`, `create_time`, `create_date`, `update_time`, `user_id`, `user_name`) VALUES("
				+ package_id + "," + standard_id + ",UNIX_TIMESTAMP(NOW()),CURDATE(),NOW(),NULL,NULL)";
		MySqlUtil sqlUtil = ConnectToDataBase.getSqlUtilDataBaseTest();
		if (!isPackageSpuExist(package_id, standard_id)) {
			if (sqlUtil.insert(sql)) {
				System.out.println("套餐id：" + package_id + " 标品id：" + standard_id + "插入成功");
			}
		} else {
			System.out.println("套餐id：" + package_id + " 标品id：" + standard_id + "已存在");
		}

		sqlUtil.Close();
	}

	// 2.关联spu标品与服务商
	public static void spuWithProvider(int standard_id, int provider_id) throws SQLException {
		String sql = "INSERT INTO zhubajie_shop.sp_service_spu_pack_user_re (`standard_id`, `user_id`, `create_time`, `create_date`, `update_time`)  VALUES("
				+ standard_id + "," + provider_id + ",UNIX_TIMESTAMP(NOW()),CURDATE(),NOW())";
		MySqlUtil sqlUtil = ConnectToDataBase.getSqlUtilDataBaseTest();
		if (!isSpuWithProvederExist(standard_id, provider_id)) {
			if (sqlUtil.insert(sql)) {
				System.out.println("标品id：" + standard_id + " 服务商id：" + provider_id + "插入成功！");
			}
		} else {
			System.out.println("标品id：" + standard_id + " 服务商id：" + provider_id + "已存在");
		}
		sqlUtil.Close();
	}

	// 3.判断套餐id、标品id组合是否已经存在
	public static boolean isPackageSpuExist(int package_id, int standard_id) throws SQLException {
		String sql = "SELECT standard_id FROM zhubajie_shop.sp_service_spu_pack_re WHERE package_id = " + package_id
				+ " and standard_id = " + standard_id;
		MySqlUtil sqlUtil = ConnectToDataBase.getSqlUtilDataBaseTest();
		ResultSet result = sqlUtil.Query(sql);
		while (result.next()) {
			if (result.getInt("standard_id") != 0) {
				return true;
			}
		}
		sqlUtil.Close();
		return false;

	}

	// 4.判断标品id、服务商id组合是否已经存在
	public static boolean isSpuWithProvederExist(int standard_id, int provider_id) throws SQLException {
		String sql = "SELECT user_id FROM zhubajie_shop.sp_service_spu_pack_user_re WHERE standard_id = " + standard_id
				+ " AND user_id = " + provider_id;
		MySqlUtil sqlUtil = ConnectToDataBase.getSqlUtilDataBaseTest();
		ResultSet result = sqlUtil.Query(sql);

		while (result.next()) {
			if (result.getInt("user_id") != 0) {
				return true;
			}
		}
		sqlUtil.Close();
		return false;
	}

	// 4.1判断标品id是否已经存在于标品服务商表
	public static boolean isSpuExist(int standard_id) throws SQLException {
		String sql = "SELECT standard_id FROM zhubajie_shop.sp_service_spu_pack_user_re WHERE standard_id = "
				+ standard_id;
		MySqlUtil sqlUtil = ConnectToDataBase.getSqlUtilDataBaseTest();
		ResultSet result = sqlUtil.Query(sql);

		while (result.next()) {
			if (result.getInt("standard_id") != 0) {
				return true;
			}
		}
		sqlUtil.Close();
		return false;
	}

	// 4.2判断标品id是否已经存在于套餐表
	public static boolean isSpuInPackage(int standard_id) throws SQLException {
		String sql = "SELECT standard_id FROM zhubajie_shop.sp_service_spu_pack_re WHERE standard_id = " + standard_id;
		MySqlUtil sqlUtil = ConnectToDataBase.getSqlUtilDataBaseTest();
		ResultSet result = sqlUtil.Query(sql);

		while (result.next()) {
			if (result.getInt("standard_id") != 0) {
				return true;
			}
		}
		sqlUtil.Close();
		return false;
	}

	// 5.获取可用的标品id、服务商id
	public static Map<Integer, Set<Integer>> getStandardIdUsable() throws SQLException {
		Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
		String sql = "SELECT standard_id,user_id FROM  zhubajie_shop.sp_service_enlist WHERE TYPE = 2 AND audit_status = 2 AND service_id != 0";
		MySqlUtil sqlUtil = ConnectToDataBase.getSqlUtilDataBaseTest();
		ResultSet result = sqlUtil.Query(sql);
		while (result.next()) {
			int standard_id = result.getInt("standard_id");
			int user_id = result.getInt("user_id");

			if (!map.containsKey(standard_id)) {
				Set<Integer> providerSet = new HashSet<Integer>();
				providerSet.add(user_id);
				map.put(standard_id, providerSet);
			} else {
				Set<Integer> providerSet = map.get(standard_id);
				providerSet.add(user_id);
				map.put(standard_id, providerSet);
			}

		}
		sqlUtil.Close();
		return map;
	}

	// 6.获取套餐的标品id
	public static Set<Integer> getStandardIdOfPackage(int package_id) throws SQLException {
		Set<Integer> standardSet = new HashSet<>();
		String sql = "SELECT standard_id FROM zhubajie_shop.sp_service_spu_pack_re WHERE package_id = " + package_id;
		MySqlUtil sqlUtil = ConnectToDataBase.getSqlUtilDataBaseTest();
		ResultSet result = sqlUtil.Query(sql);
		while (result.next()) {
			standardSet.add(result.getInt("standard_id"));
		}
		return standardSet;

	}

	// 7.获取标品的服务商id
	public static Set<Integer> getProviderOfStandard(int standard_id) throws SQLException {
		Set<Integer> providerSet = new HashSet<>();
		String sql = "SELECT user_id FROM zhubajie_shop.sp_service_spu_pack_user_re WHERE standard_id = " + standard_id;
		MySqlUtil sqlUtil = ConnectToDataBase.getSqlUtilDataBaseTest();
		ResultSet result = sqlUtil.Query(sql);
		while (result.next()) {
			providerSet.add(result.getInt("user_id"));
		}
		return providerSet;

	}

	// 8.获取n个不在套餐表里面的标品
	public static int[] getStandardUsable(int num) throws SQLException {
		int[] standardArray = new int[num];
		String sql = "SELECT standard_id FROM zhubajie_shop.sp_service_enlist WHERE TYPE = 2 AND service_id != 0 AND audit_status = 2 group by standard_id";
		MySqlUtil sqlUtil = ConnectToDataBase.getSqlUtilDataBaseTest();
		ResultSet result = sqlUtil.Query(sql);
		int n = 0;
		while (result.next()) {
			int tmpSpu = result.getInt("standard_id");
			if (!isSpuExist(tmpSpu) && !isSpuInPackage(tmpSpu)) {
				standardArray[n] = tmpSpu;
				n++;
			}

			if (n >= num) {
				break;
			}

		}
		return standardArray;
	}

}
