package com.negra.formationsqliexceptions.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDto implements Serializable {

    private Long id;

    @NotNull(message = "Vous devez spécifier le titre.!!")
    private String titre;

    @NotNull(message = "Vous devez spécifier l'auteur.!!")
    private String auteur;

    @Past(message = "La date de publication n'est pas valide")
    private Date date_publication;
}
