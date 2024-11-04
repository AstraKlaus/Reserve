package org.example.repositories;

import org.example.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservesRepository extends JpaRepository<Reserves, Long> {

    // Поиск заповедника по названию
    Optional<Reserves> findByName(String name);


    // Поиск всех заповедников по региону
    List<Reserves> findByRegion(Region region);

    // Поиск по городу
    List<Reserves> findByCity(City city);

    // Поиск по категории
    List<Reserves> findByCategory(Category category);

    // Поиск по типу заповедника
    List<Reserves> findByType(TypeReserves type);

    // Поиск по состоянию заповедника
    List<Reserves> findByState(StateReserve state);

    // Поиск по цели заповедника
    List<Reserves> findByPurpose(Purpose purpose);

    // Кастомный запрос для поиска по размеру
    @Query("SELECT r FROM Reserves r WHERE r.size >= :size")
    List<Reserves> findReservesWithMinSize(@Param("size") Long size);
}
