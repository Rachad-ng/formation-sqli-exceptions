package com.negra.formationsqliexceptions.repository;

import com.negra.formationsqliexceptions.model.Document;
import com.negra.formationsqliexceptions.model.QDocument;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

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
        return queryFactory.selectFrom(qDocument).where(qDocument.titre.contains(keyWord)).fetch();
    }

    public Optional<Document> findById(Long id){
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QDocument qDocument = QDocument.document;
        return queryFactory.selectFrom(qDocument).stream().filter(d -> d.getId().equals(id)).findFirst();
    }

    public List<Document> findAllOrderByTitle(){
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QDocument qDocument = QDocument.document;
        return queryFactory.selectFrom(qDocument).orderBy(qDocument.titre.asc()).fetch();
    }

    public List<Tuple> findAllGroupByTitle(){
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QDocument qDocument = QDocument.document;

        NumberPath<Long> count = Expressions.numberPath(Long.class, "c");

        return queryFactory.select(qDocument.titre, qDocument.count().as(count))
                .from(qDocument)
                .groupBy(qDocument.titre)
                .orderBy(count.desc())
                .fetch();
    }

}
