package com.ksh.jwt.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ksh.jwt.dto.board.BoardViewDto;
import com.ksh.jwt.model.Board;
import com.ksh.jwt.model.Problem;
import com.ksh.jwt.model.User;
import com.ksh.jwt.repository.BoardRepository;
import com.ksh.jwt.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BoardRepository boardRepository;

	public Page<User> userList(Pageable pageable) {
		// TODO Auto-generated method stub
		Page<User> user = userRepository.findAll(pageable);
		return user;
	}

	public User userDetail(int userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> {
			return new IllegalArgumentException("사용자를 찾을 수 없습니다.");
		});
		return user;
	}
	@Transactional
	public void deleteInfo(int id) {
		HashMap<Integer, Boolean> hsmap = new HashMap<>();
		List<Board> boards = boardRepository.findByUserId(id);
		List<User> users = userRepository.findAll();
		for (Board b : boards) {
			for (Problem p : b.getProblems()) {
				hsmap.put(p.getId(), true);
			}
			boardRepository.deleteById(b.getId());
		}
		for (User u : users) {
			if (u == null)
				continue;
			if (u.getId() == id)
				continue;
			String sol = u.getSolved();
			String wro = u.getWrong();
			String fav = u.getFavorite();
			for (String p : u.getSolvedList()) {
				if (hsmap.get(Integer.parseInt(p)) != null && hsmap.get(Integer.parseInt(p)))
					sol = replacePerfect(sol, p);
			}
			for (String w : u.getWrongList()) {
				if (hsmap.get(Integer.parseInt(w)) != null && hsmap.get(Integer.parseInt(w)))
					wro = replacePerfect(wro, w);
			}
			for (String f : u.getFavoriteList()) {
				if (hsmap.get(Integer.parseInt(f)) != null && hsmap.get(Integer.parseInt(f)))
					fav = replacePerfect(fav, f);
			}
			u.setSolved(sol);
			u.setFavorite(fav);
			u.setWrong(wro);
		}
	}

	public String replacePerfect(String str, String change) {
		StringBuilder sb = new StringBuilder();
		for (String X : str.split(" ")) {
			if (X.equals(change)) {
				continue;
			}
			sb.append(X + " ");
		}
		return sb.toString().trim();
	}
}
