package com.app.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.bean.Item;

public class InsertItemAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {

		Item item = new Item();
		item.setItemName(req.getParameter("itemName"));
		item.setPrice(Double.parseDouble(req.getParameter("price")));
		item.setDescription(req.getParameter("description"));
		
		// database code
		
		return "successd";
	}

}
