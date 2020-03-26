package ver03;

public class PhoneInfo {
	//멤버변수
	String name;
	String phoneNumber;
	String birthday;
	
	//생성자
	public PhoneInfo(String name, String phoneNumber, String birthday) {
		
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}
	
	public PhoneInfo(String name, String phoneNumber) {
		
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = null;
	}
	
	
	public void showPhoneInfo() {
		
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
		System.out.println("생년월일 : " + birthday);
	}
	
}
