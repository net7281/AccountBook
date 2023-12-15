package accountBook;

import java.util.List;

import Utile.ScannerUtile;
import dao.AccountBookDAO;
import dto.AccountBookDTO;

public class AccountBook {
	
	//DAO
	AccountBookDAO dao = AccountBookDAO.getinstance();
	
	public void add() { //가계부 작성
		System.out.println();
		System.out.println("가계부 작성 ----------------------------- ");
		System.out.println();

		System.out.print("수입이면 1, 지출이면 2를 입력해주세요 >>");
		String type = ScannerUtile.typeScan();
		
		System.out.print("금액을 입력해주세요 >>");
		int amount = ScannerUtile.intScan();
		
		System.out.println("1.식비, 2.주거비, 3.교통비, 4.취미, 5.의류미용, 6.의료건강, 7.수입, 8.기타");
		System.out.print("카테고리를 선택해주세요 >>");
		String category = ScannerUtile.categoryScan();
		
		System.out.print("사용처를 입력해주세요 >>");
		String place = ScannerUtile.stringScan();
		
		System.out.print("메모를 입력해주세요 >>");
		String memo = ScannerUtile.stringLineScan();
		
		System.out.print("날짜를 입력해주세요 ex)2023-01-01 >>");
		String date = ScannerUtile.dateScan();
		
		AccountBookDTO dto = new AccountBookDTO(type, amount, category, place, memo, date);
		boolean b = dao.insert(dto);
		
		if (b) {
			System.out.println("성공적으로 추가되었습니다.");
		}else {
			System.out.println("추가에 실패하였습니다.");
		}
		
	}
	
	
	public void remove() { //가계부 삭제
		System.out.println();
		System.out.println("가계부 삭제 ----------------------------- ");
		System.out.println();
		
		
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
	
	public void dateSearch() { // 날짜 검색
		System.out.println();
		System.out.println("날짜 검색 ----------------------------- ");
		System.out.println();
		
		System.out.print("검색하실 날짜를 입력해주세요 ex)2023-01-01 >>");
		String date = ScannerUtile.dateScan();
		
		List<AccountBookDTO> dtoList = dao.dateSelect(date);
		printList(dtoList);
	}
	public void placeSearch() { // 사용처 검색
		System.out.println();
		System.out.println("사용처 검색 ----------------------------- ");
		System.out.println();
		
		System.out.print("검색어를 입력해주세요 >>");
		String keyword = ScannerUtile.stringScan();
		
		List<AccountBookDTO> dtoList = dao.placeSearch(keyword);
		printList(dtoList);
		
	}
	
	public void memoSearch() { // 메모 검색
		System.out.println();
		System.out.println("메모 검색 ----------------------------- ");
		System.out.println();
		
		System.out.print("검색어를 입력해주세요 >>");
		String keyword = ScannerUtile.stringScan();
		
		List<AccountBookDTO> dtoList = dao.memoSearch(keyword);
		printList(dtoList);
	}
	
	public void categorySearch() { //카테고리별 검색
		System.out.println();
		System.out.println("카테고리별 검색 ----------------------------- ");
		System.out.println();
		
		System.out.println("1.식비, 2.주거비, 3.교통비, 4.취미, 5.의류미용, 6.의료건강, 7.수입, 8.기타");
		System.out.print("카테고리를 선택해주세요 >>");
		String category = ScannerUtile.categoryScan();
		
		List<AccountBookDTO> dtoList = dao.categorySearch(category);
		printList(dtoList);
	}
	
	public void periodSearch() { // 기간별 검색
		System.out.println();
		System.out.println("기간별 검색 검색 ----------------------------- ");
		System.out.println();

		System.out.print("시작 날짜를 입력해주세요 ex)2023-01-01 >>");
		String startDate = ScannerUtile.dateScan();
		System.out.print("끝 날짜를 입력해주세요 ex)2023-01-01 >>");
		String endDate = ScannerUtile.dateScan();
		
		List<AccountBookDTO> dtoList = dao.periodSelect(startDate, endDate);
		printList(dtoList);
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
