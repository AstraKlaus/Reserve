package org.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

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

    @JsonIgnore
    @OneToMany(mappedBy = "img")
    private Set<ReservesToImg> reserves;
}
