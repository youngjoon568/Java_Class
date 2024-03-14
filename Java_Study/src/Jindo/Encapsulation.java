package Jindo;

// 캡슐화는 접근 제한자를 이용하여 접근 제한하는 경우
// - 외부에서 직접 변수에 접근하지 못한다.
// - 직접 접근이 되지 않으니 메서드를 통해서 변수의 값을 변경 및 참조해야 한다.
// 사용 이유
// - 잘못된 값을 변수에 할당하려는 걸 방지함
// - 접근 권한이 없는 사용자에 의한 데이터 접근을 방지함

// 사용 방법
// 변수 선언 앞에 private
// 메서드 선언 앞에 public (getter / setter)
// 변수 뿐만 아니라 클레스 안에서만 사용하는 메서드들에 대해서도 private 설정 가능하고
// 이를 외부에서 사용할 때도 동일한 방식을 사용할 수 있음

public class Encapsulation {
	public static void main(String[] args) {

//		DateBadCase badBirth = new DateBadCase();
//		badBirth.day = 32;
//
//		System.out.println(badBirth.day);
		DateGoodCase goodBirth = new DateGoodCase();

		goodBirth.setDay(31);

		System.out.println(goodBirth.getDay());

	}
}

class DateBadCase {
	public int day;
	public int month;
	public int year;
}

class DateGoodCase {
	private int day;
	private int month;
	private int year;
	private final int MAX_DAY = 31;
	private final int MIN_DAY = 1;

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		if ((day > MAX_DAY) || (day < MIN_DAY)) {
			this.day = 1;
			System.out.println("잘못된 날짜 입력입니다.");
		} else {
			this.day = day;
		}
	}
}
