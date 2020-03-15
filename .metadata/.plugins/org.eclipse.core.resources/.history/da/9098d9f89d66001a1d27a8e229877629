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

import com.iu.s4.model.BoardNoticeVO;
import com.iu.s4.model.BoardQnaVO;
import com.iu.s4.model.BoardVO;
import com.iu.s4.model.FilesVO;
import com.iu.s4.service.BoardQnaService;
import com.iu.s4.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {

	@Inject
	private BoardQnaService boardQnaService;

	//list
	@RequestMapping(value = "qnaList", method = RequestMethod.GET)
	public ModelAndView boardList(Pager pager) throws Exception{
		List<BoardVO> list = boardQnaService.boardList(pager);
		ModelAndView mv = new ModelAndView();
		if (list != null) {
			
		mv.addObject("pager", pager);
		mv.addObject("list", list);
		mv.addObject("board", "qna");
		mv.setViewName("board/boardList");
		BoardVO boardVO = new BoardQnaVO();
		}else {
			mv.addObject("msg", "No Contents");
			mv.addObject("path", "./qnaList");
			mv.setViewName("common/common_result");
		}

		return mv;
	}

	//select One
	@RequestMapping(value = "qnaSelect", method = RequestMethod.GET)
	public ModelAndView boardSelect(BoardVO boardVO) throws Exception{
		boardVO = boardQnaService.boardSelect(boardVO);
		ModelAndView mv = new ModelAndView();
		if(boardVO != null) {
			mv.addObject("vo", boardVO);
			mv.addObject("board", "qna");
			mv.setViewName("board/boardSelect");
		} else {
			mv.addObject("msg", "No Contents");
			mv.addObject("path", "./qnaList");
			mv.setViewName("common/common_result");
		}
		return mv;
	}

	//write
	@RequestMapping(value = "qnaWrite", method = RequestMethod.GET)
	public ModelAndView boardWrite() throws Exception{
		ModelAndView mv = new ModelAndView();

		mv.addObject("board", "qna");
		mv.setViewName("board/boardWrite");

		return mv;

	}
	@RequestMapping(value="qnaWrite", method = RequestMethod.POST)
	public ModelAndView boardWrite(BoardVO boardVO, MultipartFile[] file, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = boardQnaService.boardWrite(boardVO, file, session);
		String msg = "Write Fail";
		if (result > 0) {
			mv.setViewName("redirect:./qnaList");
			//			msg = "Write Success";
		}else {
			mv.addObject("msg", msg);
			mv.addObject("path", "./qnaList");
			mv.setViewName("common/common_result");
		}
		return mv;
	}

	//update
	@RequestMapping(value = "qnaUpdate", method = RequestMethod.GET)
	public ModelAndView boardUpdate2(BoardVO boardVO) throws Exception{
		boardVO = boardQnaService.boardSelect(boardVO);
		ModelAndView mv = new ModelAndView();
		if(boardVO != null) {
		mv.addObject("vo", boardVO);
		mv.addObject("board", "qna");
		mv.setViewName("board/boardUpdate");
		} else {
			mv.addObject("msg", "No Contents");
			mv.addObject("path", "./qnaList");
			mv.setViewName("common/common_result");
		}
		return mv;
	}
	@RequestMapping(value = "qnaUpdate", method = RequestMethod.POST)
	public ModelAndView boardUpdate(BoardVO boardVO, MultipartFile[] file, HttpSession session) throws Exception{
		int result = boardQnaService.boardUpdate(boardVO, file, session);
		ModelAndView mv = new ModelAndView();
		String msg = "Update Fail";
		if (result > 0) {
			//			msg = "Update Success";
			mv.setViewName("redirect:./qnaList");			
		}else {
			mv.addObject("msg", msg);
			mv.addObject("path", "./qnaList");
			mv.setViewName("common/common_result");
		}
		return mv;


	}
	//delete
	@RequestMapping(value = "qnaDelete", method = RequestMethod.GET)
	public ModelAndView boardDelete(BoardVO boardVO) throws Exception{
		int result = boardQnaService.boardDelete(boardVO);
		ModelAndView mv = new ModelAndView();
		String msg = "Delete Fail";
		if (result > 0) {
			mv.setViewName("redirect:./qnaList");
		} else {
			mv.addObject("msg", msg);
			mv.addObject("path", "./qnaList");
			mv.setViewName("common/common_result");
		}
		return mv;
	}
	//reply
	@RequestMapping(value = "qnaReply", method = RequestMethod.GET)
	public ModelAndView boardReply2(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", boardVO);
		mv.addObject("board", "qna");
		mv.setViewName("board/boardReply");

		return mv;
	}

	@RequestMapping(value = "qnaReply", method = RequestMethod.POST)
	public ModelAndView boardReply(BoardVO boardVO, MultipartFile[] file, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = boardQnaService.boardReply(boardVO, file, session);
		String msg = "Reply Fail";
		if(result > 0) {
			mv.setViewName("redirect:./qnaList");
		} else {
			mv.addObject("msg", msg);
			mv.addObject("path", "./qnaList");
			mv.setViewName("common/common_result");
		}
		return mv;
	}
	
	@PostMapping(value = "fileDelete")
	public ModelAndView fileDelete(FilesVO filesVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = boardQnaService.fileDelete(filesVO);
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
		filesVO = boardQnaService.fileSelect(filesVO);

		mv.addObject("file", filesVO);
		mv.addObject("board", "qna");
		mv.setViewName("fileDown");

		return mv;
	}
}