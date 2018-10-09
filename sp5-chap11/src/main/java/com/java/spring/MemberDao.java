package com.java.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class MemberDao {
	
	
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	public Member selectByEmail(String email) {
		List<Member> results = jdbcTemplate.query("select * from member where email = ?", new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member(
						rs.getString("email"),
						rs.getString("password"),
						rs.getString("name"),
						rs.getTimestamp("regdate").toLocalDateTime());
				member.setId(rs.getLong("id"));
				return member;
				}
		}, 
		email);
		
		return results.isEmpty() ? null : results.get(0);
	}
	
	
	public void insert(Member member) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement pstmt = con.prepareStatement("insert into member (email, password, name, regdate"+"values(?,?,?,?)", new String[] {"id"});
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				pstmt.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));
				
				
				return pstmt;
			}
			
		}, keyHolder);
		Number keyValue = keyHolder.getKey();
		member.setId(keyValue.longValue());
	}
	
	public void update(Member member) {
		
		jdbcTemplate.update("update member set name = ?, password = ? where email = ?", member.getName(), member.getPassword(), member.getEmail());
	}
	public List<Member> selectAll() {
		
		List<Member> results = jdbcTemplate.query("select * from member", new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Member member = new Member(
						rs.getString("email"),
						rs.getString("password"),
						rs.getString("name"),
						rs.getTimestamp("regdate").toLocalDateTime());
				member.setId(rs.getLong("id"));
				return member;
			}
		});
				
				return results;
			}
	public int count() {
		Integer count = jdbcTemplate.queryForObject("select count(*) from member", Integer.class);
		
		return count;
	}

}
