package com.qa.ims.persistence.domain;

public class Order {

	private Long order_id;
	private Long customer_id;
	private Long item_id;
	private Long quantity;
	private Double cost;

	public Double getCost() {
		return cost;
	}

	public Order(Long customer_id, Long item_id, Long quantity, Double cost) {

		this.setOrder_id(order_id);
		this.setCustomer_id(customer_id);
		this.setItem_id(item_id);
		this.setQuantity(quantity);
		this.setCost(cost);
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Order(Long customer_id, Long item_id, Long quantity) {

		this.setCustomer_id(customer_id);
		this.setItem_id(item_id);
		this.setQuantity(quantity);

	}

	public Order(Long order_id, Long customer_id, Long item_id, Long quantity) {
		this.setOrder_id(order_id);
		this.setCustomer_id(customer_id);
		this.setItem_id(item_id);
		this.setQuantity(quantity);
	}

	public Long getOrder_id() {
		return order_id;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	public Long getItem_id() {
		return item_id;
	}

	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", customer_id=" + customer_id + ", item_id=" + item_id + ", quantity="
				+ quantity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer_id == null) ? 0 : customer_id.hashCode());
		result = prime * result + ((item_id == null) ? 0 : item_id.hashCode());
		result = prime * result + ((order_id == null) ? 0 : order_id.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (customer_id == null) {
			if (other.customer_id != null)
				return false;
		} else if (!customer_id.equals(other.customer_id))
			return false;
		if (item_id == null) {
			if (other.item_id != null)
				return false;
		} else if (!item_id.equals(other.item_id))
			return false;
		if (order_id == null) {
			if (other.order_id != null)
				return false;
		} else if (!order_id.equals(other.order_id))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}

}
