package test;

import java.io.IOException;
import java.util.HashMap;
import org.json.simple.JSONObject;
import com.jayway.restassured.path.json.JsonPath;
import tools.HttpUtil;


public class JsonPathProject {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws IOException{
		String url1 = "http://wxfws.t4.zbjdev.com/seller/user/login";
		JSONObject para1 = new JSONObject();
		para1.put("jpcode", "YnttwN1bP0d25YQyhc3fB%2F8frSZOH3ZS%2FQydEebbfNAh4FiNmC4ajdWz586K2CGV3CIIN7iuxYR9Oa7bd4fp1Y1vgcX0PEgnWPz1Drpjuu3t8aoWs4ola%2B0T39xtKkjpBazjl4uUH2bP0CqVilKnI6g8me92EhsEmAG%2FQU3c0p%2F5WrqcEWU%2FUhurNv3WHZd4uRuI1kPNRaDxohQsjfP%2F4w%3D%3D");
		para1.put("dk","eyJpbWVpIjoiNzZDMjRGQjMtNTg3MC00NUUwLUI2MEItMjVEMUUwNzRCRDQ1IiwicGhvbmVfb3NfdmVyc2lvbiI6IjEwLjAuMSIsImNsaWVudF90eXBlIjoiMyIsImNsaWVudF92ZXJzaW9uIjoiNC4yLjQiLCJzb2Z0X2Zyb20iOiJhcHBsZS5jb20iLCJkZXZpY2Vfa2V5IjoiOGQ5NDlmNmFlZjY2ZWYyYWIzY2NlNzFhYmFhYmMxNzY3MGExMzg5MmYxNDhkMDQ1ZThkZmE2YWFjZDZjYjZlYyIsInBob25lX3R5cGUiOiIyIn0=");
	
		String json = HttpUtil.post(url1, para1.toJSONString());
		System.out.println(json);
		
		JsonPath jp = new JsonPath(json);
		System.out.println((int)jp.get("errCode"));
		System.out.println((String)jp.getString("errMsg"));
		System.out.println(((HashMap)jp.get("data")).get("token"));
		System.out.println(((HashMap)jp.get("data")).get("mobile"));
	}
}
