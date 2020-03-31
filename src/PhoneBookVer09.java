import java.util.InputMismatchException;
import java.util.Scanner;

import ver09.PhoneBookManager;

public class PhoneBookVer09 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("id : ");
		String id = scanner.nextLine();
		System.out.print("pass : ");
		String pass = scanner.nextLine();

		PhoneBookManager pm = new PhoneBookManager(id, pass);
		
		pm.test();
		
		while(true) {
			
			try {
				pm.printMenu();
				int user = scanner.nextInt();
				scanner.nextLine();
				
				if(user == 1) {
					pm.dataInput();
				} else if(user == 2) {
					pm.dataSearch();
				} else if(user == 3) {
					pm.dataDelete();
				} else if(user == 4) {
					pm.dataAllShow();
				} else if(user == 5) {
					System.out.println("프로그램을 종료합니다.");
					pm.close();
					scanner.close();
					break;
				} else {
					System.out.println("잘못 입력했습니다.");
				}
			}
			catch(InputMismatchException e) {
				System.out.println("잘못 입력했습니다.");
				scanner = new Scanner(System.in);
			}
		}
	}
}
