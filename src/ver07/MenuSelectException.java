package ver07;

public class MenuSelectException extends Exception{
	
	public MenuSelectException() {
		super("잘못 입력했습니다.(1~5숫자 벗어남)");
	}
	

}
