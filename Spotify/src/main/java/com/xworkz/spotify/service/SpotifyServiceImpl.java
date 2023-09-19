package com.xworkz.spotify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.xworkz.spotify.dto.SpotifyDto;
import com.xworkz.spotify.repo.SpotifyRepo;

@Service
public class SpotifyServiceImpl implements SpotifyService {

	@Autowired
	private SpotifyRepo repo;

	@Override
	public boolean validate(SpotifyDto dto, Model model) {
		boolean valid = true;
		if (dto != null) {
			if (dto.getSongName() == null || dto.getSongName().length()<3) {
				model.addAttribute("songName", "isSongNameIsNotValidate");
				valid = false;
			}

			if (dto.getArtist() == null || dto.getArtist().length()< 3) {
				model.addAttribute("artist", "isArtistIsNotValidate");
				valid = false;
			}

			if (dto.getRating() < 3) {
				model.addAttribute("rating", "isRatingIsNotValidate");
				valid = false;
			}
			if (dto.getAlbum() == null || dto.getAlbum().length()< 3) {
				model.addAttribute("album", "isAlbumIsNotValidate");
				valid = false;
			}

		} else {
			System.out.println("given cradantials valid,");
			valid = false;
		}

		return valid;
	}

	@Override
	public boolean save(SpotifyDto dto, Model model) {
		if (validate(dto, model)) {
			System.out.println("cradantial are validated");
			return repo.save(dto);
		}
		return false;

	}

}
