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
import com.ksh.jwt.service.UserService;

@Controller
public class UserController {
	//@AuthenticationPrincipal PrincipalDetail principal
	@Autowired
	private UserService userService;
	
	@Autowired
	private BoardRepository boardRepository;
	
	
	@GetMapping({"","/","/admin"})
	public String index(Model model,@PageableDefault(size=10,sort="id",direction = Sort.Direction.DESC) Pageable pageable) {
		model.addAttribute("users",userService.userList(pageable));
		return "admin"; //viewResolver 작동 !!!!!! model의 정보를 가지고 index로 이동
	}
	@GetMapping("userDetail/{userId}")
	public String userDetail(@PathVariable int userId,Model model) {
		model.addAttribute("user",userService.userDetail(userId));
		model.addAttribute("boards",boardRepository.findByUserId(userId));
		return "user/detail"; 
	}
}
