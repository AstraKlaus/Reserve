package org.example.repositories;

import org.example.models.Reserves;
import org.example.models.ReservesToTraveling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservesToTravelingRepository extends JpaRepository<ReservesToTraveling, Long> {
    // Поиск всех путешествий для конкретного заповедника
    List<ReservesToTraveling> findByReserves(Reserves reserves);
}
