/**
 * 实现一个简单的英译汉翻译器，即通过英文单词得到它的中文含义（map实现）
 */

package test;

import java.util.HashMap;
import java.util.Map;

public class Compiler {
	public static void main(String[] args) {
		Map<String, String> mp = new HashMap<>();
		mp.put("hello", "你好");
		mp.put("haha", "哈哈");
		String str = null;
		if (mp.containsKey(str)) {
			System.out.println(str + "的汉语翻译是" + mp.get(str));
		} else {
			System.out.println("词库里没有这个单词");
		}
	}
}
