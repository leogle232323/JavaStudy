package project;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tools.ConnectToDataBase;
import tools.MySqlUtil;

public class ServiceUpdate {

	public static void main(String[] args) throws SQLException {
		// List<Integer> list = getTpUser();
		// Set<Integer> set = new HashSet<>(list);
		// System.out.println("zbj user" + set.size());
		// System.out.println("summary uer " + getZbjSummary().size());
		//
		// int sum = 0;
		// int sumIn = 0;
		// for (Integer var : set) {
		// if (!isInSummary(var)) {
		// sum++;
		// System.out.println(var + "not in");
		// } else {
		// sumIn++;
		// System.out.println(var + "in");
		// }
		// }
		//
		// System.out.println("xxx" + sum);
		// System.out.println("inin" + sumIn);

		// Map<BigInteger, Double> mpSm = getSummaryCash();
		// for (BigInteger var : mpSm.keySet()) {
		// System.out.println("user_id: " + var + " cash_amount " +
		// mpSm.get(var));
		// }

		Map<BigInteger, BigDecimal> mpRd = getRecordCashBalance();
		Map<BigInteger, BigDecimal> mpSm = getSummaryCash();
		BigDecimal cashRd = null;
		BigDecimal cashSm = null;
		for (BigInteger var : mpSm.keySet()) {
			cashSm = mpSm.get(var);
			cashRd = mpRd.get(var);
			if (cashRd == null) {
				if (cashSm.compareTo(new BigDecimal("0")) == 0) {
					// System.out.print("用户" + var + "不在record中");
					// System.out.println("summary表中cashamount为0");
				} else {
					System.out.print("用户" + var + "不在record中  ");
					System.out.println("summary表中cashamount不为0---------");
				}
			} else if (cashSm.compareTo(cashRd) == 0) {
				// System.out.println("用户" + var + "相等");
			} else {
				// System.out.println("用户" + var + "不相等");
			}

		}

	}

	public static List<Integer> getZbjUser() throws SQLException {
		List<Integer> list = new ArrayList<>();
		MySqlUtil mySql = ConnectToDataBase.getSqlUtilDataBaseM2();
		String sql = "SELECT * FROM zhubajie_member.mb_securitys_policy WHERE isTp = 0 AND state = 1 AND endymd > DATE_FORMAT(NOW(),'%Y-%m-%d') GROUP BY user_id";
		ResultSet result = mySql.Query(sql);
		while (result.next()) {
			list.add(result.getInt("user_id"));
		}
		return list;
	}

	public static List<Integer> getZbjSummary() throws SQLException {
		List<Integer> list = new ArrayList<>();
		MySqlUtil mySql = ConnectToDataBase.getSqlUtilDataBaseM2();
		String sql = "SELECT * FROM zhubajie_member.mb_deposit_summary ";
		ResultSet result = mySql.Query(sql);
		while (result.next()) {
			list.add(result.getInt("user_id"));
		}
		return list;
	}

	public static boolean isInSummary(int user_id) throws SQLException {
		List<Integer> listSum = getZbjSummary();

		if (listSum.toString().contains(Integer.valueOf(user_id).toString())) {
			return true;
		}
		// for (Integer varSum : listSum) {
		// if (user_id == varSum) {
		// return true;
		// }
		// }
		return false;
	}

	public static List<Integer> getTpUser() throws SQLException {
		List<Integer> list = new ArrayList<>();
		MySqlUtil mySql = ConnectToDataBase.getSqlUtilDataBaseM2();
		String sql = "SELECT * FROM zhubajie_member.mb_tpw_user_shop WHERE state = 1";
		ResultSet result = mySql.Query(sql);
		while (result.next()) {
			list.add(result.getInt("user_id"));
		}
		return list;
	}

	public static Map<BigInteger, BigDecimal> getRecordCashBalance() throws SQLException {
		MySqlUtil mySql = ConnectToDataBase.getSqlUtilDataBaseM2();
		String sql = "SELECT user_id,SUM(balance) as balance FROM zhubajie_member.mb_deposit_record WHERE state = 1 AND TYPE IN(1,3) GROUP BY user_id";
		ResultSet result = mySql.Query(sql);
		Map<BigInteger, BigDecimal> mp = new HashMap<>();
		while (result.next()) {
			mp.put(result.getBigDecimal("user_id").toBigInteger(), result.getBigDecimal("balance"));
		}
		return mp;
	}

	public static Map<BigInteger, BigDecimal> getSummaryCash() throws SQLException {
		MySqlUtil mySql = ConnectToDataBase.getSqlUtilDataBaseM2();
		String sql = "SELECT user_id,cash_amount FROM zhubajie_member.mb_deposit_summary WHERE state = 1";
		ResultSet result = mySql.Query(sql);
		Map<BigInteger, BigDecimal> map = new HashMap<>();
		while (result.next()) {
			map.put(result.getBigDecimal("user_id").toBigInteger(), result.getBigDecimal("cash_amount"));
		}
		return map;
	}

}
