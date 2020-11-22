package com.ksh.jwt.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ksh.jwt.dto.common.ResponseDto;
import com.ksh.jwt.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BoardApiController {
	private final BoardService boardService;

	@PostMapping("/board/delete/{boardId}")
	public ResponseDto<String> deleteBoard(@PathVariable int boardId){
		boardService.deleteBoard(boardId);
		return new ResponseDto<String>(HttpStatus.OK.value(),"1");
	}
}
