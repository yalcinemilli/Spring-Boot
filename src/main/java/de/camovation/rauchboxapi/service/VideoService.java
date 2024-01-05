package de.camovation.rauchboxapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import de.camovation.rauchboxapi.mapper.CustomFieldMapper;
import de.camovation.rauchboxapi.mapper.VideoMapper;
import de.camovation.rauchboxapi.models.Video;
import de.camovation.rauchboxapi.repository.VideoRepository;
import de.camovation.rauchboxapi.response.VideoResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class VideoService {
    
    private final VideoRepository videoRepository;
    private final VideoMapper videoMapper;
    private final CustomFieldService customFieldService;
    private final CustomFieldMapper customFieldMapper;
    public List<Video> getVideoById(Integer id) {
        return videoRepository
                .findByKundenid(id);
    }

    public List<VideoResponse> getVideo (Integer id) {
        List<Video> video = videoRepository.findByKundenid(id);
        List<VideoResponse> list = videoMapper.mapToResponseListe(video);
        list.forEach(videoResponse -> {
            videoResponse.setCustomfields(
                
            customFieldMapper.mapToResponseListe(customFieldService.getCustomFields("video" + videoResponse.getId())));
        });
        return list;
    }
    public Video createVideo(int kundenid, Video video) {
        video.setKundenid(kundenid);
        return videoRepository.save(video);
    }

    public Video updateVideo(int id, Video video) {
        Video oldVideo = videoRepository.findById(id);
        if (video.getExtipadr() != null) {
            oldVideo.setExtipadr(video.getExtipadr());
        }
        if (video.getIntipadr() != null) {
            oldVideo.setIntipadr(video.getIntipadr());
        }
        if (video.getBezeichnung() != null) {
            oldVideo.setBezeichnung(video.getBezeichnung());
        }

        return videoRepository.save(oldVideo);
    }
    public void deleteVideoById(int id) {
        videoRepository.deleteById(id);
    }

    public void deleteVideoByKundenid(int id) {
        videoRepository.deleteVideoByKundenid(id);
    }
}
