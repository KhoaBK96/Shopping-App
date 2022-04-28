package com.bia.web.service;

import java.sql.SQLException;
import java.util.List;

import com.bia.web.dto.ShopDTO;
import com.bia.web.model.Page;

public interface IPaginationService {
	
	public List<Page> pagination(ShopDTO shopDto, int productPerPage) throws SQLException;
}
