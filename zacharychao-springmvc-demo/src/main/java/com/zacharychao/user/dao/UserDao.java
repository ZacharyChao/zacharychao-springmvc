package com.zacharychao.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.zacharychao.user.entity.User;

@Repository
public class UserDao {
	@Autowired 
	private JdbcTemplate jdbcTemplate;
	
	public void register(User user) {
		String sql = "insert into user(username,password) values (?,?)";
		jdbcTemplate.update(sql, user.getUsername() , user.getPassword());
	}
	
	public User findByUsername(String username) {
		User user = new User();
		String sql = "select id,username,password from user where username = ?";
		jdbcTemplate.query(sql, new Object[] {username}, new RowCallbackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setId(Integer.valueOf(rs.getString("id")));
			}
			
		});
		return user;
	}
}
