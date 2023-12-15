package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.AccountBookDTO;
import dto.SummaryDTO;

public class AccountBookDAO {

	// singleton
	private static AccountBookDAO bookDAO = null;
	
	private AccountBookDAO() {
	}
	
	public static AccountBookDAO getinstance() {
		if(bookDAO == null) {
			bookDAO = new AccountBookDAO();
		}
		return bookDAO;
	}

	// 추가
	public boolean insert(AccountBookDTO dto) {
		String sql 	= "insert into AccountBook(Type, Amount, Category, Place, Memo, Date) "
					+ "values ('"+ dto.getType() +"', "
								 + dto.getAmount() +", '"
								 + dto.getCategory() +"', '"
								 + dto.getPlace() +"', '"
								 + dto.getMemo() +"', '"
								 + dto.getDate() +"')";
		
		return executeUpdate(sql);
	}
	
	// 삭제
	public boolean delete(int seq) {
		String sql 	= "delete from AccountBook "
					+ "where seq = " + seq;
		
		return executeUpdate(sql);
	}
	
	// 수정
	public boolean update(AccountBookDTO dto) {
		String sql 	= "update AccountBook "
					+ "set Type = '"+ dto.getType() +"', "
					+ "Amount = "+dto.getAmount()+", "
					+ "Category = '"+ dto.getCategory() +"', "
					+ "Place = '"+ dto.getPlace() +"', "
					+ "Memo = '"+ dto.getMemo() +"', "
					+ "Date = '"+ dto.getDate() +"' "
					+ "where seq = " + dto.getSeq();
		
		return executeUpdate(sql);
	}
	
	// 전체 출력
	public List<AccountBookDTO> allSelect () {
		String sql 	= "select "
					+ "seq, Type, Amount, Category, Place, Memo, DATE(Date) as Date "
					+ "from AccountBook "
					+ "order by Date";
		
		return executeQueryForSelect(sql);
	}
	
	// 날짜 검색
	public List<AccountBookDTO> dateSelect (String date) {
		String sql 	= "select "
					+ "seq, Type, Amount, Category, Place, Memo, DATE(Date) as Date "
					+ "from AccountBook "
					+ "where Date = '"+ date +"' "
					+ "order by Date";
		
		return executeQueryForSelect(sql);
	}
	
	// 사용처 검색
	public List<AccountBookDTO> placeSearch (String keyword) {
		String sql 	= "select "
					+ "seq, Type, Amount, Category, Place, Memo, DATE(Date) as Date " 
					+ "from AccountBook "
					+ "where Place like '%"+ keyword +"%' "
					+ "order by Date";
		
		return executeQueryForSelect(sql);
	}
	
	// 메모 검색
	public List<AccountBookDTO> memoSearch (String keyword) {
													   // 띄어쓰기 제외
		String sql 	= "select "
					+ "seq, Type, Amount, Category, Place, Memo, DATE(Date) as Date " 
					+ "from AccountBook "
					+ "where replace(Memo, ' ', '') like '%"+ keyword +"%' "
					+ "order by Date";
		
		return executeQueryForSelect(sql);
	}
	
	// 카테고리별 검색
	public List<AccountBookDTO> categorySearch (String category) {
		String sql 	= "select "
					+ "seq, Type, Amount, Category, Place, Memo, DATE(Date) as Date " 
					+ "from AccountBook "
					+ "where Category = '"+ category +"' "
					+ "order by Date";
		
		return executeQueryForSelect(sql);
	}
	
	
	// 기간별 검색
	public List<AccountBookDTO> periodSelect (String startDate, String endDate) {
		String sql 	= "select "
					+ "seq, Type, Amount, Category, Place, Memo, DATE(Date) as Date " 
					+ "from AccountBook "
					+ "where Date >= '"+startDate+"' and Date <= '"+endDate+"' "
					+ "order by Date";
		
		return executeQueryForSelect(sql);
	}
	
	// 월별 결산
	public List<SummaryDTO> monthlySumAccount() {
		String sql 	= "select 	DATE_FORMAT(Date, '%Y-%m') as Month, "
					+ "		sum(case when Type = 'in' THEN Amount else 0 END) AS inAmount, "
					+ "		sum(case when Type = 'out' THEN Amount else 0 END) AS outAmount "
					+ "from AccountBook "
					+ "group by DATE_FORMAT(Date, '%Y-%m')";
	
		return executeQueryForSummary(sql);
	}
	
	// 총결산
	public SummaryDTO totalSummary() {
		String sql 	= "select 'all' as Month, "
					+ "		sum(case when Type = 'in' THEN Amount else 0 END) AS inAmount, "
					+ "		sum(case when Type = 'out' THEN Amount else 0 END) AS outAmount "
					+ "from AccountBook ";
	
		return executeQueryForSummary(sql).get(0);
	}	
	
	//////////////////////////////////////////////////////////////////////
	
	// executeUpdate 실행 메소드
	private boolean executeUpdate(String sql) {
		Connection conn = null;
		Statement stmt = null;
		
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			
			count = stmt.executeUpdate(sql); //sql문 실행
			
			System.out.println("sql done");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt, null);
		}
		
		return count>0 ? true : false;
	}
	
	// Select (List<AccountBookDTO>) - executeQuery 실행 메소드
	private List<AccountBookDTO> executeQueryForSelect(String sql) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<AccountBookDTO> list = new ArrayList<AccountBookDTO>();
				
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) { // 다음 데이터가 있는 경우
				
				int seq = rs.getInt("seq");
				String type = rs.getString("type");
				int amount = rs.getInt("amount");
				String category = rs.getString("category");
				String place = rs.getString("place");
				String memo = rs.getString("memo");
				String date = rs.getString("date");
				
				AccountBookDTO dto = new AccountBookDTO(seq, type, amount, category, place, memo, date);
				list.add(dto);
			}
			
			System.out.println("sql done");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt, rs);
		}
		
		return list;
	}
	
	// Summary (List<SummaryDTO>) - executeQuery 실행 메소드
	private List<SummaryDTO> executeQueryForSummary(String sql) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<SummaryDTO> list = new ArrayList<SummaryDTO>();
		
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) { // 다음 데이터가 있는 경우
				
				String month = rs.getString("month");
				int inAmount = rs.getInt("inAmount");
				int outAmount = rs.getInt("outAmount");
				
				SummaryDTO dto = new SummaryDTO(month, inAmount, outAmount);
				list.add(dto);
			}
			
			System.out.println("sql done");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt, rs);
		}
		
		return list;
	}
}
