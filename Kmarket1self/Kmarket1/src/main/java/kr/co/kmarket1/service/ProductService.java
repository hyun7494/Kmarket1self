package kr.co.kmarket1.service;

import kr.co.kmarket1.dao.ProductDAO;

public enum ProductService {
	
	INSTANCE;
	
	private ProductDAO dao = ProductDAO.getInstance();
	
	public int selectCountTotal(String prodCate2) {
		return dao.selectCountTotal(prodCate2);
	}
	
	public void getLastPageNum(total) {
		return;
	}
	
	public void getPageGroupNum(currentPage, lastPageNum) {
		return;
	}
	


}
