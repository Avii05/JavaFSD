package com.example.smartmusicplaylist.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Playlist {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long playlistId;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	@ElementCollection
	private List<Long> songsIds;

	// Getters and setters
	public Long getPlaylistId() {
		return playlistId;
	}

	public void setPlaylistId(Long playlistId) {
		this.playlistId = playlistId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Long> getSongsIds() {
		return songsIds;
	}

	public void setSongsIds(List<Long> songsIds) {
		this.songsIds = songsIds;
	}
}
