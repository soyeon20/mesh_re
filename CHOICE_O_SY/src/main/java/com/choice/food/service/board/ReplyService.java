package com.choice.food.service.board;

import java.util.List;

import com.choice.food.model.board.dto.ReplyVO;

public interface ReplyService {
	 // 댓글 목록
    public List<ReplyVO> list(Integer bno);
    // 댓글 입력
    public void create(ReplyVO vo);
    // 댓글 수정
    public void update(ReplyVO vo);
    // 댓글 삭제
    public void delete(Integer rno);
   /* //댓글 상세
    public void detail(Integer rno);    */
    

}
