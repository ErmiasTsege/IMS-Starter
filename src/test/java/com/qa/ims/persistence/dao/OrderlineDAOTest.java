
package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


import com.qa.ims.persistence.domain.Orderline;
import com.qa.ims.utils.DBUtils;

public class OrderlineDAOTest {

	private final OrderlineDAO DAO = new OrderlineDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Orderline created = new Orderline(1L,2L,10L,30.00);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Orderline> expected = new ArrayList<>();
		expected.add(new Orderline(1L,1L,5L,90.0));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Orderline(1L,1L,5L,90.0), DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Orderline(1L,1L,5L,90.0), DAO.read(ID));
	}

	@Test
	public void testUpdate() {
		final Orderline updated = new Orderline(1L,1L,1L,5L,90.0);
		assertEquals(updated, DAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}

}
