package org.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reserves_to_img")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservesToImg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_reserves", nullable = false)
    private Reserves reserves;

    @ManyToOne
    @JoinColumn(name = "id_img", nullable = false)
    private Img img;
}
