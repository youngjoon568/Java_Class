package Jindo;

import obj.modifier.Super;

public class ModifierExample01 {
	public static void main(String[] args) {
		Super sup = new Super();

		System.out.println("num1 : " + sup.num1);
		// protected는 부모 자식 관계에서만 사용할 수 있음(상속)
		// private는 선언된 클레스에서만 사용 가능
		// default는 패키지 내에서만 사용 가능
//		System.out.println("num2 : " + sup.num2);
//		System.out.println("num3 : " + sup.num3);
		System.out.println("num4 : " + sup.getNum4());
	}
}
