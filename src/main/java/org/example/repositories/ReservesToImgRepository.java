package org.example.repositories;

import org.example.models.Reserves;
import org.example.models.ReservesToImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservesToImgRepository extends JpaRepository<ReservesToImg, Long> {
    // Поиск всех изображений для конкретного заповедника
    List<ReservesToImg> findByReserves(Reserves reserves);
}
