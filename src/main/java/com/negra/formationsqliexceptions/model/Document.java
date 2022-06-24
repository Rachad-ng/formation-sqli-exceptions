package com.negra.formationsqliexceptions.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "document")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull(message = "Vous devez spécifier le titre.!!")
    @Column(nullable = false)
    private String titre;

    @NotNull(message = "Vous devez spécifier l'auteur.!!")
    @Column(nullable = false)
    private String auteur;

    @Past(message = "La date de publication n'est pas valide")
    @Column(nullable = false)
    private Date date_publication;

    @Past(message = "La date de création n'est pas valide")
    @Column(nullable = false)
    private Date date_creation;

    @Past(message = "La date de modification n'est pas valide")
    @Column(nullable = false)
    private Date date_modification;

    public Document(Long id, String titre, String auteur, Date date_publication){
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.date_publication = date_publication;
        this.date_creation = Date.from(Instant.now());
        this.date_modification = Date.from(Instant.now());
    }

    public Document(String titre, String auteur, Date date_publication){
        this.titre = titre;
        this.auteur = auteur;
        this.date_publication = date_publication;
        this.date_creation = Date.from(Instant.now());
        this.date_modification = Date.from(Instant.now());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return id.equals(document.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
