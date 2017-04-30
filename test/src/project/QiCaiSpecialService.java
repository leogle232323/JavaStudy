package project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import tools.MySqlUtil;

/**
 * 企采行业专属服务
 */
public class QiCaiSpecialService {
	public static void main(String[] args) throws SQLException {
		int count = 20;
		String userId = "23569494";
		int industryId = getUserIndustryId(userId);
		// List<String> service = getTianPengService();
		List<String> service = getService();
		int indexCount = 0;

		// 1.为每个行业都插入数据
		// for (int in = 1; in < 13; in++) {
		// if (in > 0) {
		// for (int i = 0; i < service.size(); i++) {
		// if (!isInIndustryServiceTable(in, service.get(i))) {
		// insertService(QiCaiRecommendService.getGuid(), in, service.get(i));
		// indexCount++;
		// }
		// if (indexCount >= (count + in)) {
		// indexCount = 0;
		// break;
		// }
		// }
		// } else {
		// if (isUserIdExist(userId)) {
		// System.out.println("用户id：" + userId + "无关联行业类目");
		// }
		// }
		// }

		// 2.为单个行业插入数据
		if (industryId > 0) {
			for (int i = 0; i < service.size(); i++) {
				if (!isInIndustryServiceTable(industryId, service.get(i))) {
					insertService(QiCaiRecommendService.getGuid(), industryId, service.get(i));
					indexCount++;
				}
				if (indexCount >= count) {
					break;
				}
			}
		} else {
			if (isUserIdExist(userId)) {
				System.out.println("用户id：" + userId + "无关联行业类目");
			}
		}

		// 3.删除id大于固定值的行业服务
		// int id = 1;
		// deleteAllIndustryService(id);

		// 4.删除单个行业下的所有服务
		// int singleIndustryId = 1;
		// deleteSingleIndustryService(singleIndustryId);
	}

	public static String getGuid() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

	public static boolean isTianPengService(String serviceId) throws SQLException {
		List<String> tianPengService = getTianPengService();
		for (int i = 0; i < tianPengService.size(); i++) {
			if (tianPengService.get(i).equals(serviceId)) {
				return true;
			}
		}
		return false;
	}

	public static List<String> getTianPengService() throws SQLException {
		MySqlUtil sqlUtil = getSqlUitl();
		List<String> serviceList = new ArrayList<>();
		String serviceSql = "SELECT service_id FROM zhubajie_shop.sp_service WHERE source = 2 ";
		ResultSet result = sqlUtil.Query(serviceSql);
		while (result.next()) {
			serviceList.add(result.getString("service_id"));
		}
		sqlUtil.Close();
		return serviceList;
	}

	public static int getMaxId() throws SQLException {
		MySqlUtil sqlUtil = getSqlUitl();
		String sql = "SELECT id FROM zhubajie_qicai.qc_industry_service ORDER BY id DESC LIMIT 1";
		ResultSet result = sqlUtil.Query(sql);
		while (result.next()) {
			return result.getInt("id");
		}
		return 0;
	}

	public static List<String> getService() throws SQLException {
		String[] strService = { "1001968349", "1001965490", "1001970226", "1001970227", "1001970217", "1001968199",
				"1001970147", "1001965492", "1001970283", "1001971208", "1001971264", "1001969272", "1001969659",
				"1001970192", "1001970279", "1001970278", "1001970277", "1001965366", "1001965493", "1001965494",
				"1001965398", "1001968154", "1001968564", "1001970216", "1001970223", "1001970221", "1001965407",
				"1001965406", "1001968197", "1001968198", "1001968194", "1001968200", "1001970194", "1001970196",
				"1001970198", "1001970199", "1001970201", "1001970202", "1001970204", "1001970189", "1001970190",
				"1001970224", "1001970225", "1001970230", "1001970231", "1001970228" };
		return Arrays.asList(strService);
	}

	public static void insertService(String guid, int industryId, String serviceId) throws SQLException {
		String sql = "INSERT INTO zhubajie_qicai.qc_industry_service(`id`, `create_guid`, `create_time`, `update_time`, `industry_id`, `service_id`, `sequence`, `manager_id`, `manager_name`)  VALUES(NULL,'"
				+ guid + "',SYSDATE(),SYSDATE()," + industryId + ",'" + serviceId + "',NULL,'55','王露')";
		System.out.println(sql);
		MySqlUtil sqlUtil = getSqlUitl();
		sqlUtil.insert(sql);
		sqlUtil.Close();
	}

	public static boolean isInIndustryServiceTable(int industryId, String serviceId) throws SQLException {
		MySqlUtil sqlUtil = getSqlUitl();
		String sql = "SELECT COUNT(*) AS COUNT  FROM zhubajie_qicai.qc_industry_service WHERE industry_id = "
				+ industryId + " AND service_id = '" + serviceId + "'";
		ResultSet result = sqlUtil.Query(sql);
		while (result.next()) {
			if (result.getInt("count") > 0) {
				return true;
			}
		}
		sqlUtil.Close();
		return false;
	}

	public static void deleteAllIndustryService(int id) throws SQLException {
		MySqlUtil sqlUtil = getSqlUitl();
		String sql = "DELETE FROM zhubajie_qicai.qc_industry_service where id > " + id;
		System.out.println(sql);
		sqlUtil.delete(sql);
		sqlUtil.Close();
	}

	public static void deleteSingleIndustryService(int industry_id) throws SQLException {
		MySqlUtil sqlUtil = getSqlUitl();
		String sql = "DELETE FROM zhubajie_qicai.qc_industry_service where industry_id = " + industry_id;
		System.out.println(sql);
		sqlUtil.delete(sql);
		sqlUtil.Close();
	}

	public static int getUserIndustryId(String userId) throws SQLException {
		if (isUserIdExist(userId)) {
			MySqlUtil sqlUtil = getSqlUitl();
			String sql = "SELECT com_industry FROM zhubajie_ecrm.ec_employer_info where user_id = " + userId;
			ResultSet result = sqlUtil.Query(sql);
			while (result.next()) {
				return result.getInt("com_industry");
			}
		} else {
			System.out.println("用户id：" + userId + "不存在！");
		}
		return 0;
	}

	public static boolean isUserIdExist(String userId) throws SQLException {
		MySqlUtil sqlUtil = getSqlUitl();
		String sql = "SELECT COUNT(*) AS COUNT FROM zhubajie_member.mb_account WHERE user_id = " + userId;
		ResultSet result = sqlUtil.Query(sql);
		while (result.next()) {
			if (result.getInt("count") > 0) {
				return true;
			}
		}
		return false;
	}

	public static MySqlUtil getSqlUitl() {
		MySqlUtil sqlUtil = new MySqlUtil("172.20.20.104:3306", "root", "zhubajie");
		sqlUtil.Connect();
		return sqlUtil;
	}
}
