package kr.smhrd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.smhrd.model.MemberDAO;
import kr.smhrd.model.MemberVO;

public class MemberDeleteController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException  {
		
		int num = Integer.parseInt(request.getParameter("num"));
		MemberVO vo = new MemberVO();
		vo.setNum(num);
		MemberDAO dao = new MemberDAO();
		
		int cnt = dao.memberDelete(num);
		String nextView = null;
		String ctx = request.getContextPath();
		if(cnt > 0) {
			nextView = "redirect:"+ctx+"/list.do";
		}else {
			throw new ServletException();
		}
		return nextView;
		
	}
	
}
