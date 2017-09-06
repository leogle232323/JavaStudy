package test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UrlCode {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String encodeStr = URLEncoder.encode("+", "UTF-8");
		System.out.println(encodeStr);

		String decodeStr = URLDecoder.decode("eexMCORYEhWc4PGAqDVeUw%3D%3D", "UTF-8");
		System.out.println(decodeStr);
	}

}
