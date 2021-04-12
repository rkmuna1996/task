/**
 * 
 */
package com.rak.priceengine.service;

import com.rak.priceengine.dao.HandleDAO;
import com.rak.priceengine.model.Handle;

/**
 * @author Rakesh
 *
 */
public class HandleService {

	private Long date = null;

	private Handle handle = null;

	private HandleDAO handleDAO = null;

	public HandleService(Long date, Handle handle) {
		this.date = date;
		this.handle = handle;
		handleDAO = new HandleDAO();
	}

	public double getPrice() {
		return handle.getPrice();
	}

	public void calculatePrice() {
		double spokePrice = handleDAO.getHandlePrice(handle.getType(), date);

		double shockLockPrice = handleDAO.getShocklockPrice(handle.isShockLock(), date);
		double totalPrice = spokePrice + shockLockPrice;
		handle.setPrice(totalPrice);
	}

}
