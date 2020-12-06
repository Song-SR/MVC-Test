package kr.smhrd.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnect() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String db_id = "hr";
		String db_pw = "hr";
		try {
			conn = DriverManager.getConnection(url, db_id, db_pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void close() {
			try {
				if(rs != null)
					rs.close();
				if(ps != null)
					ps.close();
				if(conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	// 전체 리스트 가져오기 기능
	public List<MemberVO> getAllList() {
		conn = getConnect();
		String sql = "select * from tblMember";
		List<MemberVO> list = new ArrayList<>();  // List가 ArrayList의 상위개념
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String id = rs.getString("id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String email = rs.getString("email");
				
				MemberVO vo = new MemberVO(num, id, pass, name, tel, email);
				list.add(vo);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	
	public int memberInsert(MemberVO vo) {
		conn = getConnect();
		String sql = "insert into tblMember values(num_seq.NEXTVAL,?,?,?,?,?)";
		int cnt = -1;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPass());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getTel());
			ps.setString(5, vo.getEmail());
			
			cnt = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return cnt;
	}
	
	public int memberDelete(int num) {
		conn = getConnect();
		String sql = "delete from tblMember where num = ?";
		int cnt = -1;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			
			cnt = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return cnt;
	}
	
	public MemberVO memberContent(int num) {
		conn = getConnect();
		
		String sql = "select * from tblMember where num = ?";
		MemberVO vo = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			if(rs.next()) {
				num = rs.getInt("num");
				String id = rs.getString("id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String email = rs.getString("email");
				vo = new MemberVO(num, id, pass, name, tel, email);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return vo;
	}
	
	public int memberUpdate(MemberVO vo) {
		conn = getConnect();
		String sql = "update tblMember set tel = ?, email = ? where num = ?";
		int cnt = -1;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getTel());
			ps.setString(2, vo.getEmail());
			ps.setInt(3, vo.getNum());
			
			cnt = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return cnt;
	}
	
}
