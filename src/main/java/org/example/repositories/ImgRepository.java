package org.example.repositories;

import org.example.models.Img;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImgRepository extends JpaRepository<Img, Long> {
    // Поиск изображений по ссылке
    Optional<Img> findByLink(String link);
}