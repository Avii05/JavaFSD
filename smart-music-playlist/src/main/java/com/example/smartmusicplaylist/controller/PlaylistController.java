package com.example.smartmusicplaylist.controller;

import com.example.smartmusicplaylist.model.Playlist;
import com.example.smartmusicplaylist.service.PlaylistService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/playlists")
@Tag(name = "Playlist Controller", description = "Operations related to Playlists")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;
	
    @Operation(summary = "Create a new playlist")
    @PostMapping
    public Playlist createPlaylst(@RequestBody Playlist playlist) {
        return playlistService.createPlaylist(playlist);
    }
	
    @Operation(summary = "Add a song to an existing playlist")
    @PutMapping("/{id}/addsong/{songId}")
    public Playlist addSongToPlaylist(@PathVariable Long id, @PathVariable Long songId) {
        return playlistService.addSongToPlaylist(id, songId);
    }
	
    @Operation(summary = "Get playlist details by ID")
    @GetMapping("/{id}")
    public Playlist getPlaylist(@PathVariable Long id) {
        return playlistService.getPlaylist(id);
    }
}