package test;

public class AssertClass {

	public static void main(String[] args) {
		testAssert1(1);
		testAssert2(-1);
	}
	
	static void testAssert1(int i){
		assert i > 0;
	}
	
	static void testAssert2(int i){
		assert i > 0 : "这是断言信息...";
	}

}
