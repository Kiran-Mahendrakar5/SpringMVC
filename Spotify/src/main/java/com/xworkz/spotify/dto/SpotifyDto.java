package com.xworkz.spotify.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "song_table")
@Entity

public class SpotifyDto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String songName;
	private String artist;
	private float rating;
	private String album;

}
