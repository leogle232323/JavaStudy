package tools;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

import org.apache.http.Header;
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
	 * 发送get请求，无请求header
	 * 
	 * @param url
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static String sendGet(String url) throws ClientProtocolException, IOException {
		HttpGet httpGet = new HttpGet(url);
		return client.execute(httpGet, responseHandler);
	}

	/**
	 * 发送get请求，有请求header
	 * 
	 * @param url
	 * @param headers
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
	 * 发送get请求，获取响应header
	 */
	public static Header[] sendGetHeaders(String url) throws ClientProtocolException, IOException {
		HttpGet httpGet = new HttpGet(url);
		HttpResponse response = client.execute(httpGet);
		return response.getAllHeaders();
	}

	/**
	 * 发送post请求，json提交
	 * 
	 * @param url
	 * @param body
	 * @throws IOException
	 * @throws ClientProtocolException
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static String sendPost(String url, Map<String, Object> body) throws ClientProtocolException, IOException {
		HttpPost httpPost = new HttpPost(url);
		JSONObject json = new JSONObject();
		json.putAll(body);
		StringEntity entity = new StringEntity(json.toJSONString(), Charset.forName("UTF-8"));
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		httpPost.setEntity(entity);
		return client.execute(httpPost, responseHandler);
	}
}
