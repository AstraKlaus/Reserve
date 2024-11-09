package org.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "reserves")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reserves {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "id_region", nullable = false)
    private Region region;

    @ManyToOne
    @JoinColumn(name = "id_city", nullable = false)
    private City city;

    @Column(name = "data_create")
    private LocalDate dataCreate;

    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "id_state", nullable = false)
    private StateReserve state;

    @ManyToOne
    @JoinColumn(name = "id_type", nullable = false)
    private TypeReserves type;

    @ManyToOne
    @JoinColumn(name = "id_purpose", nullable = false)
    private Purpose purpose;

    private String department;
    private Long countCluster;
    private Long size;
    private Long guardedSize;
    private String mail;
    private String supervisor;
    private Long phone;
    private String email;
    private String link;

    @Column(name = "x")
    private double x;

    @Column(name = "y")
    private double y;

    @JsonIgnore
    @OneToMany(mappedBy = "reserves")
    private Set<ReservesToImg> images;

    @JsonIgnore
    @OneToMany(mappedBy = "reserves")
    private Set<ReservesToTraveling> travelings;
}

