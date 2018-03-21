package com.javaex.ex00;

/*
 * 돌아가는 코드 아님 --> 전체 구조만 참고
*/

import java.io.IOException;
import java.util.Scanner;

public class PhoneApp {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        // 시작화면 출력
        System.out.println("******************************************");
		System.out.println("*            전화번호 관리 프로그램                                *");
		System.out.println("******************************************");
        
        // while 시작
        while(run){
            // 메뉴 출력
            System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
            System.out.print(">메뉴번호: ");
            int nemuNum = sc.nextInt();

            // switch() 시작
            switch(nemuNum){
                
                // 1(리스트)
                case 1:
                    System.out.println("<1.리스트>");
                    
                    break;
                // 2(등록)
                case 2:
                    System.out.println("<2.등록>");
                    break;
                // 3(삭제)
                case 3:
                    System.out.println("<3.삭제>");
                    break;
                // 4(검색)
                case 4:
                    System.out.println("<4.검색>");
                    break;
                // 5(종료)
                case 5:
                    System.out.println("종료");
                    run=false;
                    break;
                 // 없는 번호일때
                default :
                    System.out.println("다시 입력해주세요");
                    break;
            }// switch() 종료
            
        }// while 종료

        sc.close();
        // 종료화면
        System.out.println("감사합니다.");
    }
}
