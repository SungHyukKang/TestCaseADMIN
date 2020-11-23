package com.ksh.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ksh.jwt.service.ProblemService;

@Controller
public class ProblemController {
	@Autowired
	private ProblemService problemService;
	
	@GetMapping("/problem/problemList")
	public String index(Model model,@PageableDefault(size=10,sort="id",direction = Sort.Direction.DESC) Pageable pageable) {
		model.addAttribute("problems",problemService.problemList(pageable));
		return "problem/problemList"; 
	}
}
