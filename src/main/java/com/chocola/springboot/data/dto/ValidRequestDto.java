package com.chocola.springboot.data.dto;

import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ValidRequestDto {

    @NotBlank
    private String name;

    @Email
    private String email;

    @Pattern(regexp = "01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$")
    private String phoneNumber;

    @Min(20)
    @Max(40)
    private int age;

    @Size(min = 0, max = 40)
    private String description;

    @PositiveOrZero
    private int count;

    @AssertTrue(message = "false입니다. true 요망")
    private boolean booleanCheck;
}
