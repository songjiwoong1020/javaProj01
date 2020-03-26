package ver03;

import java.util.Scanner;

public class PhoneBookManager {
	
	Scanner scanner = new Scanner(System.in);
	PhoneInfo[] phoneInfo = new PhoneInfo[99];
	int dataNum = 0;
	
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
	
	//입력
	public void dataInput() {
		
		System.out.println("데이터 입력을 시작합니다..");
		System.out.print("이름 : ");
		String name = scanner.nextLine();
		System.out.print("전화번호 : ");
		String phone = scanner.nextLine();
		System.out.print("생년월일 : ");
		String birth = scanner.nextLine();
		
		phoneInfo[dataNum] = new PhoneInfo(name, phone, birth);
		dataNum++;
		System.out.println("데이터 입력이 완료되었습니다.");
	}
	
	//검색
	public void dataSearch() {
		
		System.out.println("데이터 검색을 시작합니다.");
		System.out.print("이름 : ");
		String search = scanner.nextLine();
		boolean a = false;
		
		for(int i=0; i<dataNum; i++) {
			if(search.equals(phoneInfo[i].name)) {
				phoneInfo[i].showPhoneInfo();
				System.out.println("데이터 검색이 완료되었습니다.");
				a = true;
			}
		}
		if(!a) System.out.println("입력하신 정보와 일치하는 정보가 없습니다.");
	}
	
	//삭제
	public void dataDelete() {
		
		System.out.println("데이터 삭제를 시작합니다.");
		System.out.print("이름 : ");
		String delete = scanner.nextLine();
		boolean a = false;
		
		for(int i=0; i<dataNum; i++) {
			if(delete.equals(phoneInfo[i].name)) {
				phoneInfo[i] = null;
				System.out.println("데이터 삭제가 완료되었습니다.");
				
				for(int j=i; j<dataNum; j++)
				phoneInfo[i] = phoneInfo[i+1];
				dataNum--;
				a = true;
			}
		}
		if(!a) System.out.println("입력하신 정보와 일치하는 정보가 없습니다.");
		
	}
	
	//주소록 전체출력
	public void dataAllShow() {
		
		if(dataNum == 0) {
			System.out.println("입력된 정보가 없습니다.");
		} else {
			System.out.println("전제정보를 출력합니다.");
			
			for(int i=0; i<dataNum; i++) {
				
				phoneInfo[i].showPhoneInfo();
			}
		}
		
	}
}
