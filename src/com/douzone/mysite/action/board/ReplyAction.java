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
import com.douzone.mysite.vo.UserVo;

public class ReplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String no = request.getParameter("no");
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		
		List<BoardVo> list = new BoardDao().getList(no);
		
		long group_no = list.get(0).getGroup_no();
		long order_no = list.get(0).getOrder_no() + 1;
		long depth = list.get(0).getDepth() + 1;
		
		HttpSession session = request.getSession();
		HttpServletResponse respnonse=null;
		UserVo uv = (UserVo)session.getAttribute("authuser");
		
		BoardVo vo = new BoardVo();
		vo.setTitle(title);
		vo.setContents(contents);
		vo.setGroup_no(group_no);
		vo.setOrder_no(order_no);
		vo.setDepth(depth);
		vo.setUser_no(uv.getNo());
		
		BoardVo vo1 = new BoardVo();
		vo1.setGroup_no(group_no);
		vo1.setOrder_no(order_no);
		
		//new BoardDao().update(vo1);
		
		new BoardDao().insert(vo);
		
		WebUtils.redirect(request, respnonse, request.getContextPath() + "/board?a=list");
	}

}
