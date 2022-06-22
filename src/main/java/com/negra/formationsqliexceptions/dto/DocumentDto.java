package com.negra.formationsqliexceptions.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class DocumentDto implements Serializable {
    private Long id;
    private String titre;
    private String auteur;
    private Date date_publication;
}
