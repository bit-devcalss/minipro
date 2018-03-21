package com.javaex.ex04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class PhoneRepository {

    
    //phoneDB.txt 파일을 읽어 모든 전화번호(리스트)를 전달하는 메소드
	public List<Person> getList(){
		
	    //전화번호들 관리를 위한 리스트
		List<Person> list = new ArrayList<Person>();
		
		try {
			Reader fr = new FileReader("phoneDB.txt");
			BufferedReader br = new BufferedReader(fr);
			
			while(true){
				Person phoneVO = new Person();
				String line;
				
				line = br.readLine();
				if(line!=null){
					String[] dataArray = new String[3];
					dataArray = line.split(",");
								
					phoneVO.setName(dataArray[0]);
					phoneVO.setHp(dataArray[1]);
					phoneVO.setCompany(dataArray[2]);
					
					list.add(phoneVO);
					
				}else{
					break;
				}
				
			}
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
		
	}

	//phoneDB.txt 에 모든 전화번호 리스트를 저장하는 메소드
	private void saveInfo(List<Person> list){
		
		try {
			Writer fr = new FileWriter("phoneDB.txt");
			BufferedWriter bw = new BufferedWriter(fr);
			
			String listStr = "";
			
			for(int i=0; i<list.size(); i++ ){
				listStr = listStr + list.get(i).getName()+","+list.get(i).getHp()+","+list.get(i).getCompany()+"\n";
			}
		
            bw.write(listStr);
            bw.flush();
            bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		
	}
	
	//기존데이터에 새로입력받은 데이터를 추가하여 모두저장하는 메소드 
	public void addInfo(Person phoneVO) {
		List<Person> list=getList();
		list.add(phoneVO);
		saveInfo(list);
	}

	//선택한 번호의 데이터를 삭제하고 저장하는 메소드(모두 다시저장)
	public void delInfo(int num) {
		List<Person> list=getList();
		list.remove(num-1);
		saveInfo(list);
	}
	

}
