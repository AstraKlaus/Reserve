package org.example.repositories;

import org.example.models.StateReserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StateReserveRepository extends JpaRepository<StateReserve, Long> {
    Optional<StateReserve> findByName(String name);
}
