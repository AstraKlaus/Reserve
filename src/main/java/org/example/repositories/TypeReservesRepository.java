package org.example.repositories;

import org.example.models.TypeReserves;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeReservesRepository extends JpaRepository<TypeReserves, Long> {
    Optional<TypeReserves> findByName(String name);
}
