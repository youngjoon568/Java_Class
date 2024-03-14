package Quiz_Java;

//  Airplane은 멤버 변수로 name을 가지고 있습니다. 
//  생성자로 이름을 입력받아 초기화 받게 설정하고, 
//  메서드는 takeOff(), fly(), land() 3가지를 가지고 있습니다.
// 
// 1. Airplane을 생성 상속 받습니다. 생성자는 이름을 받아서 초기화
// 2. flyMode는 int형 변수로 선언합니다.
// 3. 
//  - fly() 메서드를 오버라이딩 합니다.
//  - fly() 메서드 안에서는 flyMode가 1이면 "고속 모드로 비행합니다." 출력
//  - flyMode가 0이라면, super를 통해 부모님의 메서드를 호출

class Airplane {
	String name;

	public Airplane(String name) {
		this.name = name;
	}

	public void takeOff() {
		System.out.println(name + " 이륙");
	}

	public void fly() {
		System.out.println(name + " 비행");
	}

	public void land() {
		System.out.println(name + " 착륙");
	}
}

class SuperSonicAp extends Airplane {
	int flyMode;

	public SuperSonicAp(String name) {
		super(name);
	}

	@Override
	public void fly() {
		if (flyMode == 1) {
			System.out.println("고속 모드");
		} else if (flyMode == 0) {
			super.fly();
		} else {
			System.out.println("잘못된 모드입니다.");
		}
	}
}

public class Quiz_Airplane {
	public static void main(String[] args) {
		SuperSonicAp airplane = new SuperSonicAp("비행기");

		airplane.flyMode = 0;

		airplane.takeOff();
		airplane.fly();
		airplane.land();
	}
}
