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
	
	//전화번호 입력
	public static String phoneStringScan() {
		while (true) {
			try {
			    String value = scanner.next();
			    value = value.replaceAll("[^0-9]", ""); // 숫자 제외하고 다 삭제
			    
			    //전화번호 자릿수 확인
			    // 0000-0000 ~ 000-0000-0000
			    if(value.length() < 8 || value.length() > 11) {
			    	System.out.print("잘못된 번호입니다. 다시 입력해주세요 : ");
			    	scanner.nextLine(); // 잘못된 입력을 버림
				    continue;
			    }
			    
			    //전화번호에 - 추가
			    if(value.length() == 8) {
			    	value = value.substring(0, 4) + "-" + value.substring(3);
			    }else if(value.length() == 9 || value.length() == 10) {
			    	value = value.substring(0, 3) + "-" + value.substring(3,6) + "-" + value.substring(6);
			    }else if(value.length() == 11) {
			    	value = value.substring(0, 3) + "-" + value.substring(3,7)+ "-" + value.substring(7);
			    }
			    
			    return value;
			} catch (InputMismatchException e) {
			    // 잘못된 입력값에 대한 처리
			    System.out.print("잘못된 입력입니다. 다시 입력해주세요 : ");
			    scanner.nextLine(); // 잘못된 입력을 버림
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
			    rawStr = rawStr.replaceAll("[^0-9.]", ""); // 숫자, . 제외하고 삭제
			    
			    String[] strs = rawStr.split("\\.");
			    
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
