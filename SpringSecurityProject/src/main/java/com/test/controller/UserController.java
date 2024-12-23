package com.test.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.entity.Aggregate;
import com.test.entity.User;
import com.test.entity.Voter;
import com.test.repo.UserRepo;
import com.test.repo.VoteRepo;

@Controller
public class UserController {

	@Autowired
	BCryptPasswordEncoder encoder;
	@Autowired
	UserRepo repo;

	@Autowired
	VoteRepo voterreRepo;

	@GetMapping("/usershome")
	public String homepage() {
		return "login";
	}

	@GetMapping("/profilepage")
	public String homepage(Principal p, Model m) {
		String name = p.getName();
		User byUsername = repo.findByUsername(name);
		m.addAttribute("user", byUsername);
		return "profile";
	}

	@GetMapping("/register")
	public String registerpage() {
		return "register";
	}

	@GetMapping("/successpage")
	public String successpage() {
		return "successpage";
	}

	@GetMapping("/voterslisting")
	public String voterslisting(Model m) {

		List<Object[]> voteCount = voterreRepo.getVoteCount();
		List<Aggregate> list = new ArrayList<>();
		for (Object[] o1 : voteCount) {
			Aggregate ag = new Aggregate();
			ag.setName(o1[0].toString());
			ag.setCount(o1[1].toString());
			list.add(ag);
//			list.add();
//			list.add();
		}
		m.addAttribute("users", list);
		return "voterslisting";
	}

	@GetMapping("/VotePage")
	public String votepage(Principal p, Model m) {

		String name = p.getName();
//		User byUsername = repo.findByUsername(name);

//		System.out.println("voterslist" + list);
		m.addAttribute("username", name);
		return "VotePage";
	}

	@PostMapping("/save")
	public String saveUser(@ModelAttribute User u) {
		u.setPassword(encoder.encode(u.getPassword()));
		repo.save(u);
		return "redirect:/usershome";
	}

	@PostMapping("/voteusers")
	public String voteusers(@ModelAttribute Voter u) {
//		u.setPassword(encoder.encode(u.getPassword()));
//		repo.save(u);
//		voterreRepo.
		voterreRepo.save(u);
		return "redirect:/successpage";
	}

//	@GetMapping("/test")
//	@ResponseBody
//	public String testpage() {
//		return "test page";
//	}

}
