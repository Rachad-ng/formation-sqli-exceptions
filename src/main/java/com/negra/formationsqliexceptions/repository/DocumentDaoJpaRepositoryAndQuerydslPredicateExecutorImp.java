package com.negra.formationsqliexceptions.repository;

import com.negra.formationsqliexceptions.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentDaoJpaRepositoryAndQuerydslPredicateExecutorImp extends JpaRepository<Document, Long>, QuerydslPredicateExecutor<Document> {

    List<Document> findDocumentByTitreContaining(String key);

}
