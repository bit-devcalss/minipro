package com.javaex.ex01;

/*
 * 메인메소드에 코딩하기
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneApp {

    public static void main(String[] args) throws IOException {

    	// 준비영역
        Writer fw ;
        BufferedWriter bw;
        String str;
        
        // 스캐너
        Scanner sc = new Scanner(System.in);
        
        // 파일을 읽어서 리스트에 담는다.
        Reader fr = new FileReader("phoneDB.txt");
        BufferedReader br = new BufferedReader(fr);

        List<Person> pList = new ArrayList<Person>();

        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }

            String[] data = line.split(",");
            String name = data[0];
            String hp = data[1];
            String company = data[2];

            Person phone = new Person(name, hp, company);

            pList.add(phone);

        }

        // 시작화면
        System.out.println("******************************************");
		System.out.println("*            전화번호 관리 프로그램                            *");
		System.out.println("******************************************");

		// while 시작
        boolean run = true;
        while(run){
            // 메뉴 출력
        	System.out.println("");
            System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
            System.out.println("------------------------------------------");
            System.out.print(">메뉴번호: ");

            // 메뉴 입력
            int menuNum = sc.nextInt();
            sc.nextLine();
            
            // switch() 시작
            switch(menuNum){
                
            // 1(리스트)
            case 1:
                System.out.println("<1.리스트>");
                for(int i=0; i<pList.size(); i++){
                    System.out.print(i+1 + ".   ");
                    System.out.print(pList.get(i).getName()+"\t");
                    System.out.print(pList.get(i).getHp()+"\t");
                    System.out.print(pList.get(i).getCompany()+"\t");
                    System.out.println("");
                }
                break;
                
            // 2(등록)
            case 2:
                System.out.println("<2.등록>");
                //이름받기
                System.out.print(">이름: ");
                String name = sc.nextLine();
                //휴대전화 받기
                System.out.print(">휴대전화: ");
                String hp = sc.nextLine();
                //회사번호받기
                System.out.print(">회사전화: ");
                String company = sc.nextLine();
            
                //리스트에 추가하기
                Person person = new Person();
                person.setName(name);
                person.setHp(hp);
                person.setCompany(company);
                
                pList.add(person);
                
                
                //파일에 저장
                fw = new FileWriter("phoneDB.txt");
                bw = new BufferedWriter(fw);
                
                //문자열 만들기
                str="";
                for(int i=0; i<pList.size(); i++){
                    str += pList.get(i).getName() + ",";
                    str += pList.get(i).getHp() + ",";
                    str += pList.get(i).getCompany()+"\n";
                   
                }
                bw.write(str);
                bw.flush();
                System.out.println("[등록되었습니다.]");
                break;
            
            // 3(삭제)
            case 3:
                System.out.println("<3.삭제>");
                System.out.print(">번호 : ");
                int no = sc.nextInt();
                pList.remove(no-1);
                
                
                //파일에 저장
                fw = new FileWriter("phoneDB.txt");
                bw = new BufferedWriter(fw);
                
                //문자열 만들기
                str="";
                for(int i=0; i<pList.size(); i++){
                    str += pList.get(i).getName() + ",";
                    str += pList.get(i).getHp() + ",";
                    str += pList.get(i).getCompany()+"\n";
                   
                }
                bw.write(str);
                bw.flush();
                System.out.println("[삭제되었습니다.]");
                break;
                
            // 4(검색)
            case 4:
                System.out.println("<4.검색>");
                System.out.print(">이름: ");
                String keyword = sc.nextLine();
                
                for(int i=0; i<pList.size(); i++){
                    String serchName = pList.get(i).getName();
                    if(serchName.contains(keyword)){
                        System.out.print(i+1 + ".   ");
                        System.out.print(pList.get(i).getName()+"\t");
                        System.out.print(pList.get(i).getHp()+"\t");
                        System.out.print(pList.get(i).getCompany()+"\t");
                        System.out.println("");
                    }
                }
                
                break;
        
            // 5(종료)
            case 5:
                System.out.println("종료");
                run = false;
                break;
             // 없는 번호일때
            default :
            	System.out.println("[다시 입력해 주세요.]");
                break;
            
            }// switch() 종료
            
        }// while 종료
        br.close();
        sc.close();

        // 종료화면
        System.out.println("");
        System.out.println("******************************************");
        System.out.println("*                   감사합니다                             *");
        System.out.println("******************************************");
    }

}