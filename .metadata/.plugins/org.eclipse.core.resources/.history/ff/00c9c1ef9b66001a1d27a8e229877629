package com.iu.s4.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.iu.s4.model.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "memberMapper.";
	@Override
	public int memberJoin(MemberVO memberVO) throws Exception {
		return sqlSession.insert(NAMESPACE + "memberJoin", memberVO);
	}

	@Override
	public MemberVO memberLogin(MemberVO memberVO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"memberLogin", memberVO) ;
	}

	@Override
	public int memberUpdate(MemberVO memberVO) throws Exception {
		return sqlSession.update(NAMESPACE+"memberUpdate", memberVO);
	}

	@Override
	public int memberDelete(MemberVO memberVO) throws Exception {
		return sqlSession.delete(NAMESPACE+"memberDelete", memberVO);
	}

	@Override
	public int memberPointUpdate(MemberVO memberVO) throws Exception {
		return 0;
	}

	@Override
	public MemberVO memberCheckId(MemberVO memberVO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"memberCheckId", memberVO);
	}

	@Override
	public MemberVO memberSearchId(MemberVO memberVO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"memberSearchId", memberVO);
	}

	@Override
	public MemberVO memberSearchPw(MemberVO memberVO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"memberSearchPw", memberVO);
	}

	@Override
	public MemberVO memberCheckEmail(MemberVO memberVO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"memberCheckEmail", memberVO);
	}
	
}
