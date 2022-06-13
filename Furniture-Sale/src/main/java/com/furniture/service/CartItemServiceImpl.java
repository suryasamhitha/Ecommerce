package com.furniture.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.furniture.bean.CartItem;
import com.furniture.exception.CartNotFoundException;
import com.furniture.exception.EmptyOrderException;
import com.furniture.repository.CartItemRepository;

@Service
@Transactional
public class CartItemServiceImpl implements ICartItemService {

	@Autowired
	private CartItemRepository cartRepository;

	Logger logger = LoggerFactory.getLogger(CartItemServiceImpl.class);

	@Override
	public CartItem addCart(CartItem cart) {
		logger.info("Cart addCart()");

		if (cart == null)
			throw new CartNotFoundException("Cart Not Found");
		else {
			cartRepository.save(cart);
			return cart;
		}

	}

	@Override
	public CartItem removeCart(int cartId) {
		logger.info("Cart removeCart()");
		CartItem cart = cartRepository.findById(cartId).get();
		if (cart == null)
			throw new CartNotFoundException("Cart Not Found");
		else {
			cartRepository.delete(cart);
			return cart;
		}
	}

	@Override
	public List<CartItem> viewAllOrderHistory() {
		logger.info("viewAllBookingHistory method of ProductBookingServiceImpl called", System.currentTimeMillis());

		if (cartRepository.findAll().isEmpty()) {
			throw new EmptyOrderException("No booking history found");
		}
		return cartRepository.findAll();
	}

	@Override
	public CartItem viewCustomer(long loginId) {
		logger.info("Cart viewCustomer()");
		CartItem cart = cartRepository.viewCartByCustomerId(loginId);
		if (cart == null)
			throw new CartNotFoundException("Cart Not Found");
		else
			return cart;
	}
}
