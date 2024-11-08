package org.example.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Point implements Serializable {
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
    private double x;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
    private double y;
}
