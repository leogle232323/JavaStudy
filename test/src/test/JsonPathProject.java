package test;

import java.io.IOException;
import java.util.HashMap;
import org.json.simple.JSONObject;
import com.jayway.restassured.path.json.JsonPath;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.RequestBody;

import tools.HttpUtil;


public class JsonPathProject {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException{
		String url1 = "http://wxfws.zbj.com/seller/user/login";
		JSONObject para1 = new JSONObject();
		para1.put("jpcode", "c2yn2%2Fb%2FR4p91%2BOCKEFLBkW%2BRcoRyFSS%2B%2BRqHR35THMIdjtmUCj6cMRYDULSm1iMp3epWVnmSEFW3F4z9eXNMchIS7EsqzGP3Uc%2FjI30FYE%3D");
		para1.put("dk","eyJpbWVpIjoiNzZDMjRGQjMtNTg3MC00NUUwLUI2MEItMjVEMUUwNzRCRDQ1IiwicGhvbmVfb3NfdmVyc2lvbiI6IjEwLjAuMSIsImNsaWVudF90eXBlIjoiMyIsImNsaWVudF92ZXJzaW9uIjoiNC4yLjQiLCJzb2Z0X2Zyb20iOiJhcHBsZS5jb20iLCJkZXZpY2Vfa2V5IjoiOGQ5NDlmNmFlZjY2ZWYyYWIzY2NlNzFhYmFhYmMxNzY3MGExMzg5MmYxNDhkMDQ1ZThkZmE2YWFjZDZjYjZlYyIsInBob25lX3R5cGUiOiIyIn0=");
	
		String json = HttpUtil.post(url1, para1.toJSONString());
		System.out.println(json);
		
		JsonPath jp = new JsonPath(json);
		System.out.println(jp.getInt("errCode"));
		System.out.println(jp.getString("errMsg"));
		System.out.println(jp.getMap("data").get("token"));
		
		
		RequestBody body = new FormEncodingBuilder().add("userId", "19182358")
				.add("mstoken", "5faf0e7dfee2498597754f2b862bb41e9PsoAyIyHN2LnszLRinYO6QQhT8XrEXFsPgbOwKUxpINkPsp1dLiBE9q0DqAXeXA")
				.build();
		
		String res = HttpUtil.post("http://m.t4.zbjdev.com/bidpay/sendSms", body);
		System.out.println(res);
		
	}
}
