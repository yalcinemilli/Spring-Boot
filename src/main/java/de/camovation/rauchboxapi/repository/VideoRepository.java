package de.camovation.rauchboxapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.camovation.rauchboxapi.models.Video;

public interface VideoRepository extends JpaRepository<Video, Integer>{
    List<Video> findByKundenid(int kundenid);
    void deleteByKundenid(int id);
    void deleteVideoByKundenid(int id);
    Video findById(int id);

}
