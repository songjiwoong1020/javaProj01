import java.util.InputMismatchException;
import java.util.Scanner;

import ver06.MenuItem;
import ver06.MenuSelectException;
import ver06.PhoneBookManager;

public class PhoneBookVer06 implements MenuItem{

	public static void main(String[] args) {
		
		PhoneBookManager pm = new PhoneBookManager();
		MenuSelectException ex = new MenuSelectException();
		
		while(true) {
			Scanner scanner = new Scanner(System.in);
			
			try {
				pm.printMenu();
				int user = ex.userNum();
//				scanner.nextLine();
				
				if(user == dataInput) {
					pm.dataInput();
				} else if(user == dataSearch) {
					pm.dataSearch();
				} else if(user == dataDelete) {
					pm.dataDelete();
				} else if(user == dataAllShow) {
					pm.dataAllShow();
				} else if(user == end) {
					System.out.println("프로그램을 종료합니다.");
					scanner.close();
					break;
				}
			}
			catch(MenuSelectException e) {
				System.out.println(e.getMessage());
			}
			catch(InputMismatchException e) {
				System.out.println("잘못 입력했습니다.");
			}
		}
	}
}
