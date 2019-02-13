package com.douzone.mysite.action.board;

import com.douzone.mvc.action.AbstractActionFactory;
import com.douzone.mvc.action.Action;
import com.douzone.mysite.action.main.IndexAction;

public class BoardActionFactory extends AbstractActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;

		if ("list".equals(actionName)) {
			action = new ListAction1();
		} else if ("insert".equals(actionName)) {
			action = new ListInsertAction1();
		} else if ("view".equals(actionName)) {
			action = new ViewAction();
		} else if ("modify".equals(actionName)) {
			
			System.out.println("2");
			action = new ModifyAction();
		} else if ("write".equals(actionName)) {
			action = new WriteAction();
		} else if ("select".equals(actionName)) {
			action = new ListSelectAction1();
		} else if ("delete".equals(actionName)) {
			action = new DeleteAction1();
		} else if ("modifyformaction".equals(actionName)) {
			action = new ModifyFormAction();
		} else if ("reply".equals(actionName)) {
			action = new ReplyAction();
		} else if ("replyform".equals(actionName)) {
			action = new ReplyFormAction();
		}else {
			action = new IndexAction();
		}
		return action;
	}
}
