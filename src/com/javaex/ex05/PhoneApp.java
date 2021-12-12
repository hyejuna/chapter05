package com.javaex.ex05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class PhoneApp {

	public static void main(String[] args) throws IOException{
		
		Reader fr = new FileReader("C:\\javaStudy\\file\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);
		
		List<Person> pList = new ArrayList<Person>();
		
		while(true){
			
			String str = br.readLine();
			
			if(str == null) {
				break;
			}
			
			String[] sArray = str.split(",");
			Person p = new Person();
			
			p.setName(sArray[0]);
			p.setHp(sArray[1]);
			p.setCompany(sArray[2]);
			
			pList.add(p);
			
		}
		
		
		
		for(Person p : pList) {
			p.showInfo();
		}
		
		
		
		br.close();
	

	}

}
