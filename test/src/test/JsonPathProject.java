package test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.jayway.restassured.path.json.JsonPath;

import tools.HttpUtil;
import tools.Utils;

public class JsonPathProject {
	public static void main(String[] args) throws IOException {
		String url1 = "http://m.test.zbjdev.com/user/getUserInfoCenterTask?page=1&size=10&product=3&status=0";
		Map<String, String> header = new HashMap<>();
		String cookie = Utils.getUserKey("23569494");
		header.put("Cookie", cookie);

		String json = HttpUtil.get(url1, header);
		System.out.println(json);

		JsonPath jp = new JsonPath(json);
		System.out.println(jp.getInt("errCode"));
		System.out.println(jp.getString("errMsg"));
		System.out.println(jp.getMap("data"));

	}
}
