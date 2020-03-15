package com.iu.s4.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s4.model.BoardVO;
import com.iu.s4.model.FilesVO;
import com.iu.s4.service.BoardNoticeService;
import com.iu.s4.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {

	@Inject
	private BoardNoticeService boardNoticeService;

	//list
	@RequestMapping(value = "noticeList")
	public ModelAndView boardList(Pager pager) throws Exception {
		List<BoardVO> list = boardNoticeService.boardList(pager);
		ModelAndView mv = new ModelAndView();
		mv.addObject("pager", pager);
		mv.addObject("list", list);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardList");

		return mv;
	}

	//select One
	@RequestMapping(value = "noticeSelect", method = RequestMethod.GET)
	public ModelAndView boardSelect(BoardVO boardVO) throws Exception{
		boardVO = boardNoticeService.boardSelect(boardVO);
		ModelAndView mv = new ModelAndView();
		if(boardVO != null) {
			mv.addObject("vo", boardVO);
			mv.addObject("board", "notice");
			boardVO.setContents(boardVO.getContents().replace("\r\n", "<br>"));
			mv.setViewName("board/boardSelect");
		} else {
			mv.addObject("msg", "No Contents");
			mv.addObject("path", "./noticeList");
			mv.setViewName("common/common_result");
		}
		return mv;
	}
	//write
	@RequestMapping(value = "noticeWrite", method = RequestMethod.GET)
	public ModelAndView boardWrite() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", "notice");
		mv.setViewName("board/boardWrite");
		return mv;

	}
	@RequestMapping(value="noticeWrite", method = RequestMethod.POST)
	public ModelAndView boardWrite(BoardVO boardVO, MultipartFile[] file, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		//		System.out.println(file);
		int result = boardNoticeService.boardWrite(boardVO, file, session);
		String msg = "Write Fail";

		if (result > 0) {
			mv.setViewName("redirect:./noticeList");
			//			msg = "Write Success";
		}else {
			mv.addObject("msg", msg);
			mv.addObject("path", "./noticeList");
			mv.setViewName("common/common_result");
		}
		return mv;
	}

	//update
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.GET)
	public ModelAndView boardUpdate2(BoardVO boardVO) throws Exception{
		boardVO = boardNoticeService.boardSelect(boardVO);
		ModelAndView mv = new ModelAndView();
		if(boardVO != null) {
			//			BoardNoticeVO noticeVO = (BoardNoticeVO) boardVO;
			//			int size = noticeVO.getFiles().size();
			//			mv.addObject("size", size);
			mv.addObject("vo", boardVO);
			mv.addObject("board", "notice");
			mv.setViewName("board/boardUpdate");
		} else {
			mv.addObject("msg", "No Contents");
			mv.addObject("path", "./noticeList");
			mv.setViewName("common/common_result");
		}
		return mv;
	}
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
	public ModelAndView boardUpdate(BoardVO boardVO, MultipartFile[] file, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = boardNoticeService.boardUpdate(boardVO, file, session);
		String msg = "Update Fail";
		System.out.println(result);
		if (result > 0) {
			mv.setViewName("redirect:./noticeList");
			//			msg = "Update Success";
		}else {
			mv.addObject("msg", msg);
			mv.addObject("path", "./noticeList");
			mv.setViewName("common/common_result");
		}
		return mv;


	}

	//delete
	@RequestMapping(value = "noticeDelete", method = RequestMethod.GET)
	public ModelAndView boardDelete(BoardVO boardVO) throws Exception{
		int result = boardNoticeService.boardDelete(boardVO);
		ModelAndView mv = new ModelAndView();
		String msg = "Delete Fail";
		if (result > 0) {
			mv.setViewName("redirect:./noticeList");
		} else {
			mv.addObject("msg", msg);
			mv.addObject("path", "./noticeList");
			mv.setViewName("common/common_result");
		}
		return mv;
	}

	@PostMapping(value = "fileDelete")
	public ModelAndView fileDelete(FilesVO filesVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = boardNoticeService.fileDelete(filesVO);
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
		filesVO = boardNoticeService.fileSelect(filesVO);

		mv.addObject("file", filesVO);
		mv.addObject("board", "notice");
		mv.setViewName("fileDown");

		return mv;
	}
	
	@PostMapping(value = "summerFile")
	public ModelAndView summerFile(MultipartFile file, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		String fileName = boardNoticeService.summerFile(file, session);
		
		mv.addObject("result", fileName);
		mv.setViewName("common/common_ajaxResult");
		
		return mv;
	}
	
	@PostMapping(value = "summerFileDelete")
	public ModelAndView summerDelete(String file, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		boolean check = boardNoticeService.summerFileDelete(file, session);
		String result = "Delete Fail";
		if(check) {
			result = "Delete Success";
		}
		mv.addObject("result", result);
		mv.setViewName("common/common_ajaxResult");
		return mv;
	}
	
}
