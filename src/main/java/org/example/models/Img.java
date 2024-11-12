package org.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "img")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Img {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String link;

    @Lob
    @Column(nullable = false)
    private byte[] image;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_reserve", nullable = false)
    private Reserve reserve;
}
