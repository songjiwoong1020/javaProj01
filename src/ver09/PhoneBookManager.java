package ver09;

import java.util.Scanner;

public class PhoneBookManager extends ConnectImpl{
	
	Scanner scanner = new Scanner(System.in);
	
	public PhoneBookManager() {
		super("kosmo", "1234");
	}
	
	//메뉴출력
	public void printMenu(){
		
		System.out.println("선택하세요...");
		System.out.println("1.데이터 입력");
		System.out.println("2.데이터 검색");
		System.out.println("3.데이터 삭제");
		System.out.println("4.주소록 출력");
		System.out.println("5.프로그램 종료");
		System.out.print("선택 : ");
		
	}
	
	@Override
	public void dataInput() {
		
		try {
		String query = "INSERT INTO phonebook_tb VALUES (?, ?, ?)";
		
		psmt = con.prepareStatement(query);
		
		System.out.println("데이터 입력을 시작합니다..");
		System.out.print("이름 : ");
		String name = scanner.nextLine();
		System.out.print("전화번호 : ");
		String phone = scanner.nextLine();
		System.out.print("생년월일 : ");
		String birth = scanner.nextLine();
		
		psmt.setString(1, name);
		psmt.setString(2, phone);
		psmt.setString(3, birth);
		
		System.out.println(psmt.executeUpdate() + "행이 입력되었습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void dataSearch() {
		try {
			System.out.print("검색할 이름 : ");
			String search = scanner.nextLine();
			
			stmt = con.createStatement();
			
			String query = "SELECT name, phoneNumber, birthday FROM phonebook_tb where name = " + search;
				
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				String name = rs.getString("name");
				String phoneNumber = rs.getString("phoneNumber");
				String birthday = rs.getString("birthday");
				System.out.printf("%-5s %-10s %-10s\n", name, phoneNumber, birthday);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public void dataDelete() {
		try {
			String query = "DELETE FROM phonebook_tb WHERE name = ?";
			
			psmt = con.prepareStatement(query);
			System.out.print("삭제할 이름 : ");
			String name = scanner.nextLine();
			psmt.setString(1, name);
			System.out.println(psmt.executeUpdate() + "행이 삭제되었습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void dataAllShow() {
		
		try {
			stmt = con.createStatement();
			
			String query = "SELECT name, phoneNumber, birthday FROM phonebook_tb";
				
			rs = stmt.executeQuery(query);
			System.out.println("-이름-    -전화번호-   -생년월일-");
			while(rs.next()) {
				String name = rs.getString("name");
				String phoneNumber = rs.getString("phoneNumber");
				String birthday = rs.getString("birthday");
				System.out.printf("%-5s %-10s %-10s\n", name, phoneNumber, birthday);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
