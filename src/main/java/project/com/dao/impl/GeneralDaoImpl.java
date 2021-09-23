package project.com.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import project.com.dao.GeneralDao;

@Repository
public class GeneralDaoImpl<T> implements GeneralDao<T> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<T> getAll(String sql, RowMapper<T> rowMapper) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public List<T> findByProperty(String sql, RowMapper<T> rowMapper, Object...objects) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(sql, rowMapper, objects);
	}

	@Override
	public boolean save(String sql, Object...objects) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(sql, objects) > 0;
	}

	@Override
	public T update(String sql, PreparedStatementCallback<T> callback) {
		// TODO Auto-generated method stub
		return jdbcTemplate.execute(sql, callback);
	}

	@Override
	public boolean delete(String sql, int id) {
		// TODO Auto-generated method stub
		
		return jdbcTemplate.update(sql, id) > 0;
	}
	
}
