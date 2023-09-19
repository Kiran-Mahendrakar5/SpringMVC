package com.xworkz.spotify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xworkz.spotify.dto.SpotifyDto;
import com.xworkz.spotify.service.SpotifyService;

@Controller
public class SpotifyController {
	@Autowired
	private SpotifyService service;

	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public String getMyMethod(SpotifyDto dto, Model model) {
		System.out.println(dto);
//		service.save(dto);
		boolean status = service.save(dto, model);
		if (status) {
			System.out.println("controller");
			model.addAttribute("save", dto);
			return "Success";
		} else {
			return "Add";
		}

	}

}
