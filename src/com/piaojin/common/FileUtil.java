package com.piaojin.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class FileUtil {

	// 写数据到文件
	public static void WriteFile(String path, String content)
			throws IOException {
		if (path != null && !"".equals(path) && content != null
				&& !"".equals(content)) {
			File file = new File(path);
			/*
			 * //文件夹不存在则创建 if(!file .exists() && !file .isDirectory()){
			 * file.mkdir(); }
			 */
			// 如果文件不存在就创建
			if (!file.exists()) {
				file.createNewFile();
			}
			// 写入内容到文件
			FileOutputStream outputStream = new FileOutputStream(file);
			OutputStreamWriter writer=new OutputStreamWriter(outputStream,"UTF-8");
			char buffer[] = content.toCharArray();
			// 写入输出流
			writer.write(buffer, 0, buffer.length);
			// 关闭输出流
			writer.close();
		}
	}
	
	//删除文件
	public static void delete(String filepath){
		File file=new File(filepath);
		if(file.isFile()){
			file.delete();
		}
	}

	/**
	 * 以行为单位读取文件，常用于读面向行的格式化文件
	 */
	public static void readFileByLines(String fileName) {
		File file = new File(fileName);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
			String tempString = null;
			StringBuffer jsonlist = new StringBuffer("");
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				jsonlist.append(tempString);
			}
			reader.close();
			System.out.println(jsonlist);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
	}
}
