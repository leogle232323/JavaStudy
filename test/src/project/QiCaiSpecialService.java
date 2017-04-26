package project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import tools.MySqlUtil;

/**
 * 企采行业专属服务
 */
public class QiCaiSpecialService {
	public static void main(String[] args) throws SQLException {
		int count = 10;
		int industryId = getUserIndustryId("18");
		List<String> service = getTianPengService();
		int maxId = getMaxId();
		for (int i = 0; i < count; i++) {
			int id = maxId + i + 1;
			for (int j = 0; j < service.size(); j++) {
				if (!isInIndustryServiceTable(industryId, service.get(j))) {
					insertService(id, QiCaiRecommendService.getGuid(), industryId, service.get(j));
					break;

				}
			}
		}

		deleteIndustryService(5);
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

	public static int getMaxId() throws SQLException {
		MySqlUtil sqlUtil = getSqlUitl();
		String sql = "SELECT id FROM zhubajie_qicai.qc_industry_service ORDER BY id DESC LIMIT 1";
		ResultSet result = sqlUtil.Query(sql);
		while (result.next()) {
			return result.getInt("id");
		}
		return 0;
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
			if (!isInIndustryServiceTable(getUserIndustryId("18"), strService[i])) {
				return strService[i];
			}
		}
		return service;

	}

	public static void insertService(int id, String guid, int industryId, String serviceId) throws SQLException {
		Random ran = new Random();
		int sequence = ran.nextInt(1000);
		String sql = "INSERT INTO zhubajie_qicai.qc_industry_service(`id`, `create_guid`, `create_time`, `update_time`, `industry_id`, `service_id`, `sequence`, `manager_id`, `manager_name`) VALUES("
				+ id + ",'" + guid + "',SYSDATE(),SYSDATE()," + industryId + ",'" + serviceId + "'," + sequence
				+ ",'55','王露')";
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

	public static void deleteIndustryService(int count) throws SQLException {
		MySqlUtil sqlUtil = getSqlUitl();
		String sql = "DELETE FROM zhubajie_qicai.qc_industry_service where id > " + count;
		System.out.println(sql);
		sqlUtil.delete(sql);
		sqlUtil.Close();
	}

	public static int getUserIndustryId(String userId) throws SQLException {
		MySqlUtil sqlUtil = getSqlUitl();
		String sql = "SELECT com_industry FROM zhubajie_ecrm.ec_employer_info where user_id = " + userId;
		ResultSet result = sqlUtil.Query(sql);
		while (result.next()) {
			return result.getInt("com_industry");
		}
		return 0;
	}

	public static MySqlUtil getSqlUitl() {
		MySqlUtil sqlUtil = new MySqlUtil("172.20.20.104", "root", "zhubajie");
		sqlUtil.Connect();
		return sqlUtil;
	}
}
