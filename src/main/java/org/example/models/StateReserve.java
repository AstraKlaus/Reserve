package org.example.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "state_reserve")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StateReserve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
}
