package com.negra.formationsqliexceptions.service.implementation;

import com.negra.formationsqliexceptions.dto.DocumentDto;
import com.negra.formationsqliexceptions.dto.DocumentDtoWithoutId;
import com.negra.formationsqliexceptions.exception.AucunDocumentTrouveException;
import com.negra.formationsqliexceptions.exception.DocumentInexistantException;
import com.negra.formationsqliexceptions.exception.ListeDocumentsVideException;
import com.negra.formationsqliexceptions.mapper.IDocumentDtoSelmaMapper;
import com.negra.formationsqliexceptions.mapper.IDocumentDtoWithoutIdSelmaMapper;
import com.negra.formationsqliexceptions.model.Document;
import com.negra.formationsqliexceptions.repository.DocumentDaoJpaRepositoryAndQuerydslPredicateExecutorImp;
import com.negra.formationsqliexceptions.service.specification.IDocumentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Qualifier("documentServiceJpaRepositoryAndQuerydslImp")
@Transactional
@AllArgsConstructor
public class DocumentServiceJpaRepositoryAndQuerydslImp implements IDocumentService {

    private static final String LISTE_DOCUMENTS_VIDE_EXCEPTION_MESSAGE = "La liste des documents est vide.!!";
    private static final String DOCUMENT_INEXISTANT_EXCEPTION_MESSAGE = "Le document que vous cherchiez n'existe plus.!!";
    private static final String AUCUN_DOCUMENT_TROUVE_EXCEPTION_MESSAGE = "Aucun document correspondant à votre recherche.!!";

    private DocumentDaoJpaRepositoryAndQuerydslPredicateExecutorImp documentDao;
    private IDocumentDtoSelmaMapper documentDtoSelmaMapper;

    private IDocumentDtoWithoutIdSelmaMapper documentDtoWithoutIdToDocument;

    @Override
    public List<DocumentDto> getDocuments() throws ListeDocumentsVideException {
        List<Document> documentList = documentDao.findAll();

        if(documentList.size() == 0)
            throw new ListeDocumentsVideException(LISTE_DOCUMENTS_VIDE_EXCEPTION_MESSAGE);

        return documentDtoSelmaMapper.documentToDocumentDto(documentList);
    }

    @Override
    public DocumentDto getById(Long id) throws DocumentInexistantException {

        Optional<Document> optionalDocument = documentDao.findById(id);

        if(optionalDocument.isPresent())
            return documentDtoSelmaMapper.documentToDocumentDto(optionalDocument.get());
        else
            throw new DocumentInexistantException(DOCUMENT_INEXISTANT_EXCEPTION_MESSAGE);
    }

    @Override
    public List<DocumentDto> getByTitleKeyWord(String keyWord) throws AucunDocumentTrouveException {
        List<Document> documentList = documentDao.findDocumentByTitreContaining(keyWord);

        if(documentList.size() == 0)
            throw new AucunDocumentTrouveException(AUCUN_DOCUMENT_TROUVE_EXCEPTION_MESSAGE);

        return documentDtoSelmaMapper.documentToDocumentDto(documentList);
    }

    public DocumentDto save(DocumentDtoWithoutId documentDtoWithoutId){
        Document document = documentDtoWithoutIdToDocument.documentDtoWithoutIdToDocument(documentDtoWithoutId);
        documentDao.save(document);
        return documentDtoSelmaMapper.documentToDocumentDto(document);
    }

    @Override
    public DocumentDto update(DocumentDto documentDto) {
        return null;
    }
}
