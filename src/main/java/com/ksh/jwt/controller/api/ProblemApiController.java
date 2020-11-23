package com.ksh.jwt.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ksh.jwt.dto.common.ResponseDto;
import com.ksh.jwt.service.ProblemService;

@RestController
public class ProblemApiController {

	@Autowired
	private ProblemService problemService;
	
	
	@PostMapping("/deleteProblem/{problemId}")
	public ResponseDto<String> deleteProblem(@PathVariable int problemId){
		problemService.delete(problemId);
		
		return new ResponseDto<String>(HttpStatus.OK.value(),"1");
	}
	
}

