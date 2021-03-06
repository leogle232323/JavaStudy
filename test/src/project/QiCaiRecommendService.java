package project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import test.GUID;
import tools.MySqlUtil;

/**
 * 企业推荐服务
 */
public class QiCaiRecommendService {
	public static void main(String[] args) throws SQLException {
		int count = getRecommendServiceCount();

		// 插入服务（插满xx条）
		int requireCount = 10 - count;
		if (requireCount > 0) {
			for (int i = 0; i < requireCount; i++) {
				String service = getService();
				insertService(service);
			}
		}

		// 删除最后几条服务
		// deleteRecommendService(0);

		// 删除所有推荐服务
		// deleteAllRecommendService();
	}

	public static String getGuid() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
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

	public static String getServiceAvalible() throws SQLException {
		List<String> serviceList = getTianPengService();
		String service = null;
		for (int i = 0; i < serviceList.size(); i++) {
			if (!isInRecommendServiceTable(serviceList.get(i))) {
				return serviceList.get(i).toString();
			}
		}
		return service;
	}

	public static String getService() throws SQLException {
		String[] strService = { "1001965490", "1001970226", "1001970227", "1001970217", "1001968199", "1001970147",
				"1001965492", "1001970283", "1001971208", "1001971264", "1001969272", "1001969659", "1001970192",
				"1001970279", "1001970278", "1001970277", "1001965366", "1001965493", "1001965494", "1001965398",
				"1001968154", "1001968564", "1001970216", "1001970223", "1001970221", "1001965407", "1001965406",
				"1001968197", "1001968198", "1001968194", "1001968200", "1001970194", "1001970196", "1001970198",
				"1001970199" };
		String service = null;
		for (int i = 0; i < strService.length; i++) {
			if (!isInRecommendServiceTable(strService[i])) {
				return strService[i];
			}
		}
		return service;

	}

	public static int getRecommendServiceCount() throws SQLException {
		MySqlUtil sqlUtil = getSqlUitl();
		String qcRecommendServiceSql = "select count(*) AS count from zhubajie_qicai.qc_recommended_service";
		ResultSet result = sqlUtil.Query(qcRecommendServiceSql);
		int count = 0;
		while (result.next()) {
			count = result.getInt("count");
		}
		sqlUtil.Close();
		return count;
	}

	public static boolean insertService(String serviceId) throws SQLException {
		Random ran = new Random();
		int sequence = ran.nextInt(1000);
		String sql = "INSERT INTO zhubajie_qicai.qc_recommended_service(`id`, `create_guid`, `create_time`, `update_time`, `service_id`, `sequence`) VALUES(NULL,'"
				+ GUID.getGuid() + "',SYSDATE(),SYSDATE(),'" + serviceId + "'," + sequence + ")";
		System.out.println(sql);
		MySqlUtil sqlUtil = getSqlUitl();
		boolean isInserted = sqlUtil.insert(sql);
		sqlUtil.Close();
		return isInserted;
	}

	public static boolean isInRecommendServiceTable(String serviceId) throws SQLException {
		MySqlUtil sqlUtil = getSqlUitl();
		String sql = "SELECT service_id FROM zhubajie_qicai.`qc_recommended_service`";
		ResultSet result = sqlUtil.Query(sql);
		while (result.next()) {
			if (result.getString("service_id").equals(serviceId)) {
				return true;
			}
		}
		sqlUtil.Close();
		return false;
	}

	public static boolean deleteRecommendService(int count) throws SQLException {
		MySqlUtil sqlUtil = getSqlUitl();
		String sql = "DELETE FROM zhubajie_qicai.qc_recommended_service where id > "
				+ (getRecommendServiceCount() - count);
		boolean isDeleted = sqlUtil.delete(sql);
		System.out.println(sql);
		sqlUtil.Close();
		return isDeleted;
	}

	public static boolean deleteAllRecommendService() {
		MySqlUtil sqlUtil = getSqlUitl();
		String sql = "DELETE FROM zhubajie_qicai.qc_recommended_service";
		boolean isDeleted = sqlUtil.delete(sql);
		System.out.println(sql);
		sqlUtil.Close();
		return isDeleted;
	}

	public static MySqlUtil getSqlUitl() {
		MySqlUtil sqlUtil = new MySqlUtil("172.20.20.104:3306", "root", "zhubajie");
		sqlUtil.Connect();
		return sqlUtil;
	}
}
