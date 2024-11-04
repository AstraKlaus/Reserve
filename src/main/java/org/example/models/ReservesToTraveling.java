package org.example.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reserves_to_traveling")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservesToTraveling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_reserves", nullable = false)
    private Reserves reserves;

    @ManyToOne
    @JoinColumn(name = "id_traveling", nullable = false)
    private Traveling traveling;
}
