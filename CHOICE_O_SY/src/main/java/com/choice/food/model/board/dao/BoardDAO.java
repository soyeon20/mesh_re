package com.choice.food.model.board.dao;

import java.util.List;

import com.choice.food.model.board.dto.BoardVO;

public interface BoardDAO {
	// 01. 게시글 작성
	public void create(BoardVO vo) throws Exception;
	// 02. 게시글 상세보기
	public BoardVO read(int bno) throws Exception;
	// 03. 게시글 수정
	public void update(BoardVO vo) throws Exception;
	// 04. 게시글 삭제
	public void delete(int bno) throws Exception;
	// 05. 게시글 전체 목록 ==> 검색옵션, 키워드 매개변수 추가
	
	public List<BoardVO> listAll(int start, int end, String searchOption, String keyword) throws Exception;

	/*public List<BoardVO> listAll(String searchOption, String keyword) throws Exception;
*/	// 06. 게시글 조회 증가
	public void increaseViewcnt(int bno) throws Exception;
	
	public int countArticle() throws Exception;
	

}