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
	//게시글 추가메서드
	public void add(Board board) {
		boardDAO.add(board);
	}
	//특정 게시글 불러오기
	public Board get(int id) {
		Board board = boardDAO.get(id);
		return board;
	}
	//게시글 목록 다불러오기
	public List<Board> getAll() {
		List<Board> list = boardDAO.getAll();
		return list;
	}
	//수정하기
	public void updateBoard(Board board) {
		boardDAO.update(board);
	}
	//삭제하기
	public void delete(int id) {
		boardDAO.delete(id);
	}
	//페이징기능
    public List<Board> getBoardsInRange(int currentPage, int itemsPerPage) {
        return boardDAO.getBoardInRange(currentPage, itemsPerPage);
    }
    //게시글 총갯수
    public int getTotalBoards() {
        return boardDAO.getTotalBoardCount();
    }

}