package com.iu.s4.service;

import javax.servlet.http.HttpSession;

import com.iu.s4.model.MemberVO;

public interface MemberService {

	//join
	public int memberJoin(MemberVO memberVO, HttpSession session) throws Exception;
	//login
	public MemberVO memberLogin(MemberVO memberVO) throws Exception;
	//update
	public int memberUpdate(MemberVO memberVO) throws Exception;
	//delete
	public int memberDelete(MemberVO memberVO) throws Exception;
	//point update
	public int memberPointUpdate(MemberVO memberVO) throws Exception;
	//아이디 체크
	public MemberVO memberCheckId(MemberVO memberVO) throws Exception;
	//아이디 검색
	public MemberVO memberSearchId(MemberVO memberVO) throws Exception;
	//pw search
	public MemberVO memberSearchPw(MemberVO memberVO) throws Exception;
	//이메일 체크
	public MemberVO memberCheckEmail(MemberVO memberVO) throws Exception;
}