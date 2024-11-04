package org.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "traveling")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Traveling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private List<Point> points;

    @JsonIgnore
    @OneToMany(mappedBy = "traveling")
    private Set<ReservesToTraveling> reserves;
}
