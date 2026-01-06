package com.example.smartmusicplaylist.service;

import com.example.smartmusicplaylist.model.Playlist;
import com.example.smartmusicplaylist.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService {
	@Autowired
	private PlaylistRepository playlistRepository;
	
	public Playlist createPlaylist(Playlist playlist) {
		return playlistRepository.save(playlist);
	}
	
	public Playlist getPlaylist(long id) {
		return playlistRepository.findById(id).orElse(null);
	}
	
	public Playlist addSongToPlaylist(Long playlistId, Long songId) {
		Playlist playlist=playlistRepository.findById(playlistId).orElse(null);
		if(playlist!=null) {
			playlist.getSongsIds().add(songId);
			return playlistRepository.save(playlist);
		}
		return null;
	}

}
