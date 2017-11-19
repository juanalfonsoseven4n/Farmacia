package com.farmacia.persistence.sqlmapdao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import com.ibatis.common.util.PaginatedList;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.ibatis.sqlmap.client.SqlMapTransactionManager;
import com.ibatis.sqlmap.client.event.RowHandler;
import com.ibatis.sqlmap.engine.execution.BatchException;

public class DAO extends SqlMapDaoTemplate{
	
	protected final String PAGE_SIZE = ResourceBundle.getBundle("com.farmacia.persistence.resources.database").getString("numberregister");


	public List queryForList(String s, int i, int i1) throws SQLException {
		return null;
	}

	public void queryWithRowHandler(String s, RowHandler rowHandler) throws SQLException {

	}

	public Object insert(String s) throws SQLException {
		return null;
	}

	public int update(String s) throws SQLException {
		return 0;
	}

	public int delete(String s) throws SQLException {
		return 0;
	}

	public Object queryForObject(String s) throws SQLException {
		return null;
	}

	public List queryForList(String s) throws SQLException {
		return null;
	}

	public PaginatedList queryForPaginatedList(String s, int i) throws SQLException {
		return null;
	}

	public List executeBatchDetailed() throws SQLException, BatchException {
		return null;
	}

	protected Long getNext(HashMap datosseq){
		//System.out.println("datosseq: " +datosseq);
		Long id = (Long)queryForObject("getNext", datosseq);
		if(id==null){
			id = new Long(1);
		}
		//System.out.println("id  "+id);
		return id;
	}
	public DAO(com.ibatis.dao.client.DaoManager daoManager) {
		super(daoManager);
	}
}
