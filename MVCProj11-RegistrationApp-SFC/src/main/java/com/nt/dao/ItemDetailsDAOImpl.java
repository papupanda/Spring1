package com.nt.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.nt.bo.ItemDetailsBO;


public class ItemDetailsDAOImpl implements ItemDetailsDAO {
    private static final String INSERT_ITEM_QUERY="INSERT INTO MENUITEM VALUES(ITEMID_SEQ.NEXTVAL,?,?,?,?,?)";	
	private JdbcTemplate jt;

	public ItemDetailsDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public int insert(ItemDetailsBO bo) {
		int count=0;
		count=jt.update(INSERT_ITEM_QUERY,bo.getItemName(),bo.getCategory(),bo.getPrice(),bo.getStatus(),bo.getRestaurant());
		return count;
	}

}
