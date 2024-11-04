package org.example.models;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "purpose")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Purpose {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
}