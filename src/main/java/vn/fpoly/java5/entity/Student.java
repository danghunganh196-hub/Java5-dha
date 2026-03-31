package vn.fpoly.java5.entity;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @NotBlank(message = "Mã sinh viên ko được trống")
//    @NotEmpty
    private String id;

    private String name;
    private Boolean gender;

    @Builder.Default
    private LocalDate birthday = LocalDate.now();

    @Builder.Default
    private String image = "image.png";

    @Range(min = 0, max = 10)
    private Double score;

    private Integer status;
}
