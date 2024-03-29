package com.momo.rental.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.momo.rental.dao.ImgFilesDAO;
import com.momo.rental.model.FilesVO;
import com.momo.rental.util.FileSaver;

@Service
public class ImgService {
	
	@Autowired
	private ImgFilesDAO imgFilesDAO;
	
	@Autowired
	private FileSaver fileSaver;
	
	public int imgWrite(MultipartFile[] file, HttpSession session) throws Exception{
		String realPath = session.getServletContext().getRealPath("resources/upload/img");
		FilesVO filesVO = new FilesVO();
		int result = imgFilesDAO.fileWrite(filesVO);
		
		for (MultipartFile multipartFile : file) {
			String fileName = fileSaver.save(realPath, multipartFile);
			filesVO.setFname(fileName);
			filesVO.setOname(multipartFile.getOriginalFilename());
			result = imgFilesDAO.fileWrite(filesVO);
		}
		return result;
	}
	
	public int fileDelete(FilesVO filesVO) throws Exception{
		return imgFilesDAO.fileDelete(filesVO);
	}
	
	public FilesVO fileSelect(FilesVO filesVO) throws Exception{
		return imgFilesDAO.fileSelect(filesVO);
	}
	
}
