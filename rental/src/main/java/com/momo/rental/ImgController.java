package com.momo.rental;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.momo.rental.model.FilesVO;
import com.momo.rental.service.ImgService;

@Controller
public class ImgController {
	
	@Autowired
	private ImgService imgService;
	
	@GetMapping(value = "fileWrite")
	public ModelAndView fileWrite() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("img", "img");
		mv.setViewName("img/imgWrite");
		return mv;
	}
	
	@PostMapping(value = "fileWrite")
	public ModelAndView fileWrite(MultipartFile[] file, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = imgService.imgWrite(file, session);
		String msg = "file Write Fail";
		if (result > 0) {
			mv.setViewName("redirect:../home");
		} else {
			mv.addObject("msg", msg);
			mv.addObject("path", "./");
			mv.setViewName("common/common_result");
		}
		
		return mv;
	}
	
	@PostMapping(value = "fileDelete")
	public ModelAndView fileDelete(FilesVO filesVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = imgService.fileDelete(filesVO);
		String msg = "Delete Fail";
		if (result > 0) {
			mv.addObject("result", result);
			mv.setViewName("common/common_ajaxResult");
		} else {
			mv.addObject("msg", msg);
			mv.addObject("path", "./noticeSelect");
			mv.setViewName("common/common_result");
		}
		return mv;
	}
	
	@GetMapping(value ="fileDown")
	public ModelAndView fileDown(FilesVO filesVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		filesVO = imgService.fileSelect(filesVO);

		mv.addObject("file", filesVO);
		mv.addObject("board", "qna");
		mv.setViewName("fileDown");

		return mv;
	}
	
}
