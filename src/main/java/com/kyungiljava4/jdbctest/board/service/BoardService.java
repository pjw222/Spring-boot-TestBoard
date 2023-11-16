package com.kyungiljava4.jdbctest.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyungiljava4.jdbctest.board.dao.BoardDAO;
import com.kyungiljava4.jdbctest.board.domain.Board;

@Service
public class BoardService {
	@Autowired
	BoardDAO boardDAO;

	public void add(Board board) {
		boardDAO.add(board);
	}

	public Board get(int id) {
		Board board = boardDAO.get(id);
		return board;
	}

	public List<Board> getAll() {
		List<Board> list = boardDAO.getAll();
		return list;
	}

	public void updateBoard(Board board) {
		boardDAO.update(board);
	}

	public void delete(int id) {
		boardDAO.delete(id);
	}

}