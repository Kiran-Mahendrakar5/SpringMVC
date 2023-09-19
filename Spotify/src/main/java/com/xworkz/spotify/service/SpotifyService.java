package com.xworkz.spotify.service;

import org.springframework.ui.Model;

import com.xworkz.spotify.dto.SpotifyDto;

public interface SpotifyService {
	
	public boolean validate(SpotifyDto dto,Model model);
	
	public boolean save(SpotifyDto dto,Model model);
	
	
	

}
