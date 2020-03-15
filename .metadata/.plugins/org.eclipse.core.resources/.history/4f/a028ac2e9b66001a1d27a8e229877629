package com.iu.s4.util;

import java.io.File;

import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {

	//1. Spring에서 제공하는 FileCopyUtils 클래스의 copy메서드 사용
	public String save(String realPath, MultipartFile multipartFile) throws Exception{
		System.out.println(realPath);
		File file = new File(realPath);

		if(!file.exists()) {
			file.mkdirs();
		}
		Calendar cal = Calendar.getInstance();
		Long name = cal.getTimeInMillis();

		String fne = multipartFile.getOriginalFilename();
		fne = fne.substring(fne.lastIndexOf("."));	
		String fileName = name + fne; 
		
		//		System.out.println(fne);
		file = new File(realPath, String.valueOf(fileName));

		FileCopyUtils.copy(multipartFile.getBytes(), file);

		return fileName;
	}
	//2. MultipartFile transferTo 메서드 사용
	public String save2(String realPath, MultipartFile multipartFile) throws Exception{
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}

		//저장할 파일명
		String fileName = UUID.randomUUID().toString(); 
		fileName = fileName + "_" + multipartFile.getOriginalFilename();

		file = new File(realPath, fileName);

		multipartFile.transferTo(file);

		return fileName;
	}
	//3. IO Stream 연결
	public String save3(String realPath, MultipartFile multipartFile) throws Exception{
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//저장할 파일명
		String fileName = UUID.randomUUID().toString(); 
		fileName = fileName + "_" + multipartFile.getOriginalFilename();

		file = new File(realPath, fileName);
		
		FileOutputStream fo = new FileOutputStream(file);
		
		fo.write(multipartFile.getBytes());
		fo.close();	
		return fileName;
	}

	
	//file Delete
	public Boolean fileDelete(String realPath, String filename) throws Exception {
		File file = new File(realPath, filename);
		boolean check = false;
		if (file.exists()) {
			check = file.delete();
		}
		
		return check;
	}
}
