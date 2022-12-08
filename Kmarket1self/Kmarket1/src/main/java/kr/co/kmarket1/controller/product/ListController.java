package kr.co.kmarket1.controller.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket1.service.ProductService;

@WebServlet("/product/list.do")
public class ListController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductService service = ProductService.INSTANCE; 
	@Override
	public void init() throws ServletException {
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String prodCate1 = req.getParameter("prodCate1");
		String prodCate2 = req.getParameter("prodCate2");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/product/list.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}