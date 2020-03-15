package com.iu.s4.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s4.dao.BoardNoticeDAO;
import com.iu.s4.dao.NoticeFilesDAO;
import com.iu.s4.model.BoardNoticeVO;
import com.iu.s4.model.BoardVO;
import com.iu.s4.model.FilesVO;
import com.iu.s4.util.FileSaver;
import com.iu.s4.util.Pager;

@Service
public class BoardNoticeService implements BoardService {

	@Inject
	private BoardNoticeDAO boardNoticeDAO;
	@Inject
	private FileSaver fileSaver;
	@Inject
	private NoticeFilesDAO noticeFilesDAO;

	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makePager(boardNoticeDAO.boardCount(pager));
		return boardNoticeDAO.boardList(pager);
	}

	@Override
	public BoardVO boardSelect(BoardVO boardVO) throws Exception {
		//		boardVO.getNum();
		//		boardVO = boardNoticeDAO.boardSelect(boardVO);

		//		BoardNoticeVO boardNoticeVO = (BoardNoticeVO)boardVO;

		//		List<FilesVO> ar = filesDAO.fileList(boardVO.getNum());

		//		boardNoticeVO.setFiles(ar);

		return boardNoticeDAO.boardSelect(boardVO);
	}

	@Override
	public int boardWrite(BoardVO boardVO, MultipartFile[] file, HttpSession session) throws Exception {
		String realPath = session.getServletContext().getRealPath("resources/upload/notice");
		FilesVO filesVO = new FilesVO();
		int result = boardNoticeDAO.boardWrite(boardVO);
		//		System.out.println(file);
		//		System.out.println(boardVO.getNum());
		for(MultipartFile multipartFile:file) {
//			if (multipartFile.getSize() != 0) {
				String fileName = fileSaver.save(realPath, multipartFile);
				filesVO.setFname(fileName);
				filesVO.setNum(boardVO.getNum());
				filesVO.setOname(multipartFile.getOriginalFilename());
				result = noticeFilesDAO.fileWrite(filesVO);
//			}

		}
		return result;
	}

	@Override
	public int boardUpdate(BoardVO boardVO, MultipartFile[] file, HttpSession session) throws Exception {
		String realPath = session.getServletContext().getRealPath("resources/upload/notice");
		FilesVO filesVO = new FilesVO();
		int result = boardNoticeDAO.boardUpdate(boardVO);
		for (MultipartFile multipartFile:file) {
			if (multipartFile.getOriginalFilename() != "") {
				String fileName = fileSaver.save(realPath, multipartFile);
				filesVO.setFname(fileName);
				filesVO.setNum(boardVO.getNum());
				filesVO.setOname(multipartFile.getOriginalFilename());
				result = noticeFilesDAO.fileWrite(filesVO);
			}
		}
		return result;
	}

	@Override
	public int boardDelete(BoardVO boardVO) throws Exception {
		//		boardVO.getNum();
		return boardNoticeDAO.boardDelete(boardVO);
	}

	public int fileDelete(FilesVO filesVO) throws Exception{
		return noticeFilesDAO.fileDelete(filesVO);
	}

	public FilesVO fileSelect(FilesVO filesVO) throws Exception{
		return noticeFilesDAO.fileSelect(filesVO);
	}
	
	public String summerFile(MultipartFile file, HttpSession session) throws Exception{
		String realPath = session.getServletContext().getRealPath("resources/upload/summerFile");
		return fileSaver.save(realPath, file);
	}
	
	public Boolean summerFileDelete(String file, HttpSession session) throws Exception{
		String realPath = session.getServletContext().getRealPath("resources/upload/summerFile");
		return fileSaver.fileDelete(realPath, file);
	}
}
