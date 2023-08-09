package de.camovation.rauchboxapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import de.camovation.rauchboxapi.models.Video;
import de.camovation.rauchboxapi.repository.VideoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class VideoService {
    
    private final VideoRepository videoRepository;

    public List<Video> getVideoById(Integer id) {
        return videoRepository
                .findByKundenid(id);
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
        if (video.getKameranetzwerk() != null) {
            oldVideo.setKameranetzwerk(video.getKameranetzwerk());
        }
        if (video.getDnsserver() != null) {
            oldVideo.setDnsserver(video.getDnsserver());
        }
        if (video.getSwitchzugang() != null) {
            oldVideo.setSwitchzugang(video.getSwitchzugang());
        }
        if (video.getWindowszugang() != null) {
            oldVideo.setWindowszugang(video.getWindowszugang());
        }
        if (video.getNvrzugang() != null) {
            oldVideo.setNvrzugang(video.getNvrzugang());
        }
        if (video.getKamerazugang() != null) {
            oldVideo.setKamerazugang(video.getKamerazugang());
        }
        if (video.getCamozugang() != null) {
            oldVideo.setCamozugang(video.getCamozugang());
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
