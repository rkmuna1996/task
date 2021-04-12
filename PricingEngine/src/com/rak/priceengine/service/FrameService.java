/**
 * 
 */
package com.rak.priceengine.service;

import com.rak.priceengine.dao.FrameDAO;
import com.rak.priceengine.model.Frame;

/**
 * @author Rakesh
 *
 */
public class FrameService {

	private Long date = null;

	private Frame frame = null;

	private FrameDAO frameDAO = null;

	public FrameService(Long date, Frame wheel) {
		this.date = date;
		this.frame = wheel;
		frameDAO = new FrameDAO();
	}

	public double getPrice() {
		return frame.getPrice();
	}

	public void calculatePrice() {
		double spokePrice = frameDAO.getFramePrice(frame.getType(), date);
		double totalPrice = spokePrice;
		frame.setPrice(totalPrice);
	}

}
