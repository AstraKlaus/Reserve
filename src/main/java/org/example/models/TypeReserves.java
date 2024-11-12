package org.example.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "type_reserve")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TypeReserves {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
}
