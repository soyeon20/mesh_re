package com.choice.food.service.board;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.choice.food.model.board.dao.BoardDAO;
import com.choice.food.model.board.dto.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	BoardDAO boardDao;

	@Override
	public void create(BoardVO vo) throws Exception {
		String title = vo.getTitle();
		String content = vo.getContent();
		String writer = vo.getWriter();
		Date regdate = vo.getRegdate();
		
		title = title.replace("<", "&lt");
		title = title.replace("<", "&lt");
		writer = writer.replace("<", "&lt;");
		writer = writer.replace(">", "&gt;");
		
		content = content.replace("\n", "<br>");
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		vo.setRegdate(regdate);
		// 게시물 등록
		boardDao.create(vo);
		
		 return; 
	}

	@Override
	public BoardVO read(int bno) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.read(bno);
	}

	@Transactional
	@Override
	public void update(BoardVO vo) throws Exception {
		boardDao.update(vo);
	}

	@Override
	public void delete(int bno) throws Exception {
		boardDao.delete(bno);
	}

	/*@Override
	public List<BoardVO> listAll(String searchOption, String keyword) throws Exception {
		return boardDao.listAll(searchOption, keyword);
	}
*/
	@Override
	public void increaseViewcnt(int bno, HttpSession session) throws Exception {
		long update_time = 0;
		if(session.getAttribute("update_time_"+bno) != null) {
			update_time = (long) session.getAttribute("update_time_"+bno);
		}
		
		long current_time = System.currentTimeMillis();
		
		if(current_time - update_time > 5*1000) {
			boardDao.increaseViewcnt(bno);
			session.setAttribute("updaet_time_"+bno,  current_time);
		}
	}
	
	// 05. 게시글 전체 목록
	@Override
	public List<BoardVO> listAll(int start, int end, String searchOption, String keyword) throws Exception {
	    return boardDao.listAll(start, end, searchOption, keyword);
	}
	
	@Override
	public int countArticle() throws Exception{
		return boardDao.countArticle();
	}	

}
