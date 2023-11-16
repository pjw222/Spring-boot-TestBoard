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
	//게시글 추가 쿼리문
	public void add(Board board) {
		jdbcTemplate.update("insert into spring_boards (\"title\", \"user\", \"content\") values (?, ?, ?)",
				board.getTitle(), board.getUser(), board.getContent());
	}
	//특정 게시글 불러오는 쿼리문
	public Board get(int id) {
		return jdbcTemplate.queryForObject("select * from spring_boards where \"id\"=?", mapper, id);
	}
	//게시글 목록 불러오는 쿼리문
	public List<Board> getAll() {
		return jdbcTemplate.query("select * from spring_boards order by \"id\"", mapper);
	}
	//게시글 수정 쿼리문
	public void update(Board board) {
	    jdbcTemplate.update("update spring_boards set \"title\"=?, \"user\"=?, \"content\"=? where \"id\"=?",
	            board.getTitle(), board.getUser(), board.getContent(), board.getId());
	}
	//게시글 삭제 쿼리문
	public void delete(int id) {
	    jdbcTemplate.update("delete from spring_boards where \"id\" = ?", id);
	}
	//게시글 레코드의 총갯수를 파악하는 쿼리문
    public int getTotalBoardCount() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM spring_boards", Integer.class);
    }
    //페이징기능위한 쿼리문
    public List<Board> getBoardInRange(int currentPage, int itemsPerPage) {
        int offset = (currentPage - 1) * itemsPerPage;
        return jdbcTemplate.query(
            "SELECT * FROM (SELECT n.*, ROWNUM rnum FROM (SELECT * FROM spring_boards ORDER BY \"id\" DESC) n) WHERE rnum BETWEEN ? AND ?",
            new Object[] { offset + 1, offset + itemsPerPage },
            mapper
        );
    }

}