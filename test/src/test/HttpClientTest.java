package test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import tools.HttpClientUtil;

public class HttpClientTest {
	@Test
	public void testGet() throws ClientProtocolException, IOException {
		String url = "http://m.zbj.com/user/getUserInfoCenterTask?page=1&size=10&product=3&status=0";
		System.out.println(HttpClientUtil.sendGet(url));
	}

	@Test
	public void testGetWithHeader() throws ClientProtocolException, IOException {
		String url = "http://m.zbj.com/user/getUserInfoCenterTask?page=1&size=10&product=3&status=0";
		Map<String, String> headers = new HashMap<>();
		headers.put("Cookie",
				"userkey=kuxmCunleO2Mm6mXFiVkXPAoj5lCYIw6yiDIzT9fMA06TV6kv3zXQz5yarnEpmqhEsWwB1Jn8RA%2BMopc1F4URN%2BNU%2FOSs04yV1EV%2Fl2LPcLG%2BVppgubAB4p4nIFITxmmRWy040zb8iT%2Ff2rVdtiJes58VaqTfPAdQT%2BQwJgU1yJxNOYsADOu6k3c4%2Fn1xboIwwrGjy1cgkSUx691PX9hOsF9vDu%2Bgz5%2BDxEXvRsgEWCLe6D71tx6BC1X%2F3Yj9ls%2BXaqnJ8z6QFeRkauOW1tJCPWSYnAXW4iJMDRoosLrI3DlXMTKNqrQqMD1A1z5UvOb3TMcEawspp%2BArJZs");
		System.out.println(HttpClientUtil.sendGet(url, headers));
	}

	@Test
	public void testPost() throws ClientProtocolException, IOException {
		String url = "http://buyer.zbj.com/service/search/v2";
		Map<String, Object> json = new HashMap<>();
		json.put("dk",
				"eyJpbWVpIjoiMjNCRTcwNjItQjIxMS00NTJFLTlCRTUtRUU1RkIzNkNBQTQ0IiwicGhvbmVfb3NfdmVyc2lvbiI6IjExLjAiLCJjbGllbnRfdHlwZSI6IjEiLCJjbGllbnRfdmVyc2lvbiI6IjUuNC4yIiwic29mdF9mcm9tIjoiYXBwbGUuY29tIiwiZGV2aWNlX2tleSI6IihudWxsKSIsInBob25lX3R5cGUiOiIyIiwiYnVuZGxlX3ZlcnNpb24iOiI1LjQuMiJ9");
		json.put("keyword", "logo设计");
		json.put("page", "0");
		json.put("pagesize", "10");

		System.out.println(HttpClientUtil.sendPost(url, json));

	}

	@Test
	public void testSendGetHeader() throws ClientProtocolException, IOException {
		String url = "http://task.e1.zbjdev.com/api/login?uid=23569494";
		Header[] headers = HttpClientUtil.sendGetHeader(url);
		for (Header value : headers) {
			if (value.getValue().contains("userkey")) {
				System.out.println(value.getValue().split(";")[0]);
				break;
			}
		}
	}

}
