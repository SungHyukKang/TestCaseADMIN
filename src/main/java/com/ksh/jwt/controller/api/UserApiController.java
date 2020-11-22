package com.ksh.jwt.controller.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ksh.jwt.dto.common.ResponseDto;
import com.ksh.jwt.model.Board;
import com.ksh.jwt.repository.BoardRepository;
import com.ksh.jwt.repository.UserRepository;
import com.ksh.jwt.service.UserService;

@RestController
public class UserApiController {
	@Autowired
	private UserService userService;
	
	

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("admin/userDelete")
	public ResponseDto<Integer> userDelete(@RequestBody Map<String,Integer> map){
		userService.deleteInfo(map.get("userId"));
		userRepository.deleteById(map.get("userId"));
		
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}

}
