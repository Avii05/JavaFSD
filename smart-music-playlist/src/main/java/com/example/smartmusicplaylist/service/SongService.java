package com.example.smartmusicplaylist.service;

import com.example.smartmusicplaylist.model.Song;
import com.example.smartmusicplaylist.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService {
	@Autowired
	private SongRepository songRepository;
	
	public Song addSong(Song song) {
		return songRepository.save(song);
	}
	
	public Song getSong(Long id) {
		return songRepository.findById(id).orElse(null);
	}

}
