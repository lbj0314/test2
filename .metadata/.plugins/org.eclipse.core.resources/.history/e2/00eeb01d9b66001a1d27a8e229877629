package com.iu.s4.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.iu.s4.model.FilesVO;

@Component
public class FileDown extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		FilesVO filesVO = (FilesVO)model.get("file");
		String board = (String)model.get("board");
		String realPath = request.getSession().getServletContext().getRealPath("resources/upload/"+board);
		System.out.println(realPath);
		
		File file = new File(realPath, filesVO.getFname());
		
		//1. 한글 처리
		response.setCharacterEncoding("UTF-8");
		
		//2. 파일의 크기
		response.setContentLength((int)file.length());
		
		//3. download 시에 파일 이름 인코딩
		String fileName = URLEncoder.encode(filesVO.getOname(), "UTF-8");
		
		//4. header 설정														다운로드하는 이름
		response.setHeader("Content-disposition", "attachment; filename=\""+fileName+"\"");
		response.setHeader("Content-transfer-Encoding", "binary");
		
		//5. OutputStream
		FileInputStream fi = new FileInputStream(file);
		OutputStream os = response.getOutputStream();
		
		//6. 보내주기
		FileCopyUtils.copy(fi, os);
		os.close();
		fi.close();
		
	}
	
}
