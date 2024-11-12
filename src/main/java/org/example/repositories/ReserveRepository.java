package org.example.repositories;

import org.example.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReserveRepository extends JpaRepository<Reserve, Long> {

    // Поиск заповедника по названию
    Optional<Reserve> findByName(String name);


    // Поиск всех заповедников по региону
    List<Reserve> findByRegion(Region region);

    // Поиск по городу
    List<Reserve> findByCity(City city);

    // Поиск по категории
    List<Reserve> findByCategory(Category category);

    // Поиск по типу заповедника
    List<Reserve> findByType(TypeReserves type);

    // Поиск по состоянию заповедника
    List<Reserve> findByState(StateReserve state);

    // Поиск по цели заповедника
    List<Reserve> findByPurpose(Purpose purpose);

    // Кастомный запрос для поиска по размеру
    @Query("SELECT r FROM Reserve r WHERE r.size >= :size")
    List<Reserve> findReservesWithMinSize(@Param("size") Long size);
}
