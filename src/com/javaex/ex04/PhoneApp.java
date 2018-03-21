package com.javaex.ex04;

/*
 * MVC패턴
 * PhoneApp.java 은 프로그램 실행만 
 * PhoneController.java 가 전체 구조를 가지고 있으며 일을 조합하여 시킨다.(C:Controll)
 * PhoneView.java 는 화면(입력과 출력)과 과련된 일만 한다.(V:View)
 * PhoneRepository.java 는 DB와 관련된 일만 한다.(M:Model) 
*/

public class PhoneApp {

	
	public static void main(String[] args) {

		PhoneController pController = new PhoneController();
		pController.excute();
		
	}

}
