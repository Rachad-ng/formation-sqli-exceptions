package com.negra.formationsqliexceptions.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class DocumentDto implements Serializable {
    private final Long id;
    private final String titre;
    private final String auteur;
    private final Date date_publication;
}
