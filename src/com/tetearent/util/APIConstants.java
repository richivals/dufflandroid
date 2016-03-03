package com.tetearent.util;

public class APIConstants {

//	public static final String BASE_URL = "http://testspurr.com/tar/";
	public static final String BASE_URL = "http://thefashionrental.com/";
	public static final String API_PATH = "";
	private static final String API_NAME_RAW = "magento_api_new.php";
	private static final String API_NAME = "magento_api_new.php?&___store=EN&cur_code=INR&task=";
	
	public static final String GET_PRODUCT_API = BASE_URL + API_PATH + API_NAME + "getProducts";
	
	public static final String GET_PRODUCT_DETAIL_API = BASE_URL + API_PATH + API_NAME + "getProductdetail&product_id=";
	
	public static final String GET_WISHLIST_API = BASE_URL + API_PATH + API_NAME + "getWishlistProducts&pids=";
	
	public static final String ONLY_API = BASE_URL + API_PATH + API_NAME_RAW;
	
	public static final String GET_PROFILE_API = BASE_URL + API_PATH + API_NAME + "get_profile";
}
