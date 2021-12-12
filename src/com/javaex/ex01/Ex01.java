package com.javaex.ex01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Ex01 {

	public static void main(String[] args) throws Exception{

		
		InputStream in = new FileInputStream("C:\\javaStudy\\file\\img.jpg");
		OutputStream out = new FileOutputStream("C:\\javaStudy\\file\\byteimg.jpg");
		
		byte[] buff = new byte[1024]; // data 쓰는데 오래 걸려서 묶어서 읽고 쓰려고 만듬
		
		System.out.println("복사 시작");
		while(true) {
			int data = in.read(buff);
			
			if(data==-1) {
				System.out.println("복사 완료" + data);
				break;
			}
			
			out.write(buff);
		}
		
		/*
		 * int 단위로 읽고 쓰면 너무 오래 걸려서 위 방법으로 씀
		System.out.println("복사시작");
		while(true) {
			int data = in.read();
			System.out.println(data);
			
			if(data == -1) {
				
				System.out.println("복사 끝" + data);
				break;
				
			}
			
			out.write(data);
		}
		*/
		
		in.close();
		out.close();
		

	}

}
