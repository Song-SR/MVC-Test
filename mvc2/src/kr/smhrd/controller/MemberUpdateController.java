package kr.smhrd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.smhrd.model.MemberDAO;
import kr.smhrd.model.MemberVO;

public class MemberUpdateController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException  {
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();

		int num = Integer.parseInt(request.getParameter("num"));
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		vo.setNum(num);
		vo.setTel(tel);
		vo.setEmail(email);

		int cnt = dao.memberUpdate(vo);
		String nextView = null;
		String ctx = request.getContextPath();
		if (cnt > 0) {
			nextView = "redirect:"+ctx+"/list.do";
		} else {
			throw new ServletException();
		}
		return nextView;
	}
	
}
