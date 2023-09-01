package com.chocola.springboot.data.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChangeProductNameDto {

    private Long id;
    private String name;

    public ChangeProductNameDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
