package kr.smhrd.frontcontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.smhrd.controller.Controller;
import kr.smhrd.controller.MemberContentController;
import kr.smhrd.controller.MemberDeleteController;
import kr.smhrd.controller.MemberInsertController;
import kr.smhrd.controller.MemberInsertFormController;
import kr.smhrd.controller.MemberListController;
import kr.smhrd.controller.MemberUpdateController;
import kr.smhrd.model.MemberDAO;
import kr.smhrd.model.MemberVO;

public class MemberFrontController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 1. 어떤 요청인지 확인
		String reqUrl = request.getRequestURI();
		// System.out.println(reqUrl);
		String ctx = request.getContextPath();
		// System.out.println(ctx);
		String command = reqUrl.substring(ctx.length());
		System.out.println(command);
		
		Controller controller = null;
		String nextView = null;
		
		// 2. 요청에 따른 분기작업(HandlerMapping)  -- 아래 주석 처리 참조
		HandlerMapping mappings = new HandlerMapping();
		controller = mappings.getController(command);
		
		if(controller != null) {
			nextView = controller.requestHandler(request, response);
		}
		
		// 3. nextView (View페이지로 전환)
		if (nextView != null) {
			if(nextView.indexOf("redirect:") != -1) { //indexOf는 값이 없으면 -1임!!
				response.sendRedirect(nextView.split(":")[1]);  // split을 기준으로 자른후에 [0],[1].. 식으로 나뉜다
				// response.sendRedirect(nextView.substring(9));  // 기능은 동일(redirect: 문구 지워버리기)
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/"+nextView+".jsp");
				rd.forward(request, response);
			}
		}
		
	}
}
