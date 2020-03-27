package ver08;

import java.io.Serializable;

public class PhoneInfo implements Serializable {
	
	//멤버변수
	String name;
	String phoneNumber;
	
	//생성자
	public PhoneInfo(String name, String phoneNumber) {
		
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	
	public void showPhoneInfo() {
		
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		/*name은 같으나 phoneNumber가 다를 또한 같은 객체로 인식해야 하는데 equals()의 값만
		변경해 주었을때는 같은 객체로 인식하지 않는다.
		확실하진 않지만 hashCode()이후 equals()로 진입하는것 같다.
		그래서 phoneNumber과 name이 둘다 같을때 같은 해쉬코드값으로 Override한 equals()로
		들어가는것 같아서 hashCode에서 phoneNumber부분을 지워봤다.
		 */
	
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		PhoneInfo ph = (PhoneInfo)obj;
		
		if(this.name.equals(ph.name)) {
			return true;
		} else {
			return false;
		}

	}
	
	
	
	
}
