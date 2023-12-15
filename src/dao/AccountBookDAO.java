package dao;

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

	
}
