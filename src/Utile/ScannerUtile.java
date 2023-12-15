package Utile;

import java.util.InputMismatchException;
import java.util.Scanner;


//입력값을 처리하는 메소드
public class ScannerUtile {
	
	static Scanner scanner = new Scanner(System.in);
	
	//정수 입력
	public static int intScan() {
		while (true) {
			try {
			    int value = scanner.nextInt();
			    return value;
			} catch (Exception e) {
			    // 잘못된 입력값에 대한 처리
			    System.out.print("잘못된 입력입니다. 다시 입력해주세요 : ");
			    scanner.next(); // 잘못된 입력을 버림
			    continue;
			}
		}
	}
	
	//문자열 입력
	public static String stringScan() {
		while (true) {
			try {
			    String value = scanner.next();
			    return value;
			} catch (InputMismatchException e) {
			    // 잘못된 입력값에 대한 처리
			    System.out.print("잘못된 입력입니다. 다시 입력해주세요 : ");
			    scanner.next(); // 잘못된 입력을 버림
			    continue;
			}
		}
	}
	
	// Type 입력 : 수입이면 1, 지출이면 2
	public static String typeScan() {
		while (true) {
			try {
			    int value = scanner.nextInt();
			    if(value == 1) {
			    	return "in";
			    }else if(value == 2){
			    	return "out";
			    }else {
			    	System.out.print("잘못된 번호입니다. 다시 입력해주세요 : ");
			    	scanner.nextLine(); // 잘못된 입력을 버림
				    continue;
			    }
			} catch (Exception e) {
			    // 잘못된 입력값에 대한 처리
			    System.out.print("잘못된 입력입니다. 다시 입력해주세요 : ");
			    scanner.next(); // 잘못된 입력을 버림
			    continue;
			}
		}
	}
	
	// Category 입력 : 1.식비, 2.주거비, 3.교통비, 4.취미, 5.의류미용, 6.의료건강, 7.수입, 8.기타
		public static String categoryScan() {
			while (true) {
				try {
				    int value = scanner.nextInt();
				    
				    switch (value) {
					case 1:
						return "식비";
					case 2:
						return "주거비";
					case 3:
						return "교통비";
					case 4:
						return "취미";
					case 5:
						return "의류미용";
					case 6:
						return "의료건강";
					case 7:
						return "수입";
					case 8:
						return "기타";
					default:
						System.out.print("잘못된 번호입니다. 다시 입력해주세요 : ");
				    	scanner.nextLine(); // 잘못된 입력을 버림
					    break;
					}
				    continue;
				} catch (Exception e) {
				    // 잘못된 입력값에 대한 처리
				    System.out.print("잘못된 입력입니다. 다시 입력해주세요 : ");
				    scanner.next(); // 잘못된 입력을 버림
				    continue;
				}
			}
		}
	
	
	//메모 입력
	public static String stringLineScan() {
		scanner.nextLine(); // 남아있는 개행문자 삭제
		while (true) {
			try {
			    String value = scanner.nextLine();
			    return value;
			} catch (InputMismatchException e) {
			    // 잘못된 입력값에 대한 처리
			    System.out.print("잘못된 입력입니다. 다시 입력해주세요 : ");
			    scanner.next(); // 잘못된 입력을 버림
			    continue;
			}
		}
	}
	
	//날짜입력
	public static String dateScan() {
		while (true) {
			try {
			    String rawStr = scanner.next();
			    rawStr = rawStr.replaceAll("[^0-9-]", ""); // 숫자, . 제외하고 삭제
			    
			    String[] strs = rawStr.split("-");
			    
			    if (strs.length == 3 &&
                        strs[0].length() == 4 &&
                        strs[1].length() == 2 &&
                        strs[2].length() == 2) { // 길이 확인
                    
			    	// . 을 기준으로 년월일 판별
			    	int year = Integer.parseInt(strs[0]);
                    int month = Integer.parseInt(strs[1]);
                    int day = Integer.parseInt(strs[2]);
                    
                    if(year < 1900 || year > 2024) {
                    	System.out.print("잘못된 년도입니다. 다시 입력해주세요 : ");
                        continue;
                    }

                    if(month < 1 || month > 12){
                        System.out.print("잘못된 월입니다. 다시 입력해주세요 : ");
                        continue;
                    }

                    if(day < 1 || day > 31) {
                    	 System.out.print("잘못된 날짜입니다. 다시 입력해주세요 : ");
                         continue;
                    }
                    
                    return strs[0] + "." + strs[1] + "." + strs[2];
			    }else {
			    	System.out.print("잘못된 입력입니다. 다시 입력해주세요 : ");
				    scanner.nextLine(); // 잘못된 입력을 버림
				    continue;
			    }
			    
			    
			} catch (InputMismatchException e) {
			    // 잘못된 입력값에 대한 처리
			    System.out.print("잘못된 입력입니다. 다시 입력해주세요 : ");
			    scanner.nextLine(); // 잘못된 입력을 버림
			    continue;
			}
		}
	}
	
	// y, n 입력일 시
	public static boolean booleanScan() {
		while (true) {
			try {
			    char value = scanner.next().charAt(0);
			    
			    //대소문자 관계없이 y = true, n = false 출력
			    if(Character.toUpperCase(value) == 'Y') {
			    	return true;
			    }else if(Character.toUpperCase(value) == 'N') {
			    	return false;
			    }else {
			    	System.out.print("잘못된 입력입니다. 다시 입력해주세요 : ");
			    	continue;
			    }
			    
			} catch (InputMismatchException e) {
			    // 잘못된 입력값에 대한 처리
			    System.out.print("잘못된 입력입니다. 다시 입력해주세요 : ");
			    scanner.next(); // 잘못된 입력을 버림
			    continue;
			}
		}
	}
}
