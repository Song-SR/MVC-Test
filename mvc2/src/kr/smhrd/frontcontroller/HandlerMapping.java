package kr.smhrd.frontcontroller;

import java.util.HashMap;

import kr.smhrd.controller.Controller;
import kr.smhrd.controller.MemberContentController;
import kr.smhrd.controller.MemberDeleteController;
import kr.smhrd.controller.MemberInsertController;
import kr.smhrd.controller.MemberInsertFormController;
import kr.smhrd.controller.MemberListController;
import kr.smhrd.controller.MemberLoginController;
import kr.smhrd.controller.MemberUpdateController;

// /list.do  ---> new MemberListController()
// /insert.do  ---> new MemberInsertController()
// ...

public class HandlerMapping {
	
	private HashMap<String, Controller> mappings;
	
	public HandlerMapping (){
		mappings = new HashMap<>();
		initUrl();    // (추측) public으로 key, value를 설정하지 말고 private로 메서드를 만들어서 연결하려나봄. 
	}
	
	private void initUrl() {  // key -> value(pojo) 연결작업
		mappings.put("/list.do", new MemberListController());
		mappings.put("/insertForm.do", new MemberInsertFormController());
		mappings.put("/insert.do", new MemberInsertController());
		mappings.put("/content.do", new MemberContentController());
		mappings.put("/delete.do", new MemberDeleteController());
		mappings.put("/update.do", new MemberUpdateController());
	}
	public Controller getController(String command) {
		return mappings.get(command);
	}
}
