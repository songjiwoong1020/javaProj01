package ver09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ConnectImpl implements Connect{
	
	public Statement stmt;
	public PreparedStatement psmt;
	public Connection con;
	public ResultSet rs;
	
	public ConnectImpl() {
		System.out.println("IConnectImpl 기본생성자 호출");
	}
	
	public ConnectImpl(String user, String pass) {
		System.out.println("IConnectImpl 인자생성자 호출");
		try {
			//드라이버로드
			Class.forName(ORACLE_DRIVER);
			//DB연결
			connect(user, pass);
		}
		catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}

	@Override
	public void connect(String user, String pass) {
		try {
			con = DriverManager.getConnection(ORACLE_URL, user, pass);
			System.out.println("DB연결 성공");
		}
		catch(SQLException e) {
			System.out.println("데이터베이스 연결 오류");
			e.printStackTrace();
		}
	}

	@Override
	public void dataInput() {}
	@Override
	public void dataSearch() {}
	@Override
	public void dataDelete() {}
	@Override
	public void dataAllShow() {}

	@Override
	public void close() {
		try {
			if(con != null) con.close();
			if(psmt != null) psmt.close();
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			System.out.println("자원 반납 완료");
		}
		catch(Exception e) {
			System.out.println("자원 반납시 오류발생");
		}
	}

}
