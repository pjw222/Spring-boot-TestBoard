package com.kyungiljava4.jdbctest.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kyungiljava4.jdbctest.board.domain.Board;

@Repository
public class BoardDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private RowMapper<Board> mapper = new RowMapper<Board>() {
		@Override
		public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			return new Board(rs.getInt("id"), rs.getString("user"), rs.getString("title"), rs.getString("content"));
		}
	};

	public void add(Board board) {
		jdbcTemplate.update("insert into spring_boards (\"title\", \"user\", \"content\") values (?, ?, ?)",
				board.getTitle(), board.getUser(), board.getContent());
	}

	public Board get(int id) {
		return jdbcTemplate.queryForObject("select * from spring_boards where \"id\"=?", mapper, id);
	}

	public List<Board> getAll() {
		return jdbcTemplate.query("select * from spring_boards order by \"id\"", mapper);
	}
	public void update(Board board) {
	    jdbcTemplate.update("update spring_boards set \"title\"=?, \"user\"=?, \"content\"=? where \"id\"=?",
	            board.getTitle(), board.getUser(), board.getContent(), board.getId());
	}
	public void delete(int id) {
	    jdbcTemplate.update("delete from spring_boards where \"id\" = ?", id);
	}

}