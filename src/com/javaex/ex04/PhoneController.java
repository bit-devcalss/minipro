package com.javaex.ex04;

import java.util.List;


//화면과 데이타를 조합하여 비지니스 로직을 완성합니다.

public class PhoneController {

	private PhoneView phoneView;
	private PhoneRepository phoneRepo;
	
	public PhoneController() {
		super();
	}
	
	public void excute(){
		
		phoneView = new PhoneView();
		phoneRepo = new PhoneRepository();
		
		boolean run = true;
		int menuNum ;
		List<Person> phoneList;
		Person phoneVO;
		int delNo;
		String keyword;
		
		phoneView.showStart();
		
		while(run){
			menuNum = phoneView.showMenu();
			
			switch(menuNum){

				case 1:
					phoneList = phoneRepo.getList();
					phoneView.showList(phoneList);
					break;
			
				case 2:
					phoneVO = phoneView.showAdd();
					phoneRepo.addInfo(phoneVO);
					phoneView.showAddResult();
					break;
					
				case 3:
					delNo = phoneView.showDel();
					phoneRepo.delInfo(delNo);
					phoneView.showDelResult();
					break;
					
				case 4:	
					keyword = phoneView.showSearch();
					phoneList = phoneRepo.getList();
					phoneView.showSearchResult(phoneList, keyword);
					break;
					
				case 5:
					phoneView.showEnd();
					run =false;
					break;
					
				default :
					phoneView.showEtc();
					break;
			}//switch
			
			
		}//while
		
		
	}//excute()
	

}//PhoneController
