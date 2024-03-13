package customerManager;

import java.util.Scanner;

public class CustomerManager {
	public static void main(String[] args) {
		Customer_Manager manager = new Customer_Manager();
		manager.run();
	}
}

class Customer_Manager {
	final int MAX = 100;
	String[] nameList = new String[MAX];
	String[] genderList = new String[MAX];
	String[] emailList = new String[MAX];
	int[] birthYearList = new int[MAX];
	int index = -1;
	int count = 0;

	Scanner scan = new Scanner(System.in);

	void run() {
		while (true) {
			System.out.printf("\n[INFO] 고객 수 : %d, 인덱스 : %d\n", count, index);
			System.out.println("메뉴를 입력하세요.");
			System.out.println("(I)nsert, (P)revious, (N)ext, (C)urrent, (U)pdate, (D)elete, (Q)uit");
			System.out.print("메뉴 입력 : ");
			String menu = scan.next();
			menu = menu.toLowerCase();

			switch (menu.charAt(0)) {
			case 'ㅑ':
			case 'i':
				System.out.println("고객 정보 입력을 시작합니다.");
				if (count >= MAX) {
					System.out.println("더 이상 저장할 수 없습니다. ");
				} else {

					insertCustomerData();
					System.out.println("고객 정보를 저장했습니다.");
				}
				break;
			case 'ㅔ':
			case 'p':
				System.out.println("이전 데이터를 출력합니다.");
				if (index <= 0) {
					System.out.println("이전 데이터가 존재하지 않습니다.");
				} else {
					index--;
					printCustomerData(index);
				}
				break;
			case 'ㅜ':
			case 'n':
				System.out.println("다음 데이터를 출력합니다.");
				if (index >= count - 1) {
					System.out.println("다음 데이터가 존재하지 않습니다.");
				} else {
					index++;
					printCustomerData(index);
				}
				break;
			case 'ㅊ':
			case 'c':
				System.out.println("현재 데이터를 출력합니다.");
				if ((index >= 0) && (index < count)) {
					printCustomerData(index);
				} else {
					System.out.println("출력할 데이터가 선택되지 않았습니다.");
				}
				break;
			case 'ㅕ':
			case 'u':
				break;
			case 'ㅇ':
			case 'd':
				break;
			case 'ㅂ':
			case 'q':
				System.out.println("프로그램을 종료합니다.");
				scan.close();
				System.exit(0);
				break;
			default:
				System.out.println("메뉴를 잘 못 입력했습니다. 다시 선택해 주세요");
			}
		}
	}

	void insertCustomerData() {
		System.out.print("이름 : ");
		String name = scan.next();
		System.out.print("성별 : ");
		String gender = scan.next();
		System.out.print("이메일 : ");
		String email = scan.next();
		System.out.print("출생년도 : ");
		int birthYear = scan.nextInt();

		nameList[count] = name;
		genderList[count] = gender;
		emailList[count] = email;
		birthYearList[count] = birthYear;
		count++;

	}

	void printCustomerData(int index) {
		System.out.println("==========CUSTOMER INFO==========");
		System.out.println("이름 : " + nameList[index]);
		System.out.println("성별 : " + genderList[index]);
		System.out.println("이메일 : " + emailList[index]);
		System.out.println("출생년도 : " + birthYearList[index]);
		System.out.println("=================================");
	}

	void updateCustomerData(int index) {
		System.out.println("-------UPDATE CUSTOMER INFO-------");
		System.out.print("이름(" + nameList[index] + ") :");
		String name = scan.nextLine();
		if (name.length() != 0) {
			nameList[index] = name;
		}
		System.out.print("성별(" + genderList[index] + ") : ");
		genderList[index] = scan.next();
		System.out.print("이메일(" + emailList[index] + ") : ");
		emailList[index] = scan.next();
		System.out.print("출생년도(" + birthYearList[index] + ") : ");
		birthYearList[index] = scan.nextInt();
	}

	void deleteCustomerData(int index) {
		for (int i = index; i < count - 1; i++) {
			nameList[i] = nameList[i + 1];
			genderList[i] = genderList[i + 1];
			emailList[i] = emailList[i + 1];
			birthYearList[i] = birthYearList[i + 1];
		}
		count--;
	}
}