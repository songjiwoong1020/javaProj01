import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import ver08.MenuItem;
import ver08.MenuSelectException;
import ver08.PhoneBookManager;

public class PhoneBookVer08 implements MenuItem{

	public static void main(String[] args) throws IOException {
		
		PhoneBookManager pm = new PhoneBookManager();
		
		pm.load();
		
		while(true) {
			Scanner scanner = new Scanner(System.in);
			
			try {
				pm.printMenu();
				int user = pm.userNum(scanner.nextInt());
				scanner.nextLine();
				
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
					pm.save();
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
