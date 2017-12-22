package com.sarnath;

public class OrderService implements IOrderService {

	@Override
	public String queryOrder() {
		return "orderA";
	}

	@Override
	public void createOrder() {
		System.out.println("create order successfully");
	}

	@Override
	public void modifyOrder() {
		System.out.println("modify order successfully");
	}

	@Override
	public void deleteOrder() {
		System.out.println("delete order successfully");
	}

}
