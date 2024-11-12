package org.example.repositories;

import jakarta.transaction.Transactional;
import org.example.models.Img;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
@Transactional
public interface ImgRepository extends JpaRepository<Img, Long> {
    Optional<Img> findByLink(String link);

    // Новый метод для поиска изображений по ID резерва
    List<Img> findByReserveId(Long reserveId);
}
