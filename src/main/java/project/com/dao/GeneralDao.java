package project.com.dao;

import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;

public interface GeneralDao<T>{
	List<T> getAll(String sql, RowMapper<T> rowMapper);
	List<T> findByProperty(String sql, RowMapper<T> rowMapper, Object...objects);
	boolean save(String sql, Object...objects);
	T update(String sql, PreparedStatementCallback<T> callback);
	boolean delete(String sql, int id);
}
