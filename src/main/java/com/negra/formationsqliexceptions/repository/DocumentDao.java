package com.negra.formationsqliexceptions.repository;

import com.negra.formationsqliexceptions.model.Document;
import com.negra.formationsqliexceptions.model.QDocument;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class DocumentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private DocumentRepository documentRepository;

    private JPAQueryFactory jpaQueryFactory;

    @PostConstruct
    private void postConstruct(){
        jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    public List<Document> findAll(){
        QDocument qDocument = QDocument.document;
        return jpaQueryFactory.selectFrom(qDocument).fetch();
    }

    public List<Document> findByKeyWord(String keyWord){
        QDocument qDocument = QDocument.document;
        return jpaQueryFactory.selectFrom(qDocument).where(qDocument.titre.contains(keyWord)).fetch();
    }

    public Optional<Document> findById(Long id){
        QDocument qDocument = QDocument.document;
        return jpaQueryFactory.selectFrom(qDocument).stream().filter(d -> d.getId().equals(id)).findFirst();
    }

    public Document save(Document document){
        documentRepository.save(document);
        return document;
    }

    public Document update(Document document){

        QDocument qDocument = QDocument.document;
        jpaQueryFactory.update(qDocument)
                .where(qDocument.id.eq(document.getId()))
                .set(qDocument.titre, document.getTitre())
                .set(qDocument.auteur, document.getAuteur())
                .set(qDocument.date_publication, document.getDate_publication())
                .set(qDocument.date_modification, Date.from(Instant.now()))
                .execute();

        return document;

    }

    public List<Document> findAllOrderByTitle(){
        QDocument qDocument = QDocument.document;
        return jpaQueryFactory.selectFrom(qDocument).orderBy(qDocument.titre.asc()).fetch();
    }

    public List<Tuple> findAllGroupByTitle(){
        QDocument qDocument = QDocument.document;

        NumberPath<Long> count = Expressions.numberPath(Long.class, "c");

        return jpaQueryFactory.select(qDocument.titre, qDocument.count().as(count))
                .from(qDocument)
                .groupBy(qDocument.titre)
                .orderBy(count.desc())
                .fetch();
    }

}
