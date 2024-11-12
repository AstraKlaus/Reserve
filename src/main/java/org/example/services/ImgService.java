package org.example.services;

import org.example.exceptions.IDNotFoundException;
import org.example.models.*;
import org.example.repositories.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ImgService {

    private final ImgRepository imgRepository;
    private final ReserveRepository reserveRepository;

    public List<Img> getAllImages() {
        return imgRepository.findAll();
    }

    public Img getImageById(Long id) {
        return imgRepository.findById(id)
                .orElseThrow(() -> new IDNotFoundException("Image with id " + id + " not found"));
    }

    // Новый метод для сохранения изображения и привязки к резерву
    public Img saveImage(MultipartFile file, Long reserveId) throws IOException {
        String link = file.getOriginalFilename(); // генерируем имя файла с расширением
        byte[] imageData = file.getBytes();

        Reserve reserve = reserveRepository.findById(reserveId)
                .orElseThrow(() -> new IDNotFoundException("Reserve with id " + reserveId + " not found"));

            return imgRepository.save(Img.builder().link(link).image(imageData).reserve(reserve).build());
        }

    public void deleteImage(Long id) {
        imgRepository.deleteById(id);
    }

    public List<Img> getImagesByReserveId(Long reserveId) {
        return imgRepository.findByReserveId(reserveId);
    }
}
