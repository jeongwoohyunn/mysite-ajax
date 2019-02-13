package com.douzone.mysite.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzone.mvc.action.Action;
import com.douzone.mvc.util.WebUtils;
import com.douzone.mysite.repository.BoardDao;
import com.douzone.mysite.vo.BoardVo;
public class ViewAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		
		long no = Long.parseLong(request.getParameter("no"));
		
		new BoardDao().update(no);
		
		BoardVo vo = new BoardDao().get(no);
		
		
		request.setAttribute("title", vo.getTitle());
		request.setAttribute("contents",vo.getContents());
		request.setAttribute("no", vo.getNo());
		request.setAttribute("user_no", vo.getUser_no());
		request.setAttribute("session",session.getAttribute("authuser"));
		WebUtils.forward(request, response, "/WEB-INF/views/board/view.jsp");
	}
}
