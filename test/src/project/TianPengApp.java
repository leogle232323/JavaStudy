package project;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import tools.HttpUtil;

public class TianPengApp {
	static OkHttpClient client = new OkHttpClient.Builder().build();

	public static void main(String[] args) throws IOException {
		Utils.setProxy();
		System.out.println(getFavoriteService("23569494"));
		System.out.println(getFavoriteShop("23569494"));
	}

	/**
	 * 获取用户服务收藏
	 */
	public static String getFavoriteService(String userId) throws IOException {
		String url = "http://wireless.test.tpdev.net/user/favoriteService/?page=0&pageSize=10&type=1";
		String userkey = Utils.getUserKey(userId);
		Map<String, String> headers = new HashMap<>();
		headers.put("Cookie", userkey);
		return HttpUtil.get(url, headers);
	}

	/**
	 * 获取用户店铺收藏
	 */
	public static String getFavoriteShop(String userId) throws IOException {
		String url = "http://wireless.test.tpdev.net/user/favoriteShop/?page=0&pageSize=10";
		String userkey = Utils.getUserKey(userId);
		Map<String, String> headers = new HashMap<>();
		headers.put("Cookie", userkey);
		return HttpUtil.get(url, headers);
	}
}
