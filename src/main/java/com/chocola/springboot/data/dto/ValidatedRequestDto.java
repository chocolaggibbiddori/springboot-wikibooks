package com.chocola.springboot.data.dto;

import com.chocola.springboot.data.group.ValidationGroup1;
import com.chocola.springboot.data.group.ValidationGroup2;
import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ValidatedRequestDto {

    @NotBlank
    private String name;

    @Email
    private String email;

    @Pattern(regexp = "01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$")
    private String phoneNumber;

    @Min(value = 20, groups = ValidationGroup1.class)
    @Max(value = 40, groups = ValidationGroup2.class)
    private int age;

    @Size(min = 0, max = 40)
    private String description;

    @PositiveOrZero(groups = ValidationGroup2.class)
    private int count;

    @AssertTrue(message = "false입니다. true 요망")
    private boolean booleanCheck;
}
