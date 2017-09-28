package tools;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.junit.Test;

public class HttpClientUtil {
	private static CloseableHttpClient client = HttpClients.createDefault();

	private static ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
		@Override
		public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
			int status = response.getStatusLine().getStatusCode();
			if (status >= 200 && status < 300) {
				HttpEntity entity = response.getEntity();
				return entity != null ? EntityUtils.toString(entity) : null;
			} else {
				throw new ClientProtocolException("Unexpected response status :" + status);
			}
		}
	};

	/**
	 * 发送get请求，无header
	 * 
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static String sendGet(String url) throws ClientProtocolException, IOException {
		HttpGet httpGet = new HttpGet(url);
		return client.execute(httpGet, responseHandler);
	}

	/**
	 * 发送get请求，有header
	 * 
	 * @throws IOException
	 * @throws ClientProtocolException
	 * 
	 */
	public static String sendGet(String url, Map<String, String> headers) throws ClientProtocolException, IOException {
		HttpGet httpGet = new HttpGet(url);
		for (String value : headers.keySet()) {
			httpGet.addHeader(value, headers.get(value));
		}
		return client.execute(httpGet, responseHandler);
	}

	/**
	 * 发送post请求
	 * 
	 * @throws IOException
	 * @throws ClientProtocolException
	 * 
	 */
	public static String sendPost(String url, JSONObject body) throws ClientProtocolException, IOException {
		HttpPost httpPost = new HttpPost(url);
		StringEntity entity = new StringEntity(body.toJSONString(), Charset.forName("UTF-8"));
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		httpPost.setEntity(entity);
		return client.execute(httpPost, responseHandler);
	}

	@Test
	public void testGet() throws ClientProtocolException, IOException {
		String url = "http://m.zbj.com/user/getUserInfoCenterTask?page=1&size=10&product=3&status=0";
		System.out.println(sendGet(url));
	}

	@Test
	public void testGetWithHeader() throws ClientProtocolException, IOException {
		String url = "http://m.zbj.com/user/getUserInfoCenterTask?page=1&size=10&product=3&status=0";
		Map<String, String> headers = new HashMap<>();
		headers.put("Cookie",
				"userkey=kuxmCunleO2Mm6mXFiVkXPAoj5lCYIw6yiDIzT9fMA06TV6kv3zXQz5yarnEpmqhEsWwB1Jn8RA%2BMopc1F4URN%2BNU%2FOSs04yV1EV%2Fl2LPcLG%2BVppgubAB4p4nIFITxmmRWy040zb8iT%2Ff2rVdtiJes58VaqTfPAdQT%2BQwJgU1yJxNOYsADOu6k3c4%2Fn1xboIwwrGjy1cgkSUx691PX9hOsF9vDu%2Bgz5%2BDxEXvRsgEWCLe6D71tx6BC1X%2F3Yj9ls%2BXaqnJ8z6QFeRkauOW1tJCPWSYnAXW4iJMDRoosLrI3DlXMTKNqrQqMD1A1z5UvOb3TMcEawspp%2BArJZs");
		System.out.println(sendGet(url, headers));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testPost() throws ClientProtocolException, IOException {
		String url = "http://buyer.zbj.com/service/search/v2";
		JSONObject json = new JSONObject();
		json.put("dk",
				"eyJpbWVpIjoiMjNCRTcwNjItQjIxMS00NTJFLTlCRTUtRUU1RkIzNkNBQTQ0IiwicGhvbmVfb3NfdmVyc2lvbiI6IjExLjAiLCJjbGllbnRfdHlwZSI6IjEiLCJjbGllbnRfdmVyc2lvbiI6IjUuNC4yIiwic29mdF9mcm9tIjoiYXBwbGUuY29tIiwiZGV2aWNlX2tleSI6IihudWxsKSIsInBob25lX3R5cGUiOiIyIiwiYnVuZGxlX3ZlcnNpb24iOiI1LjQuMiJ9");
		json.put("keyword", "logo设计");
		json.put("page", "0");
		json.put("pagesize", "10");

		System.out.println(sendPost(url, json));

	}
}
