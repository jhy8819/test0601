package test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



import test.vo.TestVO;

public class TestDao {

	private String url; 
	private String user; 
	private String passwd;


	public TestDao()
	{
		this.url = "jdbc:mysql://localhost/yongin?characterEncoding=UTF-8&serverTimezone=UTC"; 
		this.user = "root";
		this.passwd = "kdw810118";
	}
	
	private static TestDao dao = new TestDao();
	
	public static TestDao getInstance() {
		
		return dao;
	}

	public Connection connect() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,passwd);
			
		} catch (Exception e) {
			System.out.print("MDAO:connenct" + e);
		}
		return conn;
	}
	
	public void close(Connection conn, PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				System.out.print("Pstmt close error" + e);
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				System.out.print("Conn close error" +e);
			}
		}
	}
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs) 
	{
		if(rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				System.out.print("rs close error" + e);
			}
		}
		close(conn, pstmt);
	}
	
	public boolean login(String id, String pwd) {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try 
		{
			conn = connect();
			pstmt = conn.prepareStatement("select * from prof where id = ? and pwd = ?;");
			pstmt.setString(1,id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				result = true;
			}
			else
				result = false;
		} catch (Exception e) {
			System.out.print("login eror" + e);
		}
		finally
		{
			close(conn,pstmt,rs);
		}
		return result;
	}
	
	
	public void enrollSubject(TestVO enroll) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("insert into subject values(?,?,?,?);");
			pstmt.setString(1, enroll.getId());
			pstmt.setString(2, enroll.getTitle());
			pstmt.setString(3, enroll.getCount());
			pstmt.setString(4, enroll.getProf());
			pstmt.executeUpdate();					
		} catch (Exception e) {
			System.out.print("insert error" +e);
		}finally 
		{
			close(conn,pstmt);
		}
	}

	public ArrayList<TestVO> showSubject() {
		// TODO Auto-generated method stub
		ArrayList<TestVO> list = new ArrayList<TestVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TestVO subject = null;
		
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from subject;");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				subject = new TestVO();
				subject.setId(rs.getString(1));
				subject.setTitle(rs.getString(2));
				subject.setCount(rs.getString(3));
				subject.setProf(rs.getNString(4));
				list.add(subject);
			}

		} catch (Exception e) {
			System.out.println("error : " + e);
		} finally {
			close(conn, pstmt, rs);
		}

		return list;
	}

	public TestVO subjectSearch(String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		TestVO subject = null;
		

		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from subject where id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				subject = new TestVO();
				subject.setId(rs.getString(1));
				subject.setTitle(rs.getString(2));
				subject.setCount(rs.getString(3));
				subject.setProf(rs.getString(4));
			}
		} catch (Exception e) {
			System.out.print("MSearch error" +e);
		} finally
		{
			close(conn,pstmt,rs);
		}
		return subject;
	}

	public void subjectUpdate(TestVO subject) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt = null;
		
		try {
			conn = connect();
			pstmt = conn.prepareStatement("insert into enroll values(?,?);");
		} catch (Exception e) {
			System.out.println("error:" + e);
		} finally {
			close(conn,pstmt);
		}
	}

	public String subjectUpdate(String id, String enrollment) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("insert into enroll values(?,?);");
			pstmt.setString(1, id);
			pstmt.setString(2, enrollment);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				
			}
			
			pstmt = conn.prepareStatement("update enroll set subject=? where id=?;");
			pstmt.setString(1, enrollment);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.print("error" + e);
		}
		finally
		{
			close(conn,pstmt,rs);
		}
		
		
		return null;
	}
}





	


	

	

		







