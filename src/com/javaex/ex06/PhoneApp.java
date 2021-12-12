package com.javaex.ex06;

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

	public static void main(String[] args) throws IOException{
		
		Reader fr = new FileReader("C:\\javaStudy\\file\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);
		
		/*
		 * 이걸 쓰는 순간 해당 이름으로 빈 파일 생성 -> 이 위치에 이게 있으면 안됨.
		Writer fw = new FileWriter("C:\\javaStudy\\file\\PhoneDB.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		*/
		
		List<Person> pList = new ArrayList<Person>();
		
		Scanner sc = new Scanner(System.in);
		
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
		
		
		
		
		System.out.println("데이터를 입력하세요.");
		
		String str = sc.nextLine();
		String sArray[] = str.split(",");
		Person padd = new Person(sArray[0], sArray[1], sArray[2]);
		
		pList.add(padd);
		
		Writer fw = new FileWriter("C:\\javaStudy\\file\\PhoneDB.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		
		for(Person p : pList) {
			bw.write(p.showInfo2());
			bw.newLine();
			p.showInfo();
		
		}
		br.close();
		bw.close();
		sc.close();
	

	}
	
	/*
	 * 전달받은 list를 출력하는 메소드. 위에 for{showInfo()} 대신 사용 가능!
	 * 위에 main에서 사용하기 위해선 이 메소드 static으로 올라가 있어야 함!
	public static void listPrint(List<Person> personList) {
		for (int i=0; i<personList.size(); i++) {
			System.out.println("이름: " + personList.get(i).getName());
			System.out.println("핸드폰: " + personList.get(i).getHp());
			System.out.println("회사: " + personList.get(i).getCompany());
			System.out.println("");
		}
	}
	*/

}
