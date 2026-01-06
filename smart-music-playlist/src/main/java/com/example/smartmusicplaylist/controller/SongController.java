package com.example.smartmusicplaylist.controller;

import com.example.smartmusicplaylist.model.Song;
import com.example.smartmusicplaylist.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/songs")
public class SongController {
	
	@Autowired
	private SongService songService;
	
	@PostMapping
	public Song addSong(@RequestBody Song song) {
		return songService.addSong(song);
	}
	
	@GetMapping("{id}")
	public Song getsong(@PathVariable long id) {
		return songService.getSong(id);
	}

}
