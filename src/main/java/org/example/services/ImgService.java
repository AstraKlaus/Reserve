package org.example.services;

import org.example.exceptions.IDNotFoundException;
import org.example.models.*;
import org.example.repositories.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImgService {

    private final ImgRepository imgRepository;

    public List<Img> getAllImages() {
        return imgRepository.findAll();
    }

    public Img getImageById(Long id) {
        return imgRepository.findById(id)
                .orElseThrow(() -> new IDNotFoundException(("Image with id " + id + " not found")));
    }

    public Img createImage(Img img) {
        return imgRepository.save(img);
    }

    public Img updateImage(Long id, Img img) {
        Img existingImg = getImageById(id);
        existingImg.setLink(img.getLink());
        return imgRepository.save(existingImg);
    }

    public void deleteImage(Long id) {
        imgRepository.deleteById(id);
    }

    public Optional<Img> findByLink(String link) {
        return imgRepository.findByLink(link);
    }
}

