package com.choice.food.service.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.choice.food.model.board.dao.ReplyDAO;
import com.choice.food.model.board.dto.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {

	   @Inject
	    ReplyDAO replyDao;
	    
	    // 댓글 목록
	    @Override
	    public List<ReplyVO> list(Integer bno) {
	        return replyDao.list(bno);
	    }
	    // 댓글 작성
	    @Override
	    public void create(ReplyVO vo) {
	        replyDao.create(vo);
	    }
	    // 댓글 수정
	    @Override
	    public void update(ReplyVO vo) {
	    	replyDao.update(vo);
	 
	    }
	    // 댓글 삭제
	    @Override
	    public void delete(Integer rno) {
	    	replyDao.delete(rno);
	    }
}
