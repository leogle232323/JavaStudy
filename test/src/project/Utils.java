package project;

import java.io.IOException;

import tools.HttpUtil;

public class Utils {
	public static void main(String[] args) throws IOException {
		System.out.println(getUserKey("23569494"));
	}

	/**
	 * 获取用户登录信息userkey
	 * 
	 * @param userId
	 * @return
	 * 
	 */
	public static String getUserKey(String userId) throws IOException {
		String url = "http://task.e1.tp.com/api/login?uid=" + userId;
		return HttpUtil.getHeaders(url).get("set-cookie").split(";")[0];
	}

	/**
	 * 设置代理(用于fiddler监听请求)
	 * 
	 */
	public static void setProxy() {
		System.setProperty("http.proxyHost", "localhost");
		System.setProperty("http.proxyPort", "8000");
		System.setProperty("https.proxyHost", "localhost");
		System.setProperty("https.proxyPort", "8000");
	}

}
