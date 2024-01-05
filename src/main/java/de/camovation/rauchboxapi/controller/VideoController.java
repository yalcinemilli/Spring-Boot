package de.camovation.rauchboxapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.camovation.rauchboxapi.mapper.CustomFieldMapper;
import de.camovation.rauchboxapi.mapper.VideoMapper;
import de.camovation.rauchboxapi.models.Video;
import de.camovation.rauchboxapi.repository.VideoRepository;
import de.camovation.rauchboxapi.response.ListResponse;
import de.camovation.rauchboxapi.response.VideoResponse;
import de.camovation.rauchboxapi.service.CustomFieldService;
import de.camovation.rauchboxapi.service.VideoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/videos")
@CrossOrigin(origins = "http://localhost:4200")
public class VideoController {
    
    private final VideoRepository videoRepository;
    private final VideoMapper videoMapper;
    private final VideoService videoService;
    private final CustomFieldMapper customFieldMapper;
    private final CustomFieldService customFieldService;
    
    @GetMapping("/{id}")
    public ResponseEntity<ListResponse<VideoResponse>> getVideos(@PathVariable int id) {
        List<Video> videos = videoRepository.findByKundenid(id);
        
        if (videos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<VideoResponse> list = videoMapper.mapToResponseListe(videos);
        list.forEach(videoResponse -> {
            videoResponse.setCustomfields(
                
            customFieldMapper.mapToResponseListe(customFieldService.getCustomFields("video" + id)));
        });
        
        ListResponse<VideoResponse> response = new ListResponse<>(list, list.size());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/erstellen/{id}")
    public ResponseEntity<VideoResponse> createVideo(@PathVariable int id, @RequestBody @Valid Video request) {
        Video createdVideo = videoService.createVideo(id, request);
        VideoResponse response = videoMapper.mapToResponse(createdVideo);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/bearbeiten/{id}")
    public ResponseEntity<VideoResponse> updateVideo(@PathVariable int id, @RequestBody @Valid Video request) {
        Video updatedVideo = videoService.updateVideo(id, request);
        VideoResponse response = videoMapper.mapToResponse(updatedVideo);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }



    @DeleteMapping("/loeschen/{id}")
    public ResponseEntity<Void> deleteVideo(@PathVariable int id) {
        videoService.deleteVideoById(id);
       return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/loeschen/kundenid/{id}")
    public ResponseEntity<Void> deleteVideoByKundenid(@PathVariable int id) {
        videoService.deleteVideoByKundenid(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
