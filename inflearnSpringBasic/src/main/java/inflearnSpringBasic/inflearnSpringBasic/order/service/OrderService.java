package inflearnSpringBasic.inflearnSpringBasic.order.service;

import inflearnSpringBasic.inflearnSpringBasic.order.object.Order;

public interface OrderService {
	
	Order createOrder(Long memberId, String itemName, int itemPrice);
	
}
