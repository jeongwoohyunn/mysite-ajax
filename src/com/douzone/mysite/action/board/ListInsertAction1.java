package com.douzone.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzone.mvc.action.Action;
import com.douzone.mvc.util.WebUtils;
import com.douzone.mysite.repository.BoardDao;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.mysite.vo.UserVo;


public class ListInsertAction1 implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		
		HttpSession hs = request.getSession();
		
		UserVo uvo = (UserVo) hs.getAttribute("authuser"); 
		
		
		new BoardDao().insert(title,contents,uvo.getNo());
		
		WebUtils.redirect(request, response, request.getContextPath()+"/board?a=select");
	}

}
