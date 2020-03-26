package ver06;

import java.util.Scanner;


public class MenuSelectException extends Exception{
	
	public MenuSelectException() {
		super("잘못 입력했습니다.(1~5숫자 벗어남)");
	}
	
	public int userNum() throws MenuSelectException{
		
		Scanner Scanner = new Scanner(System.in);
		int user = Scanner.nextInt();
		
		if(user<1 || user>5) {
			MenuSelectException ex = new MenuSelectException();
			throw ex;
		}
		return user;
	}
}
