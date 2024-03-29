package com.momo.rental.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.momo.rental.model.FilesVO;

@Repository
public class ImgFilesDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "imgFilesMapper.";
	
	//
	public int fileWrite(FilesVO filesVO) throws Exception{
		return sqlSession.insert(NAMESPACE + "fileWrite", filesVO);
	}
	
	public List<FilesVO> fileList(int num) throws Exception{
		return sqlSession.selectList(NAMESPACE + "fileList", num);
	}
	
	public int fileDelete(FilesVO filesVO) throws Exception{
		return sqlSession.delete(NAMESPACE + "fileDelete", filesVO);
	}
	
	public FilesVO fileSelect(FilesVO filesVO) throws Exception{
		return sqlSession.selectOne(NAMESPACE + "fileSelect", filesVO);
	}
}
