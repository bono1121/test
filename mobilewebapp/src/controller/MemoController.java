package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemoDAO;
import dao.MemoDAOImpl;
import model.Memo;
import page.PageManager;
import page.PageSQL;

@WebServlet(name="MemoController", urlPatterns= {"/memo_input",
		"/memo_save", "/memo_list","/memo_detail","/memo_update",
		"/memo_delete", "/memo_search","/memo_req_list"} )
public class MemoController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);	
	}
	
		
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
				
		int lastIndex = uri.lastIndexOf("/");		
		String action = uri.substring(lastIndex+1);
		
		req.setCharacterEncoding("utf-8");
		
		if(action.equals("memo_input")) {
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/memo/memoForm.jsp");
			rd.forward(req, resp);
			
		}else if(action.equals("memo_save")) {
			
			req.setCharacterEncoding("utf-8");
			
			MemoDAO dao = new MemoDAOImpl();
			Memo memo = new Memo();
			
			memo.setName(req.getParameter("name"));
			memo.setAge(Integer.parseInt(req.getParameter("age")));
			
			boolean result = dao.insert(memo);
			
			System.out.println(result);			
			
			resp.sendRedirect("memo_req_list?reqPage=1");
			
		}else if(action.equals("memo_list")) {
			
			req.setCharacterEncoding("utf-8");
			
			MemoDAO dao = new MemoDAOImpl();
			List<Memo> memoList = dao.selectAll();
			
			req.setAttribute("memos", memoList);
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/memo/memoList.jsp");
			rd.forward(req, resp);	
			
		}else if(action.equals("memo_detail")) {
			
			int memoid = Integer.parseInt(req.getParameter("memoid"));
			
			MemoDAO dao = new MemoDAOImpl();
			Memo memo = dao.selectByMemoId(memoid);
			
			req.setAttribute("memo", memo);
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/memo/memoDetail.jsp");
			rd.forward(req, resp);			
		}else if(action.equals("memo_update")) {
			
			Memo memo = new Memo();
			
			memo.setMemoid(Integer.parseInt(req.getParameter("memoid")));
			memo.setName(req.getParameter("name"));
			memo.setAge(Integer.parseInt(req.getParameter("age")));			
			
			MemoDAO dao = new MemoDAOImpl();
			boolean result  = dao.update(memo);
			
			RequestDispatcher rd = req.getRequestDispatcher("/memo_list");
			rd.forward(req, resp);						
		
		}else if(action.equals("memo_delete")) {
			
			int memoid =Integer.parseInt(req.getParameter("memoid"));

			MemoDAO dao = new MemoDAOImpl();
			boolean result  = dao.deleteByMemoId(memoid);
			
			RequestDispatcher rd = req.getRequestDispatcher("/memo_list");
			rd.forward(req, resp);									
		
		}else if(action.equals("memo_search")) {
			String name = req.getParameter("name");
			
			MemoDAO dao = new MemoDAOImpl();
			List<Memo> memoList = dao.selectByName(name);
			
			req.setAttribute("memos", memoList);

			RequestDispatcher rd = req.getRequestDispatcher("/jsp/memo/memoList.jsp");
			rd.forward(req, resp);	
		
		}else if(action.equals("memo_req_list")) {
			int requestPage = Integer.parseInt(req.getParameter("reqPage"));
			PageManager pm = new PageManager(requestPage);
			
			MemoDAO dao = new MemoDAOImpl();
			List<Memo> memos = dao.selectAll(
					pm.getPageRowResult().getRowStartNumber(), pm.getPageRowResult().getRowEndNumber());
			
			req.setAttribute("memos", memos);
			req.setAttribute("pageGroupResult", pm.getPageGroupResult(PageSQL.MEMO_SELECT_ALL_COUNT));
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/memo/memoList.jsp");
			rd.forward(req, resp);	
			
		}
	}//process()				
}//class

//로직(주소확인)

//뷰설정

//포워드	