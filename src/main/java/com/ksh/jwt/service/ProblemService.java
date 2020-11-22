package com.ksh.jwt.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ksh.jwt.dto.problem.MySolvedDto;
import com.ksh.jwt.model.Board;
import com.ksh.jwt.model.Problem;
import com.ksh.jwt.model.User;
import com.ksh.jwt.repository.BoardRepository;
import com.ksh.jwt.repository.ProblemRepository;
import com.ksh.jwt.repository.UserRepository;

@Service
//@RequiredArgsConstructor -> @Authwired 생략 가능 final로 선언
public class ProblemService {
	@Autowired
	private ProblemRepository problemRepository;
	@Autowired 
	private UserRepository userRepository;
	
	
	@Transactional
	public void delete(int problemId) {
		List<User> users = userRepository.findAll();
		HashMap<Integer,Boolean> hsmap =new HashMap<>();
		hsmap.put(problemId, true);
		for(User u : users) {
			if(u==null)
				continue;
			String sol = u.getSolved();
			String wro = u.getWrong();
			for(String p : u.getSolvedList()) {
				if(hsmap.get(Integer.parseInt(p))!=null&&hsmap.get(Integer.parseInt(p)))
					sol =replacePerfect(sol,p);
			}
			for(String w : u.getWrongList()) {
				if(hsmap.get(Integer.parseInt(w))!=null&&hsmap.get(Integer.parseInt(w)))
					wro =replacePerfect(wro,w);
			}
			u.setSolved(sol);
			u.setWrong(wro);
		}
		problemRepository.deleteById(problemId);
	}
	public  String replacePerfect(String str,String change) {
		StringBuilder sb = new StringBuilder();
		for(String X : str.split(" ")) {
			if(X.equals(change)) {
				continue;
			}
			sb.append(X+" ");
		}
		return sb.toString().trim();
	}
}