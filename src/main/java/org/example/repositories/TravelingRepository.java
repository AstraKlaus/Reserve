package org.example.repositories;

import org.example.models.Traveling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TravelingRepository extends JpaRepository<Traveling, Long> {
    // Поиск путешествия по названию
    Optional<Traveling> findByName(String name);
}
