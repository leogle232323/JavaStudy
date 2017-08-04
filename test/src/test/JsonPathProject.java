package test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.jayway.restassured.path.json.JsonPath;

import tools.HttpUtil;

public class JsonPathProject {
	public static void main(String[] args) throws IOException {
		String url1 = "http://m.zbj.com/user/getUserInfoCenterTask?page=1&size=10&product=3&status=0";
		Map<String, String> header = new HashMap<>();
		header.put("Cookie",
				"userkey=ro29QSm2fuvj6igOrbzS%2FCqsatIJuB7AwwTBiKqvDOaCfhAx3OAPJpeusXdeSjZ27TJXbxcc4ixtvjzeMKkO8jQcg3UYnzncu4AGNBw8JsiJPDAh0BM4WyvHFZukgKNBCmr1EpOFkwzxcl5n7ug8JR4C4oGsRMlqZf96Ezdm9qL9jh%2BvUcpMdDasef8f4zet3A7ggfAlHVcuOPYQfO9AUT9xlxhWZjAUNnd3%2BXlSnRYLoKfdWYla5fwMJEQGDJ1YX7QEVXMo8TtwkWxu8Ik7Jll2%2FCU8AJJuaOm%2FpfbAY%2FnHF6bDGR1gG4RJTsinSOPC48Aqm1H58Quwmuwk");

		String json = HttpUtil.post(url1, null, header);
		System.out.println(json);

		JsonPath jp = new JsonPath(json);
		System.out.println(jp.getInt("errCode"));
		System.out.println(jp.getString("errMsg"));
		System.out.println(jp.getMap("data"));
	}
}
