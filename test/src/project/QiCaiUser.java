package project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tools.MySqlUtil;

public class QiCaiUser {

	public static void main(String[] args) throws SQLException {
		// 判断企采用户是不是在企业用户表中，如果不在，删除该用户
		List<String> qiCaiUsers = getQiCaiUsers();
		for (int i = 0; i < qiCaiUsers.size(); i++) {
			if (!isQiCaiQYUser(qiCaiUsers.get(i))) {
				deleteQiCaiUser(qiCaiUsers.get(i));
			}
		}
	}

	public static List<String> getQiCaiUsers() throws SQLException {
		MySqlUtil sqlUtil = getSqlUitl();
		String sql = "SELECT user_id FROM zhubajie_qicai.qc_user";
		ResultSet result = sqlUtil.Query(sql);
		List<String> listUsers = new ArrayList<>();
		while (result.next()) {
			listUsers.add(result.getString("user_id"));
		}
		sqlUtil.Close();
		return listUsers;
	}

	public static boolean deleteQiCaiUser(String userId) {
		MySqlUtil sqlUtil = getSqlUitl();
		String sql = "delete FROM zhubajie_qicai.qc_user where user_id = " + userId;
		System.out.println(sql);
		boolean isDelete = sqlUtil.delete(sql);
		sqlUtil.Close();
		return isDelete;
	}

	public static boolean isQiCaiQYUser(String userId) throws SQLException {
		MySqlUtil sqlUtil = getSqlUitl();
		String sql = "SELECT com_industry FROM zhubajie_ecrm.ec_employer_info WHERE user_id = " + userId;
		ResultSet result = sqlUtil.Query(sql);
		while (result.next()) {
			if (result.getInt("com_industry") > 0) {
				return true;
			}
		}
		sqlUtil.Close();
		return false;

	}

	public static MySqlUtil getSqlUitl() {
		MySqlUtil sqlUtil = new MySqlUtil("172.20.20.104", "root", "zhubajie");
		sqlUtil.Connect();
		return sqlUtil;
	}
}
