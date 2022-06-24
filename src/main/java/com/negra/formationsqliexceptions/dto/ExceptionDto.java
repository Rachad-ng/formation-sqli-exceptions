package com.negra.formationsqliexceptions.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class ExceptionDto {

    private String message;

    private int code;

}
