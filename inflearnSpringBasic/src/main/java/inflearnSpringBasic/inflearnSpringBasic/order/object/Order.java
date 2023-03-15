package inflearnSpringBasic.inflearnSpringBasic.order.object;

public class Order {
	// 회원 ID
	private Long memberId;
	// 상품 명
	private String itemName;
	// 상품 가격
	private int itemPrice;
	// 할인 가격
	private int discountPrice;
	
	public Order(Long memberId, String itemName, int itemPrice, int discountPrice) {
		this.memberId = memberId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.discountPrice = discountPrice;
	}
	
	/**
	 * 할인 후 금액을 리턴한다.
	 * @return 상품가격 - 할인가격
	 */
	public int calculatePrice() {
		return this.itemPrice - this.discountPrice;
	}
	
	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}

	@Override
	public String toString() {
		return "Order [memberId=" + memberId + ", itemName=" + itemName + ", itemPrice=" + itemPrice
				+ ", discountPrice=" + discountPrice + " calculatePrice="+calculatePrice()+"]";
	}
	
	
	
}
