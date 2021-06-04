package com.qa.ims.persistence.domain;

public class Orderline {

	private Long order_items_id;
	private Long order_id;
	private Long item_id;
	private Long quantity;
	private Double cost;

	public Orderline(Long order_items_id, Long order_id, Long item_id, Long quantity, Double cost) {

		this.setOrder_items_id(order_items_id);
		this.setOrder_id(order_id);
		this.setItem_id(item_id);
		this.setQuantity(quantity);
		this.setCost(cost);
	}

	public Orderline(Long order_id, Long item_id, Long quantity, Double cost) {

		this.setOrder_id(order_id);
		this.setItem_id(item_id);
		this.setQuantity(quantity);
		this.setCost(cost);
	}

	public Orderline(Long quantity, Double cost) {

		this.setQuantity(quantity);
		this.setCost(cost);
	}

	public Long getOrder_items_id() {
		return order_items_id;

	}

	public void setOrder_items_id(Long order_items_id) {
		this.order_items_id = order_items_id;
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public Long getItem_id() {
		return item_id;
	}

	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Orderline [order_items_id=" + order_items_id + ", order_id=" + order_id + ", item_id=" + item_id
				+ ", quantity=" + quantity + ", cost=" + cost + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((item_id == null) ? 0 : item_id.hashCode());
		result = prime * result + ((order_id == null) ? 0 : order_id.hashCode());
		result = prime * result + ((order_items_id == null) ? 0 : order_items_id.hashCode());
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
		Orderline other = (Orderline) obj;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
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
		if (order_items_id == null) {
			if (other.order_items_id != null)
				return false;
		} else if (!order_items_id.equals(other.order_items_id))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}

}
