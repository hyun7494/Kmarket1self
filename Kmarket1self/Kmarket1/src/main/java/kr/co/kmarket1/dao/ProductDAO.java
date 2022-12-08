package kr.co.kmarket1.dao;

import kr.co.kmarket1.db.DBHelper;

public class ProductDAO extends DBHelper{
	private static ProductDAO instance = new ProductDAO();
	public static ProductDAO getInstance() {
		return instance;
	}
	private ProductDAO() {}
	
	
}
