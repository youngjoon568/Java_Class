package Jindo;

import obj.modifier.Super;

public class Sub extends Super {

	private int num5 = 50;

	public void print() {
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
//		System.out.println("num3 : " + num3);
		System.out.println("num4 : " + getNum4());
		System.out.println("num5 : " + num5);

	}
}
