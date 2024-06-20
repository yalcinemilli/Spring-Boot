package de.camovation.rauchboxapi.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import de.camovation.rauchboxapi.models.Video;
import de.camovation.rauchboxapi.request.VideoRequest;
import de.camovation.rauchboxapi.response.VideoResponse;

@Mapper
public interface VideoMapper {
    
    Video mapToModel(VideoRequest request);
    VideoResponse mapToResponse(Video video);
    List<VideoResponse> mapToResponseListe(List<Video> videos);
}
