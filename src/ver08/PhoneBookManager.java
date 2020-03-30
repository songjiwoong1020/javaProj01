package ver08;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;


public class PhoneBookManager implements SubMenuItem{
	
	
	HashSet<PhoneInfo> phoneInfo;
	Scanner scanner = new Scanner(System.in);
	
	public void load() {
		
		try {
			File file = new File("src/ver08/PhoneBook.obj");
			if(file.exists()) {
//				System.out.println("\n=====실행 했을때 파일이 존재하면 진입=====\n");//마지막에 주석처리
				ObjectInputStream in = 
						new ObjectInputStream(
								new FileInputStream("src/ver08/PhoneBook.obj"));
				phoneInfo = (HashSet<PhoneInfo>)in.readObject();
				in.close();
			} else {
//				System.out.println("\n=====실행 했을때 파일이 존재하지 않는다면 진입=====\n");//마지막에 주석처리
				//파일이 없다면 새로운 객체를 생성해서 만들어보자.
				phoneInfo = new HashSet<PhoneInfo>();
			}
		}
		catch(Exception e) {
//			System.out.println("\n=====load메소드에서 예외발생=====\n");//마지막에 주석처리
			e.printStackTrace();
		}
	}

	//저장
	public void save() {
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("src/ver08/PhoneBook.obj"));
			
			out.writeObject(phoneInfo);
//			System.out.println("\n=====시스템 종료시 save=====\n");//마지막에 주석처리
			out.close();
		}
		catch (Exception e) {
//			System.out.println("\n=====save메소드에서 예외발생=====\n");//마지막에 주석처리
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
		
		int overlap = 0;
		
		while(true) {
			try {
				System.out.println("덮어 씌우시겠습니까? \n(입력 취소:1 덮어씌우기:2)");
				System.out.print("선택 : ");
				overlap = scanner.nextInt();
				scanner.nextLine();
				
				if(overlap == 1) {
					System.out.println("입력을 취소합니다\n");
					return overlap;
				}else if(overlap == 2) {
					return overlap;
				} else {
					System.out.println("잘못 입력했습니다.\n");
				}
			}
			catch(Exception e) {
//				System.out.println("\n=====덮어씌우기 부분에서 예외발생=====\n");//마지막에 주석처리
				System.out.println("잘못 입력했습니다.\n");
				scanner = new Scanner(System.in);
			}
		}
		
	}
	
	public void subDataInput() {
		
	}
	
	//입력
	public void dataInput() {
		
		System.out.println("\n=데이터 입력을 시작합니다.=\n");
		int user;
		while(true) {
			try {
				System.out.println("1.일반, 2.동창, 3.회사, 4.뒤로가기 \n선택>>");
				user = scanner.nextInt();
				scanner.nextLine();
				
				if(user == normal) {
					System.out.print("이름 : ");
					String name = scanner.nextLine();
					System.out.print("전화번호 : ");
					String phone = scanner.nextLine();
					if(!phoneInfo.add(new PhoneInfo(name, phone))) {
						System.out.println("\n동일한 이름의 정보가 존재합니다.\n");
						int test = overlap();
						if(test == 2) {
							phoneInfo.remove(new PhoneInfo(name, phone));
							phoneInfo.add(new PhoneInfo(name, phone));
							System.out.println("\n기존 데이터를 삭제하고 새로운 데이터를 덮어씁니다.\n");
						}
					} else {
					System.out.println("\n데이터 입력이 완료되었습니다.\n");
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
					scanner.nextLine();
					
					
					if(!phoneInfo.add(new PhoneSchoolInfo(name, phone, major, grade))) {
						System.out.println("\n동일한 이름의 정보가 존재합니다.\n");
						int test = overlap();
						if(test == 2) {
							phoneInfo.remove(new PhoneSchoolInfo(name, phone, major, grade));
							phoneInfo.add(new PhoneSchoolInfo(name, phone, major, grade));
							System.out.println("\n기존 데이터를 삭제하고 새로운 데이터를 덮어씁니다.\n");
						}
					} else {
					System.out.println("\n데이터 입력이 완료되었습니다.\n");
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
						System.out.println("\n동일한 이름의 정보가 존재합니다.\n");
						int test = overlap();
						if(test == 2) {
							phoneInfo.remove(new PhoneCompanyInfo(name, phone, company));
							phoneInfo.add(new PhoneCompanyInfo(name, phone, company));
							System.out.println("\n기존 데이터를 삭제하고 새로운 데이터를 덮어씁니다.\n");
						}
					} else {
					System.out.println("\n데이터 입력이 완료되었습니다.\n");
					}
					break;
					
				} else if(user == back) {
					break;
				} else {
//					System.out.println("\n=====데이터 입력 선택부분에서 숫자 잘못입력시 진입하는 else문=====\n");//마지막에 주석처리
					System.out.println("잘못 입력했습니다.\n");
				}
			}
			catch(InputMismatchException e) {
//				System.out.println("\n=====데이터 입력 선택부분에서InputMismatchException 예외발생=====\n");//마지막에 주석처리
				System.out.println("잘못 입력했습니다.\n");
//				e.printStackTrace();
				scanner = new Scanner(System.in);
			}
			catch(Exception e) {
//				System.out.println("\n=====데이터 입력 선택부분에서 알수 없는 예외발생=====\n");//마지막에 주석처리
//				e.printStackTrace();
				scanner = new Scanner(System.in);
			}
		}
	}
	
	//검색
	public void dataSearch() {
		
		try {
			System.out.println("\n=데이터 검색을 시작합니다.=\n");
			System.out.print("이름 : ");
			String search = scanner.nextLine();
			boolean a = false;
	
			for(PhoneInfo list : phoneInfo) {
				if(list.name.equals(search)) {
					list.showPhoneInfo();
					System.out.println("\n데이터 검색이 완료되었습니다.\n");
					a = true;
				}
			}
			if(!a) System.out.println("\n입력하신 정보와 일치하는 정보가 없습니다.\n");
		}
		catch(NullPointerException e) {
			System.out.println("\n널포인트\n");
		}
	}
	
	//삭제
	public void dataDelete() {
		
		try {
			System.out.println("\n=데이터 삭제를 시작합니다.=\n");
			System.out.print("이름 : ");
			String delete = scanner.nextLine();
			boolean a = false;
			
			for(PhoneInfo list : phoneInfo) {
				if(list.name.equals(delete)) {
					phoneInfo.remove(list);
					a = true;
					System.out.println("\n데이터 삭제가 완료되었습니다.\n");
					break;
				}
			}
			if(!a) System.out.println("\n입력하신 정보와 일치하는 정보가 없습니다.\n");
		}
		catch(NullPointerException e) {
			System.out.println("\n널포인트\n");
		}
	}

	
	//주소록 전체출력
	public void dataAllShow() {
		
		if(phoneInfo.isEmpty()) {
			System.out.println("\n입력된 정보가 없습니다.\n");
		} else {
			System.out.println("\n=전제정보를 출력합니다.=\n");
			for(PhoneInfo list : phoneInfo) {
				list.showPhoneInfo();
			}
			System.out.println("\n데이터 검색이 완료되었습니다.\n");
		}
	}
	
	//사용자 정의 에러
	public int userNum(int user) throws MenuSelectException{
		
//		System.out.println("\n=====사용자정의 예외 클래스 진입=====\n");//마지막에 주석처리
		if(user<1 || user>5) {
			MenuSelectException ex = new MenuSelectException();
			throw ex;
		}
		
		return user;
		
	}

	
}
///////////////////
