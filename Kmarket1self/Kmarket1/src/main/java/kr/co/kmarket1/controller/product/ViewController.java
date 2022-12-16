package kr.co.kmarket1.controller.product;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket1.service.ProductService;
import kr.co.kmarket1.vo.ProductVO;

@WebServlet("/product/view.do")
public class ViewController extends HttpServlet{
	private ProductService service = ProductService.INSTANCE;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public void init() throws ServletException {
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String prodCate1 = req.getParameter("prodCate1");
		String prodCate2 = req.getParameter("prodCate2");
		String prodNo = req.getParameter("prodNo");
		String pg = req.getParameter("pg");
		
		req.setAttribute("prodCate1", prodCate1);
		req.setAttribute("prodCate2", prodCate2);
		req.setAttribute("prodNo", prodNo);
		req.setAttribute("pg", pg);
		
		ProductVO product = service.selectProduct(prodNo);
		req.setAttribute("product", product);
		
		// 현재 시간 구해서 배송일자 구하기
		LocalDate now = LocalDate.now();
		LocalDate deliveryDate = now.plusDays(3);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd");
        String formatedNow = deliveryDate.format(formatter);
        req.setAttribute("formatedNow", formatedNow);
        
        DayOfWeek dayOfWeek = deliveryDate.getDayOfWeek();
        /* 이게 왜 작동안하는지 모르겠다
        dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.KOREAN);
        */
        String koreanDOW = null;
        switch(dayOfWeek) {
        case SUNDAY:
        	koreanDOW = "일요일";
        	break;
        case MONDAY:
        	koreanDOW = "월";
        	break;
        case TUESDAY:
        	koreanDOW = "화";
        	break;
        case WEDNESDAY:
        	koreanDOW = "수";
        	break;
        case THURSDAY:
        	koreanDOW = "목";
        	break;
        case FRIDAY:
        	koreanDOW = "금";
        	break;
        case SATURDAY:
        	koreanDOW = "토";
        	break;
        }
        req.setAttribute("koreanDOW", koreanDOW);

        // 리뷰 들고오기
		List<ProductVO> comments = service.selectProductComments(prodNo);
        req.setAttribute("comments", comments);

		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/product/view.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/* ProductVO cart = service.insertProductCart(); */
		
	}
}
