package tools;

import java.io.IOException;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class HttpUtil {
	static OkHttpClient client = new OkHttpClient();
	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
	
	/**
	 * get请求
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
	 * post提交Json数据
	 * @param url
	 * @param json
	 * @return 
	 * @throws IOException
	 */
	public static String post(String url, String json) throws IOException {
	    RequestBody body = RequestBody.create(JSON, json);
	    Request request = new Request.Builder().url(url).post(body).build();
	    Response response = client.newCall(request).execute();
	       
	    if(response.isSuccessful()) {
	        return response.body().string();
	    }else {
	        throw new IOException("Unexpected code " + response);
	    }
	       
	}
	
}
