package com.douzone.mysite.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzone.mysite.vo.BoardVo;
import com.douzone.mysite.vo.GuestbookVo;
import com.douzone.mysite.vo.UserVo;

public class BoardDao {

	public boolean delete(BoardVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			String sql = " delete" + "   from board" + "  where no= ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, vo.getNo());

			int count = pstmt.executeUpdate();
			
			result = count ==1;
		} catch (SQLException e) {
			System.out.println("error :" + e);
		} finally {
			// 자원 정리
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
	
	public boolean update(long no)
	{
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try 
		{
			 conn = getConnection();
			 
			 String sql = "update board set hit = hit + 1 where no = ?";
			 
			 pstmt = conn.prepareCall(sql);
			 
			 pstmt.setLong(1, no);
			 
			 int count = pstmt.executeUpdate();
			 result = count == 1;
		} 
		catch (SQLException e) 
		{
			System.out.println("error : " + e);
		}
		finally 
		{
			try 
			{
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		return result;
	}
	public boolean update(BoardVo vo)
	{
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try 
		{
			 conn = getConnection();
			 
			 String sql = "update board set title=?, contents=? where no="+vo.getNo();
			 pstmt = conn.prepareCall(sql);
			 pstmt.setString(1, vo.getTitle());
			 pstmt.setString(2, vo.getContents());
			 int count = pstmt.executeUpdate();
			 result = count == 1;
		} 
		catch (SQLException e) 
		{
			System.out.println("error : " + e);
		}
		finally 
		{
			try 
			{
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public List<BoardVo> getList(String no)
	{
		BoardVo result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<BoardVo> list = new ArrayList<>();
		
		try 
		{
			 conn = getConnection();
			 
			 String sql = "select group_no, order_no, depth from board where no = ?";
			 
			 pstmt = conn.prepareCall(sql);
			 
			 pstmt.setLong(1, Long.parseLong(no));
			 rs = pstmt.executeQuery();
			 
			 if (rs.next())
			 {
				 long group_no = rs.getLong(1);
				 long order_no = rs.getLong(2);
				 long depth = rs.getLong(3);
				 
				 result = new BoardVo();
				 result.setGroup_no(group_no);
				 result.setOrder_no(order_no);
				 result.setDepth(depth);
				 
				 list.add(result);
			 }
		} 
		catch (SQLException e) 
		{
			System.out.println("error : " + e);
		}
		finally 
		{
			try 
			{
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		return list;
	}
	public BoardVo get(long no) {
		BoardVo boardVo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			

			String sql ="select no, title, contents, user_no from board where no="+no;
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				Long no1 = rs.getLong(1);
				String title = rs.getString(2);
				String contents = rs.getString(3);	
				Long user_no = rs.getLong(4);
				
				boardVo = new BoardVo();
				boardVo.setNo(no1);
				boardVo.setTitle(title);
				boardVo.setContents(contents);
				boardVo.setUser_no(user_no);
						
			}
			
			 sql = "update board set hit = hit + 1 where no ="+no;
			 
			 pstmt.executeUpdate(sql);
			
			
		} catch (SQLException e) {
			System.out.println("Error : "+e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(rs != null) {
					rs.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return boardVo;
	}
	public List<BoardVo> getList(long no) {
		BoardVo result = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<BoardVo> list = new ArrayList<>();

		try 
		{
			 conn = getConnection();
			 
			 String sql = "select title, contents, user_no from board where no = ?";
			 
			 pstmt = conn.prepareCall(sql);
			 
			 pstmt.setLong(1, no);
			 rs = pstmt.executeQuery();
			 
			 if (rs.next())
			 {
				 String title = rs.getString(1);
				 String contents = rs.getString(2);
				 long user_no = rs.getLong(3);
				 
				 result = new BoardVo();
				 result.setTitle(title);
				 result.setContents(contents);
				 result.setUser_no(user_no);
				 
				 list.add(result);
			 }
		} 
		catch (SQLException e) 
		{
			System.out.println("error : " + e);
		}
		finally 
		{
			try 
			{
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		return list;
	}

	
	public boolean insert(String title, String contents, long no) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "insert into board values (null, ?, ?, now(), 0, (select ifnull(max(group_no)+1,1) from board a), 1, 0, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, title);
			pstmt.setString(2, contents);
			pstmt.setLong(3, no);

			int count = pstmt.executeUpdate();
			result = count == 1;
		} catch (SQLException e) {
			System.out.println("error :" + e);
		} finally {

			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	
	public List<BoardVo> getList() {
		BoardVo result = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<BoardVo> list = new ArrayList<>();

		try {
			conn = getConnection();

			String sql = "select a.title, b.name, a.hit, a.write_date, a.depth, a.contents, a.no, a.user_no, a.order_no ,b.no from board a, user b where a.user_no = b.no order by a.group_no desc, a.order_no asc";

			pstmt = conn.prepareCall(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String title = rs.getString(1);
				String name = rs.getString(2);
				long hit = rs.getLong(3);
				String write_date = rs.getString(4);
				long depth = rs.getLong(5);
				String contents = rs.getString(6);
				long no = rs.getLong(7);
				long user_no = rs.getLong(8);
				long order_no = rs.getLong(9);
				long uno = rs.getLong(10);

				result = new BoardVo();

				result.setTitle(title);
				result.setName(name);
				result.setHit(hit);
				result.setWrite_date(write_date);
				result.setDepth(depth);
				result.setContents(contents);
				result.setNo(no);
				result.setUser_no(user_no);
				result.setOrder_no(order_no);
				result.setUno(uno);
				
				list.add(result);
			}
		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	public boolean insert(BoardVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "insert into board values (null, ?, ?, now(), 0, ?, ?, ?, ?)";

			pstmt = conn.prepareCall(sql);

			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContents());
			pstmt.setLong(3, vo.getNo());
			pstmt.setLong(4, vo.getOrder_no());
			pstmt.setLong(5, vo.getDepth());
			pstmt.setLong(6, vo.getUser_no());

			int count = pstmt.executeUpdate();
			result = count == 1;
		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://localhost/webdb?characterEncoding=utf8&serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
		} catch (ClassNotFoundException e) {
			System.out.println("드러이버 로딩 실패:" + e);
		}

		return conn;
	}
}
