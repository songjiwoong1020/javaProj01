import java.util.Scanner;

import ver02.PhoneInfo;

public class PhoneBookVer02 {

	public static void main(String[] args) {
		
		while(true) {
			
			System.out.print("선택하세요...\n1.데이터 입력\n2.프로그램 종료\n선택 : ");
			Scanner scanner = new Scanner(System.in);
			try {
				int user = scanner.nextInt();
				scanner.nextLine();
				/*
				nextInt() 입력 후 엔터값이 남아있어서 다음 nextLine()를 사용할때 
				그냥 넘어가버리게 되는 경우가 발생한다. 근데nextLine() 다음 nextLine()을
				입력할경우에는 그런경우가 발생하지 않는다; 뭐지;
				 */
				if(user == 1) {
				System.out.print("이름 : ");
				String name = scanner.nextLine();
				System.out.print("전화번호 : ");
				String phone = scanner.nextLine();
				System.out.print("생년월일 : ");
				String birth = scanner.nextLine();
				PhoneInfo p1 = new PhoneInfo(name, phone, birth);
				System.out.println("입력된 정보 출력...");
				p1.showPhoneInfo();
				System.out.println();
				} else if(user == 2) {
					System.out.println("프로그램을 종료합니다.");
					scanner.close();
					break;
				} else {
					System.out.println("다른키는 입력이 안됩니다 ㅠㅠ");
				}
			}
			catch(Exception e) {
				System.out.println("다른키는 입력이 안됩니다 ㅠㅠ");
			}
		}
	}
}
