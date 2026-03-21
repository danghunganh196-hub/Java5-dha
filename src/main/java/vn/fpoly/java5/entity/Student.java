package vn.fpoly.java5.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String id;
    private String name;
    private boolean gender;

    @Builder.Default
    private LocalDate birthday = LocalDate.now();

    @Builder.Default
    private String image = "image.png";
    private double score;
}
