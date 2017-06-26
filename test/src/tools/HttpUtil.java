package tools;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpUtil {
	static OkHttpClient client = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
			.readTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS).build();
	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

	/**
	 * get请求，请求不带投标参数
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static String get(String url) throws IOException {
		Request request = new Request.Builder().url(url).build();
		Response response = client.newCall(request).execute();
		if (response.isSuccessful()) {
			return response.body().string();
		} else {
			throw new IOException("Unexpected code " + response);
		}
	}

	/**
	 * get请求，请求带头部参数
	 * 
	 * @param url
	 * @param headers
	 * @return
	 * @throws IOException
	 */
	public static String get(String url, Map<String, String> headers) throws IOException {
		Builder builder = new Builder();
		for (String key : headers.keySet()) {
			builder.addHeader(key, headers.get(key));
		}

		Request request = builder.url(url).build();
		Response response = client.newCall(request).execute();

		if (response.isSuccessful()) {
			return response.body().string();
		} else {
			throw new IOException("Unexpected code " + response);
		}
	}

	/**
	 * get请求，获取响应头部
	 * 
	 * @param url
	 * @return
	 * @exception IOException
	 */
	public static Headers getHeaders(String url) throws IOException {
		Request request = new Request.Builder().url(url).build();
		Response response = client.newCall(request).execute();
		if (response.isSuccessful()) {
			return response.headers();
		} else {
			throw new IOException("Unexpected code " + response);
		}
	}

	/**
	 * post提交Json数据
	 * 
	 * @param url
	 * @param json
	 * @return
	 * @throws IOException
	 */
	public static String post(String url, String json) throws IOException {
		RequestBody body = RequestBody.create(JSON, json);
		Request request = new Request.Builder().url(url).post(body).build();
		Response response = client.newCall(request).execute();

		if (response.isSuccessful()) {
			return response.body().string();
		} else {
			throw new IOException("Unexpected code " + response);
		}

	}

	/**
	 * post提交键值对
	 * 
	 * @param url
	 * @param body
	 * @return
	 * @throws IOException
	 */

	public static String post(String url, RequestBody body) throws IOException {
		Request request = new Request.Builder().url(url).post(body).build();
		Response response = client.newCall(request).execute();
		if (response.isSuccessful()) {
			return response.body().string();
		} else {
			throw new IOException("Unexpected code " + response);
		}
	}
}
