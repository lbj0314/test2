package com.iu.s4.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s4.dao.BoardQnaDAO;
import com.iu.s4.dao.QnaFilesDAO;
import com.iu.s4.model.BoardQnaVO;
import com.iu.s4.model.BoardVO;
import com.iu.s4.model.FilesVO;
import com.iu.s4.util.FileSaver;
import com.iu.s4.util.Pager;

@Service
public class BoardQnaService implements BoardService {
	
	@Inject
	private BoardQnaDAO boardQnaDAO;
	@Inject
	private FileSaver fileSaver;
	@Inject
	private QnaFilesDAO qnaFilesDAO;
	
	
	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makePager(boardQnaDAO.boardCount(pager));
		return boardQnaDAO.boardList(pager);
	}

	@Override
	public BoardVO boardSelect(BoardVO boardVO) throws Exception {
//		boardVO.getNum();
//		boardVO = boardQnaDAO.boardSelect(boardVO);
//		
//		BoardQnaVO boardQnaVO = (BoardQnaVO) boardVO;
//		
//		List<QnaFilesVO> ar = qnaFilesDAO.fileList(boardVO.getNum());
//		
//		boardQnaVO.setFiles(ar);
		
		return boardQnaDAO.boardSelect(boardVO);
	}

	@Override
	public int boardWrite(BoardVO boardVO, MultipartFile[] file, HttpSession session) throws Exception {
		String realPath = session.getServletContext().getRealPath("resources/upload/qna");
		FilesVO qnaFilesVO = new FilesVO();
		int result = boardQnaDAO.boardWrite(boardVO);
		
		System.out.println(file);
		
		for (MultipartFile multipartFile:file) {
			String fileName = fileSaver.save(realPath, multipartFile);
			qnaFilesVO.setFname(fileName);
			qnaFilesVO.setNum(boardVO.getNum());
			qnaFilesVO.setOname(multipartFile.getOriginalFilename());
			result = qnaFilesDAO.fileWrite(qnaFilesVO);
		}
		return result;
	}

	@Override
	public int boardUpdate(BoardVO boardVO, MultipartFile[] file, HttpSession session) throws Exception {
		return boardQnaDAO.boardUpdate(boardVO);
	}

	@Override
	public int boardDelete(BoardVO boardVO) throws Exception {
		boardVO.getNum();
		return boardQnaDAO.boardDelete(boardVO);
	}

	public int boardReply(BoardVO boardVO, MultipartFile[] file, HttpSession session) throws Exception {
		BoardQnaVO parent = (BoardQnaVO)boardQnaDAO.boardSelect(boardVO);
		int result = boardQnaDAO.boardReplyUpdate(parent);

		return boardQnaDAO.boardReply(boardVO);
	}

	public int fileDelete(FilesVO qnaFilesVO) {
		// TODO Auto-generated method stub
		return qnaFilesDAO.fileDelete(qnaFilesVO);
	}

	public FilesVO fileSelect(FilesVO qnaFilesVO) {
		// TODO Auto-generated method stub
		return qnaFilesDAO.fileSelect(qnaFilesVO);
	}

	
}
