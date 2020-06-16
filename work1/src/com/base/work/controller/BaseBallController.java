package com.base.work.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.base.work.action.Action;
import com.base.work.action.ver.ProductCountAction;
import com.base.work.action.ver.ProductHomeAction;
import com.base.work.action.ver.ProductPriceAction;
import com.base.work.action.ver.ProductVer1Action;
import com.base.work.action.ver2.ProductDeleteProcAction;
import com.base.work.action.ver2.ProductVer2Action;
import com.base.work.action.ver3.BaseBallPlayerAction;
import com.base.work.action.ver3.BaseBallPlayerInfoAction;
import com.base.work.action.ver3.BaseBallTeamAction;
import com.base.work.action.ver3.BaseBallVer3Action;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/baseball")
public class BaseBallController extends HttpServlet {
	private final static String TAG = "BaseBallController : ";
	private static final long serialVersionUID = 1L;

	public BaseBallController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		System.out.println(TAG + "router() : " + cmd);

		Action action = router(cmd);
		action.execute(request, response);
	}

	public Action router(String cmd) {
		if(cmd.equals("ver3")) {
			return new BaseBallVer3Action();
		}else if(cmd.equals("team")) {
			return new BaseBallTeamAction();
		}else if(cmd.equals("player")) {
			return new BaseBallPlayerAction();
		}else if(cmd.equals("playerInfo")) {
			return new BaseBallPlayerInfoAction();
		}
		return null;
	}
}
