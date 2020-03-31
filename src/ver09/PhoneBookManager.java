package ver09;

import java.util.Scanner;

/**
null값 저장됨, 무결성제약조건 생김
 */
public class PhoneBookManager extends ConnectImpl{
	
	Scanner scanner = new Scanner(System.in);
	
	public PhoneBookManager(String id, String pass) {
		super(id, pass);
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
	
	public void test() {
		
//		System.out.println("test진입");//테이블이 없으면 만들어주고 싶었는데 한계를 느꼈습니다ㅎㅎ
		try {
			String query = "select count(*) from all_tables where table_name = upper('phonebook_tb')";
			
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(query);
			rs.next();
			
			int a = rs.getInt("count(*)");
			
			if(a == 0) {
				System.out.println("phonebook_tb 테이블이 없어서 종료합니다ㅠ.ㅠ");
				System.exit(0);
			} else if (a == 1) {
				System.out.println("테이블 존재");
			} else {
				System.out.println("나도 모르겟다.");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void dataInput() {//무결성 제약조건
		
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
			
			String query = "SELECT name, phoneNumber, birthday FROM phonebook_tb where name = '" + search + "'";
				
			rs = stmt.executeQuery(query);
			
			if(!rs.next()) {
				System.out.println("검색 결과가 없습니다.");
			} else {
				System.out.println("-이름-    -전화번호-   -생년월일-");
				while(rs.next()) {
					String name = rs.getString("name");
					String phoneNumber = rs.getString("phoneNumber");
					String birthday = rs.getString("birthday");
					System.out.printf("%-5s %-10s %-10s\n", name, phoneNumber, birthday);
				}
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
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
