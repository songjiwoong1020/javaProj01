package ver08;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


public class PhoneBookManager implements SubMenuItem{
	
	
	HashSet<PhoneInfo> phoneInfo = new HashSet<PhoneInfo>();
	Scanner scanner = new Scanner(System.in);
	int dataNum;
	
	/*******************************************************************
	 * 
	 * 저장 한거 불러오는거 너무 어렵다.
	 * 
	 */
	public void load() {
		try {
		ObjectInputStream in = 
				new ObjectInputStream(
						new FileInputStream("src/ver08/PhoneBook.obj"));
		HashSet<PhoneInfo> phoneInfo1 = (HashSet<PhoneInfo>)in.readObject();
		in.close();
		
		Iterator itr = phoneInfo1.iterator();
			while(itr.hasNext()) {
				PhoneInfo phoneInfo = (PhoneInfo) itr.next();
				System.out.println(phoneInfo.name);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	//저장
	public void save() {
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("src/ver08/PhoneBook.obj"));
			
			out.writeObject(phoneInfo);
			out.close();
		}
		catch (Exception e) {
			System.out.println("예외발생");
			e.printStackTrace();
		}
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
	
	public int overlap() {
		System.out.println("덮어 씌우시겠습니까? \n(입력 취소:1 덮어씌우기:2)");
		System.out.print("선택 : ");
		
		int overlap = 0;
		
		try {
			overlap = scanner.nextInt();
			
			if(overlap == 1) {
				System.out.println("입력을 취소합니다");
				return overlap;
			}else if(overlap == 2) {
				return overlap;
			}
		}
		catch(Exception e) {
			System.out.println("잘못 입력했습니다.");
		}
		
		return overlap;
	}
	
	//입력
	public void dataInput() {
		
		System.out.println("데이터 입력을 시작합니다..");
		while(true) {
			try {
				System.out.println("1.일반, 2.동창, 3.회사, 4.뒤로가기 \n선택>>");
				int user = scanner.nextInt();
				scanner.nextLine();
				
				if(user == normal) {
					System.out.print("이름 : ");
					String name = scanner.nextLine();
					System.out.print("전화번호 : ");
					String phone = scanner.nextLine();
					if(!phoneInfo.add(new PhoneInfo(name, phone))) {
						System.out.println("동일한 이름의 정보가 존재합니다.");
						int test = overlap();
						if(test == 2) {
							phoneInfo.remove(new PhoneInfo(name, phone));
							phoneInfo.add(new PhoneInfo(name, phone));
							System.out.println("기존 데이터를 삭제하고 새로운 데이터를 덮어씁니다.");
						}
					} else {
					dataNum++;
					System.out.println("데이터 입력이 완료되었습니다.");
					}
					break;
				
				} else if(user == schoolmate) {
					
					System.out.print("이름 : ");
					String name = scanner.nextLine();
					System.out.print("전화번호 : ");
					String phone = scanner.nextLine();
					System.out.print("전공 : ");
					String major = scanner.nextLine();
					System.out.print("학년 : ");
					int grade = scanner.nextInt();
					
					if(!phoneInfo.add(new PhoneSchoolInfo(name, phone, major, grade))) {
						System.out.println("동일한 이름의 정보가 존재합니다.");
						int test = overlap();
						if(test == 2) {
							phoneInfo.remove(new PhoneSchoolInfo(name, phone, major, grade));
							phoneInfo.add(new PhoneSchoolInfo(name, phone, major, grade));
							System.out.println("기존 데이터를 삭제하고 새로운 데이터를 덮어씁니다.");
						}
					} else {
					dataNum++;
					System.out.println("데이터 입력이 완료되었습니다.");
					}
					break;
					
				} else if(user == co_Work) {
					
					System.out.print("이름 : ");
					String name = scanner.nextLine();
					System.out.print("전화번호 : ");
					String phone = scanner.nextLine();
					System.out.print("회사 : ");
					String company = scanner.nextLine();
					
					if(!phoneInfo.add(new PhoneCompanyInfo(name, phone, company))) {
						System.out.println("동일한 이름의 정보가 존재합니다.");
						int test = overlap();
						if(test == 2) {
							phoneInfo.remove(new PhoneCompanyInfo(name, phone, company));
							phoneInfo.add(new PhoneCompanyInfo(name, phone, company));
							System.out.println("기존 데이터를 삭제하고 새로운 데이터를 덮어씁니다.");
						}
					} else {
					dataNum++;
					System.out.println("데이터 입력이 완료되었습니다.");
					}
					break;
					
				} else if(user == back) {
					break;
				} else {
					System.out.println("잘못 입력했습니다.");
				}
			}
			catch(Exception e) {
				System.out.println("잘못 입력했습니다.");
				scanner = new Scanner(System.in);
			}
		}
	}
	
	//검색
	public void dataSearch() {
		
		System.out.println("데이터 검색을 시작합니다.");
		System.out.print("이름 : ");
		String search = scanner.nextLine();
		boolean a = false;

		for(PhoneInfo list : phoneInfo) {
			if(list.name.equals(search)) {
				list.showPhoneInfo();
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
		
		for(PhoneInfo list : phoneInfo) {
			if(list.name.equals(delete)) {
				phoneInfo.remove(list);
				dataNum--;
				a = true;
				System.out.println("데이터 삭제가 완료되었습니다.");
				break;
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
		
		for(PhoneInfo list : phoneInfo) {
			list.showPhoneInfo();
			}
		System.out.println("데이터 검색이 완료되었습니다.");
		}
		
	}
	
	//사용자 정의 에러
	public int userNum(int user) throws MenuSelectException{
		
		if(user<1 || user>5) {
			MenuSelectException ex = new MenuSelectException();
			throw ex;
		}
		
		return user;
		
	}

	
}
///////////////////수정 할거 : 동창 입력시 학년값이 int임, 엔터키값이 가끔 문제되는듯, 콘솔창 보기가 너무힘듬 프린트문 수정필요
