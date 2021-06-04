package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Orderline;
import com.qa.ims.utils.DBUtils;

public class OrderlineDAO implements Dao<Orderline> {

	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public Orderline modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long order_items_id = resultSet.getLong("order_items_id");
		Long order_id = resultSet.getLong("order_id");

		Long item_id = resultSet.getLong("item_id");
		Long quantity = resultSet.getLong("quantity");
		Double cost = resultSet.getDouble("cost");
		return new Orderline(order_items_id, order_id, item_id, quantity, cost);
	}

	/**
	 * Reads all Orders from the database
	 * 
	 * @return A list of Orders
	 */
	@Override
	public List<Orderline> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orderlines");) {
			List<Orderline> orderlines = new ArrayList<>();
			while (resultSet.next()) {
				orderlines.add(modelFromResultSet(resultSet));
			}
			return orderlines;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Orderline readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("SELECT * FROM orderlines ORDER BY order_items_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates a Order in the database
	 * 
	 * @param Order - takes in a Order object. id will be ignored
	 */

	@Override
	public Orderline create(Orderline orderline) {

		try (Connection connection = DBUtils.getInstance().getConnection();

				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orderlines(order_id,item_id,quantity,cost) VALUES (?,?,?,?)");) {
			statement.setLong(1, orderline.getOrder_id());
			statement.setLong(2, orderline.getItem_id());
			statement.setLong(3, orderline.getQuantity());
			statement.setDouble(4, orderline.getCost());

			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Orderline read(Long order_items_id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("SELECT * FROM orderlines WHERE order_items_id = ?");) {
			statement.setLong(1, order_items_id);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Updates a Order in the database
	 * 
	 * @param Order - takes in a Order object, the id field will be used to update
	 *              that Order in the database
	 * @return
	 */
	@Override
	public Orderline update(Orderline orderline) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"UPDATE orderlines SET order_id=?,item_id = ?,quantity=?,cost=? WHERE order_items_id = ?");) {

			statement.setLong(1, orderline.getOrder_id());

			statement.setLong(2, orderline.getItem_id());
			statement.setLong(3, orderline.getQuantity());
			statement.setDouble(4, orderline.getCost());
			statement.setLong(5, orderline.getOrder_items_id());
			statement.executeUpdate();
			return read(orderline.getOrder_items_id());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Deletes a Order in the database
	 * 
	 * @param id - id of the Order
	 */
	@Override
	public int delete(long order_items_id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("DELETE FROM orderlines WHERE order_items_id = ?");) {
			statement.setLong(1, order_items_id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

}
