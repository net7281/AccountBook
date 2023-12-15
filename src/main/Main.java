package main;

import Utile.ScannerUtile;
import accountBook.AccountBook;

public class Main {

	public static void main(String[] args) {
		AccountBook accountBook = new AccountBook();
		
		//menu 출력
		while (true) {
			//Message
			System.out.println();
			System.out.println("==================================");
			System.out.println("||          가계부 프로그램          ||");
			System.out.println("==================================");
			System.out.println();
			System.out.println("1. 가계부 작성");
			System.out.println("2. 가계부 삭제");
			System.out.println("3. 가계부 수정");
			System.out.println("4. 가계부 조회");
			System.out.println("5. 월별 결산");
			System.out.println("6. 총 결산");
			System.out.println();
			System.out.print("원하시는 메뉴를 선택해주세요 : ");
			
			//user input
			int mainMenu = 0;
			mainMenu = ScannerUtile.intScan();
			
			//menu switch
			switch (mainMenu) {
			case 1: // 가계부 작성
				accountBook.add();
				break;
			case 2: // 가계부 삭제
				accountBook.remove();
				break;
			case 3: // 가계부 수정
				accountBook.modify();
				break;
			case 4: // 가계부 조회
				System.out.println();
				System.out.println("\t 1. 전체조회");
				System.out.println("\t 2. 날짜 검색");
				System.out.println("\t 3. 사용처 검색");
				System.out.println("\t 4. 메모 검색");
				System.out.println("\t 5. 카테고리별 검색");
				System.out.println("\t 6. 기간별 검색");
				
				//user input
				int subMenu = 0;
				subMenu = ScannerUtile.intScan();
				
				switch (subMenu) {
					case 1: // 전체조회
						accountBook.allDate();
						break;
					case 2: // 날짜 검색
						accountBook.dateSearch();
						break;
					case 3: // 사용처 검색
						accountBook.placeSearch();
						break;
					case 4: // 메모 검색
						accountBook.memoSearch();
						break;
					case 5: // 카테고리별 검색
						accountBook.categorySearch();
						break;
					case 6: // 기간별 검색
						accountBook.periodSearch();
						break;
					default:
						System.out.println("없는 메뉴 번호입니다.");
						break;
					}
				break;
			case 5: // 월별 결산
				accountBook.monthlySummary();
				break;
			case 6: // 총 결산
				accountBook.totalSummary();
				break;
			default:
				System.out.println("없는 메뉴 번호입니다.");
				break;
			}
		}
		
	}

}
