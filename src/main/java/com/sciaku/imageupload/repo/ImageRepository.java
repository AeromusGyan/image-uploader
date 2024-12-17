package com.sciaku.imageupload.repo;

import com.sciaku.imageupload.entity.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<ImageData,String> {

//Optional<ImageData> findByName(String filename);
}
