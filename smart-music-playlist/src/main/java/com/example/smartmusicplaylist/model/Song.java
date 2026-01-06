package com.example.smartmusicplaylist.model;

import jakarta.persistence.*;;

@Entity
public class Song {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long songId;
	
	private String title;
	private String artist;
	private String duration;
	
	// Getters and Setters
	public Long getSongId() {
		return songId;
	}
	public void setSongId(Long songId) {
		this.songId = songId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	
	

}
