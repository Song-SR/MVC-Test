package kr.smhrd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.smhrd.model.MemberDAO;
import kr.smhrd.model.MemberVO;

public class MemberInsertController implements Controller {
	
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException  {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		
		MemberVO vo = new MemberVO(id, pass, name, tel, email);
		MemberDAO dao = new MemberDAO();
		
		int cnt = dao.memberInsert(vo);
		String nextView = null;
		String ctx = request.getContextPath();
		
		if(cnt > 0) {
			nextView="redirect:"+ctx+"/list.do";
		}else {
			throw new ServletException("error");
		}
		return nextView;
	}
}
