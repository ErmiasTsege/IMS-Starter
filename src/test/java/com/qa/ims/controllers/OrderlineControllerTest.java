package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderlineController;
import com.qa.ims.persistence.dao.OrderlineDAO;
import com.qa.ims.persistence.domain.Orderline;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderlineControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private OrderlineDAO dao;

	@InjectMocks
	private OrderlineController controller;

//	@Test
//	public void testCreate() {
//		final Long ORDER_ID = 1L, ITEM_ID = 3L, QUANTITY = 15L;
//		final Double COST = 70.0;
//		final Orderline created = new Orderline(ORDER_ID, ITEM_ID, QUANTITY, COST);
//
//		Mockito.when(utils.getLong()).thenReturn(ORDER_ID, ITEM_ID, QUANTITY);
//		Mockito.when(utils.getDouble()).thenReturn(COST);
//		Mockito.when(dao.create(created)).thenReturn(created);
//
//		assertEquals(created, this.controller.create());
//
//		Mockito.verify(utils, Mockito.times(3)).getLong();
//		Mockito.verify(utils, Mockito.times(1)).getDouble();
//		Mockito.verify(dao, Mockito.times(1)).create(created);
//	}

	@Test
	public void testReadAll() {
		List<Orderline> orderlines = new ArrayList<>();
		orderlines.add(new Orderline(1L, 1L, 1L, 5L, 90.0));

		Mockito.when(dao.readAll()).thenReturn(orderlines);

		assertEquals(orderlines, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}
//
//	@Test
//	public void testUpdate() {
//		Orderline updated = new Orderline(1L, 1L, 1L, 5L, 90.0);
//
//		Mockito.when(this.utils.getLong()).thenReturn(1L);
//		Mockito.when(this.utils.getLong()).thenReturn(updated.getOrder_items_id(), updated.getOrder_id(),
//				updated.getItem_id(), updated.getQuantity());
//		Mockito.when(this.utils.getDouble()).thenReturn(updated.getCost());
//		Mockito.when(this.dao.update(Mockito.any(Orderline.class))).thenReturn(updated);
//
//		assertEquals(updated, this.controller.update());
//
//		Mockito.verify(this.utils, Mockito.times(4)).getLong();
//		Mockito.verify(this.utils, Mockito.times(1)).getDouble();
//		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
//	}

	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}

}
