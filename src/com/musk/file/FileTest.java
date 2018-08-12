package com.musk.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FileTest {
	
	public static void main(String[] args) {
		Random random=new Random();
		//[3,10]
		String[]data=new String[10];
		for(int i=0;i<10;i++) {
			data[i]=String.valueOf(random.nextInt(7)+3);
			System.out.println(data[i]);
		}
		File file=new File("data/a");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		writeStringLine(file, data);
		System.out.println("over");
	}
	
	/**
	 * ---------------按字节写入-----------------
	 * @param file
	 * @param data
	 */
	private static void writeByte(File file,byte[]data) {
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream(file);
			fos.write(data);
			fos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * -----------------按字符行写入-----------------
	 * @param file
	 * @param data
	 */
	private static void writeStringLine(File file,String[]data) {
		BufferedWriter writer=null;
		try {
			writer=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
			for(String line:data) {
				writer.write(line);
				writer.newLine();
			}
			writer.flush();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(writer!=null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * -----------------按字节读入-----------------
	 * @param file
	 * @return
	 */
	private static byte[]readByte(File file){
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(file);
			byte[]buffer=new byte[fis.available()];
			fis.read(buffer);
			fis.close();
			return buffer;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * -----------------按字符行读文件-----------------
	 * @param file
	 * @return
	 */
	private static String[]readLineFile(File file){
		List<String>allLine=new ArrayList<>();
		BufferedReader reader = null;
		try {
			reader=new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
			String line=new String();
			while((line=reader.readLine())!=null) {
				allLine.add(line);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(reader!=null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		String[]results=new String[allLine.size()];
		return allLine.toArray(results);
	}
}