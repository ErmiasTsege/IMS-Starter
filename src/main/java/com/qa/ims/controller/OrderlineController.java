
package com.qa.ims.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderlineDAO;
import com.qa.ims.persistence.domain.Orderline;
import com.qa.ims.utils.DBUtils;
import com.qa.ims.utils.Utils;

/**
 * Takes in Item details for CRUD functionality
 *
 */
public class OrderlineController implements CrudController<Orderline> {
	public static final Logger LOGGER = LogManager.getLogger();
	private OrderlineDAO orderlineDAO;
	private Utils utils;

	public OrderlineController(OrderlineDAO orderlineDAO, Utils utils) {
		super();
		this.orderlineDAO = orderlineDAO;
		this.utils = utils;
	}

	/**
	 * Reads all Items to the logger
	 * 
	 */
//Method to calculate total cost

	public Double calculateCost(Long itemid) {

		Double getPrice = 0.0;
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * from items");) {
			while (resultSet.next()) {

				if (itemid == resultSet.getLong("item_id")) {
					getPrice = resultSet.getDouble("price");
				}
			}
			return getPrice;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());

		}
		return getPrice;

	}

	@Override
	public List<Orderline> readAll() {
		List<Orderline> orderlines = orderlineDAO.readAll();
		for (Orderline orderline : orderlines) {
			LOGGER.info(orderline);
		}
		return orderlines;
	}

	/**
	 * Creates a Order by taking in user input
	 */
	@Override
	public Orderline create() {
		LOGGER.info("Please enter a order id");
		Long order_id = utils.getLong();
		LOGGER.info("Please enter item id");
		Long item_id = utils.getLong();
		LOGGER.info("Please enter quantity");
		Long quantity = utils.getLong();
		Double cost = calculateCost(item_id) * quantity;
		Orderline orderline = orderlineDAO.create(new Orderline(order_id, item_id, quantity, cost));
		LOGGER.info("Orderline is created");
		return orderline;
	}

	/**
	 * Updates an existing Order by taking in user input
	 */
	@Override
	public Orderline update() {
		LOGGER.info("Please enter the id of the Order you would like to update");
		Long order_items_id = utils.getLong();
		LOGGER.info("Please enter order id");
		Long order_id = utils.getLong();
		LOGGER.info("Please enter a item id");
		Long item_id = utils.getLong();
		LOGGER.info("Please enter a quantity");
		Long quantity = utils.getLong();
		Double cost = calculateCost(item_id) * quantity;
		Orderline orderline = orderlineDAO.update(new Orderline(order_items_id, order_id, item_id, quantity, cost));
		LOGGER.info("Orderline Updated");
		return orderline;
	}

	/**
	 * Deletes an existing Order by the id of the Order
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the Orderline you would like to delete");
		Long order_items_id = utils.getLong();
		LOGGER.info("Order Deleted");
		return orderlineDAO.delete(order_items_id);

	}

}
