package com.negra.formationsqliexceptions.repository;

import com.negra.formationsqliexceptions.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {

    List<Document> findDocumentByTitreContaining(String keyWord);

}
