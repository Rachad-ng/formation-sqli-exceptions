package com.negra.formationsqliexceptions.repository;

import com.negra.formationsqliexceptions.model.Document;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DocumentDaoTest {

    @Autowired
    private DocumentDao documentDao;

    @Test
    @Ignore("Ce teste nécessite au moins un document existant")
    public void findAll() {

        List<Document> documentList = documentDao.findAll();
        assertThat(documentList.size()).isGreaterThan(0);

    }

    @Test
    public void findByKeyWord() {

        String keyWord = "*";
        List<Document> documentList = documentDao.findByKeyWord(keyWord);

        for (Document document: documentList)
            assertThat(document.getTitre()).contains(keyWord);
    }

    @Test
    @Ignore("Ce teste nécessite au moins un document existant")
    public void findById() {
        Long id = 1L;
        Optional<Document> document = documentDao.findById(id);

        if(!document.isPresent())
            fail("La recherche de document par Id n'est pas operationnel");

    }

    @Test
    public void save() {
        Document document = new Document("L'espoire", "Rachad", Date.from(Instant.now()));
        documentDao.save(document);
        assertThat(document.getId()).isNotNull();
    }

    @Test
    @Ignore("Ce teste nécessite au moins un document existant")
    public void update(){
        Long id = 1L;

        Optional<Document> optionalDocument = documentDao.findById(id);
        if(!optionalDocument.isPresent())
            fail("Il n'existe aucun element à modifier.!!");

        Document document = optionalDocument.get();

        Date previousModificationDate = document.getDate_modification();

        Document newDocument = new Document(id, "aaa", "ccc", Date.from(Instant.now()));
        documentDao.update(newDocument);

        document = documentDao.findById(id).get();
        Date newModificationDate = document.getDate_modification();

        assertThat(newModificationDate).isAfter(previousModificationDate);
    }

}
