package com.choice.food.controller.board;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.choice.food.model.board.dto.ReplyVO;
import com.choice.food.service.board.ReplyService;

@RestController
@RequestMapping("/reply/*")
public class ReplyController {
	@Inject
	ReplyService replyService;
	
	@RequestMapping("insert.do")
	public void insert(@ModelAttribute ReplyVO vo, HttpSession session){
		String userId = (String) session.getAttribute("userId");
		vo.setReplyer(userId);
		replyService.create(vo);
	}
	
	@RequestMapping("insertRest.do")
	public ResponseEntity<String> insertRest(@RequestBody ReplyVO vo, HttpSession session){
		ResponseEntity<String> entity = null;
		
		String userId = (String) session.getAttribute("userId");
		vo.setReplyer(userId);
		replyService.create(vo);
		entity = new ResponseEntity<String>("success", HttpStatus.OK);
		
		return entity;
	}
	
	
	@RequestMapping("list.do")
	public ModelAndView list(@RequestParam int bno, ModelAndView mav) {
		List<ReplyVO> list = replyService.list(bno);
		mav.setViewName("board/replyList");
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping("listJson.do")
	@ResponseBody
	public List<ReplyVO> listJson(@RequestParam int bno){
		List<ReplyVO> list = replyService.list(bno);
		return list;
	}
	
	@RequestMapping(value="/list/{bno}/{curPage}", method=RequestMethod.GET)
    public ModelAndView replyList(@PathVariable("bno") int bno, @PathVariable int curPage, ModelAndView mav, HttpSession session){
       /* // 페이징 처리
        int count = replyService.count(bno); // 댓글 갯수
        ReplyPager replyPager = new ReplyPager(count, curPage);
        // 현재 페이지의 페이징 시작 번호
        int start = replyPager.getPageBegin();
        // 현재 페이지의 페이징  끝 번호
        int end = replyPager.getPageEnd();
        List<ReplyVO> list = replyService.list(bno, start, end, session);
        // 뷰이름 지정
        mav.setViewName("board/replyList");
        // 뷰에 전달할 데이터 지정
        mav.addObject("list", list);
        mav.addObject("replyPager", replyPager);
        // replyList.jsp로 포워딩
*/        return mav;
    }
    
    // 3. 댓글 상세 보기
    // /reply/detail/1 => 1번 댓글의 상세화면 리턴
    // /reply/detail/2 => 2번 댓글의 상세화면 리턴
    // @PathVariable : url에 입력될 변수값 지정
    /*@RequestMapping(value="/detail/{rno}", method=RequestMethod.GET)
    public ModelAndView replyDetail(@PathVariable("rno") Integer rno, ModelAndView mav){
        ReplyVO vo = replyService.detail(rno);
        // 뷰이름 지정
        mav.setViewName("board/replyDetail");
        // 뷰에 전달할 데이터 지정
        mav.addObject("vo", vo);
        // replyDetail.jsp로 포워딩
        return mav;
    }*/
	
	@RequestMapping(value="update/{rno}", method= {RequestMethod.PUT, RequestMethod.PATCH})
	public ResponseEntity<String> replyUpdate(@PathVariable("rno") Integer rno, @RequestBody ReplyVO vo){
		ResponseEntity<String> entity = null;		
		try {
			vo.setRno(rno);
			replyService.update(vo);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}	
		return entity;
	}
	
	@RequestMapping(value="/delete/{rno}")
    public ResponseEntity<String> replyDelete(@PathVariable("rno") Integer rno){
        ResponseEntity<String> entity = null;
        try {
            replyService.delete(rno);
            // 댓글 삭제가 성공하면 성공 상태메시지 저장
            entity = new ResponseEntity<String>("success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            // 댓글 삭제가 실패하면 실패 상태메시지 저장
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        // 삭제 처리 HTTP 상태 메시지 리턴
        return entity;
    }

}
