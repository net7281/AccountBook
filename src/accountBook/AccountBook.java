package accountBook;

import java.util.List;

import dao.AccountBookDAO;
import dto.AccountBookDTO;

public class AccountBook {
	
	//DAO
	AccountBookDAO dao = AccountBookDAO.getinstance();
	
	
	public void add() {
		
	}
	public void remove() {
		
	}
	public void modify() {
		
	}
	
	public void allDate() {
		System.out.println();
		System.out.println("전체 이력 출력 ----------------------------- ");
		System.out.println();
		List<AccountBookDTO> dtoList = dao.allSelect();
		printList(dtoList);
	}
	
	public void dateSearch() {
		
	}
	public void placeSearch() {
		
	}
	public void memoSearch() {
		
	}
	public void categorySearch() {
		
	}
	public void periodSearch() {
		
	}
	public void monthlySummary() {
		
	}
	public void totalSummary() {
		System.out.println("전체 ");
		
		
		
		
	}
	
	
	
	private void printList(List<AccountBookDTO> dtoList) {
		
		//리스트 출력
		System.out.println();
		System.out.println(String.format("%-2s\t%-2s\t%-8s\t%-8s\t%-10s\t%-20s\t%-20s","번호","수입/지출","금액","카테고리","사용처","메모","날짜"));
		System.out.println("-----------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < dtoList.size(); i++) {
		    System.out.println(String.format("%-2s\t%-2s\t%-8s\t%-8s\t%-10s\t%-15s\t%-20s",
		            (i + 1),
		            dtoList.get(i).getType(),
		            dtoList.get(i).getAmount(),
		            dtoList.get(i).getCategory(),
		            dtoList.get(i).getPlace(),
		            dtoList.get(i).getMemo(),
		            dtoList.get(i).getDate()));
		}
	}
	
}
