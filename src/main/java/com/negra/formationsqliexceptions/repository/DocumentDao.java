package com.negra.formationsqliexceptions.repository;

import com.negra.formationsqliexceptions.model.Document;
import com.negra.formationsqliexceptions.model.QDocument;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class DocumentDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Document> findAll(){
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QDocument qDocument = QDocument.document;
        return queryFactory.selectFrom(qDocument).fetch();
    }

    public List<Document> findByKeyWord(String keyWord){
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QDocument qDocument = QDocument.document;
        return queryFactory.selectFrom(qDocument).stream().filter(d -> d.getTitre().contains(keyWord)).collect(Collectors.toList());
    }

    public Optional<Document> findById(Long id){
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QDocument qDocument = QDocument.document;
        return queryFactory.selectFrom(qDocument).stream().filter(d -> d.getId().equals(id)).findFirst();
    }

}
