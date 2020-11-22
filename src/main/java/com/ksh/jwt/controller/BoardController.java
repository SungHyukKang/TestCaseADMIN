package com.ksh.jwt.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ksh.jwt.model.Board;
import com.ksh.jwt.repository.BoardRepository;
import com.ksh.jwt.service.BoardService;
import com.ksh.jwt.service.UserService;

@Controller
public class BoardController {
	//@AuthenticationPrincipal PrincipalDetail principal
	@Autowired
	private BoardService boardService;
	@Autowired
	private BoardRepository boardRepository;
	@GetMapping("/board/boardList")
	public String index(Model model,@PageableDefault(size=10,sort="id",direction = Sort.Direction.DESC) Pageable pageable) {
		model.addAttribute("boards",boardService.boardList(pageable));
		return "board/boardList"; //viewResolver 작동 !!!!!! model의 정보를 가지고 index로 이동
	}
	
	@GetMapping("boardDetail/{boardId}")
	public String userDetail(@PathVariable int boardId,Model model) {
		Board board = boardRepository.findById(boardId).orElseThrow(()->{
			return new IllegalArgumentException("게시글을 찾을 수 없습니다.");
		});
		model.addAttribute("board",board);
		return "board/detail"; 
	}
	
}
