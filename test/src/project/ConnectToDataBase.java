package project;

import java.sql.ResultSet;
import java.sql.SQLException;

import tools.MySqlUtil;

public class ConnectToDataBase {
	private static final String USER_TESTING = "writer";
	private static final String PASSWORD_TESTING = "Bj3CYvoKsPUUMR8H";
	private static final String USER_TEST = "root";
	private static final String PASSWORD_TEST = "zhubajie";
	private static final String M1 = "172.20.20.102:3316";
	private static final String M2 = "172.20.20.102:3326";
	private static final String M3 = "172.20.20.102:3336";
	private static final String M4 = "172.20.20.102:3346";
	private static final String M5 = "172.20.20.102:3356";
	private static final String M6 = "172.20.20.102:3366";
	private static final String TEST = "172.20.20.104:3306";

	public static void main(String[] args) throws SQLException {
		MySqlUtil sqlUtil = getSqlUtilDataBaseM1();
		String sql = "SELECT COUNT(*) AS count FROM zhubajie_market.mk_task";
		ResultSet result = sqlUtil.Query(sql);
		while (result.next()) {
			System.out.println(result.getInt("count"));
		}
	}

	public static MySqlUtil getSqlUtilDataBaseM1() {
		MySqlUtil sqlUtil = new MySqlUtil(M1, USER_TESTING, PASSWORD_TESTING);
		sqlUtil.Connect();
		return sqlUtil;
	}

	public static MySqlUtil getSqlUtilDataBaseM2() {
		MySqlUtil sqlUtil = new MySqlUtil(M2, USER_TESTING, PASSWORD_TESTING);
		sqlUtil.Connect();
		return sqlUtil;
	}

	public static MySqlUtil getSqlUtilDataBaseM3() {
		MySqlUtil sqlUtil = new MySqlUtil(M3, USER_TESTING, PASSWORD_TESTING);
		sqlUtil.Connect();
		return sqlUtil;
	}

	public static MySqlUtil getSqlUtilDataBaseM4() {
		MySqlUtil sqlUtil = new MySqlUtil(M4, USER_TESTING, PASSWORD_TESTING);
		sqlUtil.Connect();
		return sqlUtil;
	}

	public static MySqlUtil getSqlUtilDataBaseM5() {
		MySqlUtil sqlUtil = new MySqlUtil(M5, USER_TESTING, PASSWORD_TESTING);
		sqlUtil.Connect();
		return sqlUtil;
	}

	public static MySqlUtil getSqlUtilDataBaseM6() {
		MySqlUtil sqlUtil = new MySqlUtil(M6, USER_TESTING, PASSWORD_TESTING);
		sqlUtil.Connect();
		return sqlUtil;
	}

	public static MySqlUtil getSqlUtilDataBaseTest() {
		MySqlUtil sqlUtil = new MySqlUtil(TEST, USER_TEST, PASSWORD_TEST);
		sqlUtil.Connect();
		return sqlUtil;
	}
}
