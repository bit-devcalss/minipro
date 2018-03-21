package com.javaex.ex03;

/*
 * 메인은 구조만 가지고 있고
 * 실제기능은 PhoneManager 클래스에서 처리
*/

import java.io.IOException;

public class PhoneApp {

    public static void main(String[] args) throws IOException {

        //PhoneManager 생성
        //파일에서 데이터를 읽어오고, 스케너를 연결한다.
        PhoneManager pManager = new PhoneManager();
        
        //타이틀 출력
        pManager.showTitle();

        // while 시작
        boolean run = true;
        while(run){
            // 메뉴 출력, 입력값 리턴
            int menuNum = pManager.showMenu();

            // switch() 시작
            switch(menuNum){
                
            // 1(리스트)
            case 1:
                pManager.showList();
                break;
            // 2(등록)
            case 2:
                pManager.showAdd();
                break;
            // 3(삭제)
            case 3:
                pManager.showRemove();
                break;
            // 4(검색)
            case 4:
                pManager.showSearch();
                break;
            // 5(종료)
            case 5:
                run = false;
                break;
             // 없는 번호일때
            default :
                System.out.println("다시 입력해주세요");
                break;
            
            }// switch() 종료
            
        }// while 종료

        // 종료화면
        pManager.showEnd();
    }

    
    
 
}