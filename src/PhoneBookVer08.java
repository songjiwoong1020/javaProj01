import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import ver08.MenuItem;
import ver08.MenuSelectException;
import ver08.PhoneBookManager;

public class PhoneBookVer08 implements MenuItem{

	public static void main(String[] args) throws IOException {
		
		PhoneBookManager pm = new PhoneBookManager();
		
		pm.load();//생성자와 같은역할일듯
		
		while(true) {
			Scanner scanner = new Scanner(System.in);
			
			try {
				pm.printMenu();
				int user = pm.userNum(scanner.nextInt());//사용자 정의 에러를 사용하기위해서 약간 이상하게 만든듯
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
//				System.out.println("\n=====사용자 정의 예외 실행됨=====\n");//마지막에 주석처리
				System.out.println(e.getMessage());
			}
			catch(InputMismatchException e) {
				System.out.println("잘못 입력했습니다.\n");
//				System.out.println("\n=====메뉴 선택 부분에서 InputMismatchException 발생=====\n");//마지막에 주석처리
			}

		}
	}
}
