package com.qa.ims.controller;

import java.util.List;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

/**
 * Takes in Item details for CRUD functionality
 *
 */
public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	/**
	 * Reads all Items to the logger
	 */
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	/**
	 * Creates a Order by taking in user input
	 */
	@Override
	public Order create() {
		LOGGER.info("Please enter a Customer id");
		Long customer_id = utils.getLong();
		LOGGER.info("Please enter item id");
		Long item_id = utils.getLong();
		LOGGER.info("Please enter quantity");
		Long quantity = utils.getLong();
		Order order = orderDAO.create(new Order(customer_id, item_id, quantity));
		LOGGER.info("Order created");
		return order;
	}

	/**
	 * Updates an existing Order by taking in user input
	 */
	@Override
	public Order update() {
		LOGGER.info("Please enter the id of the Order you would like to update");
		Long order_id = utils.getLong();
		LOGGER.info("Please enter a customer_id");
		Long customer_id = utils.getLong();
		LOGGER.info("Please enter a item_id");
		Long item_id = utils.getLong();
		LOGGER.info("Please enter a quantity");
		Long quantity = utils.getLong();
		Order order = orderDAO.update(new Order(order_id, customer_id, item_id, quantity));
		LOGGER.info("Order Updated");
		return order;
	}

	/**
	 * Deletes an existing Order by the id of the Order
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the Order you would like to delete");
		Long order_id = utils.getLong();
		LOGGER.info("Order Deleted");
		return orderDAO.delete(order_id);

	}

}
