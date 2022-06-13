package com.furniture.service;


import java.util.List;

import com.furniture.bean.CartItem;

public interface ICartItemService  {
		
		
	public CartItem addCart(CartItem cart);
			
	public CartItem removeCart(int cartId);

	public CartItem viewCustomer(long loginId);
	
	public List<CartItem> viewAllOrderHistory();

	}
