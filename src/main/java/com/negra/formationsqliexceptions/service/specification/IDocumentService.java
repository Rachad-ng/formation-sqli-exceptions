package com.negra.formationsqliexceptions.service.specification;

import com.negra.formationsqliexceptions.dto.DocumentDto;
import com.negra.formationsqliexceptions.dto.DocumentDtoWithoutId;
import com.negra.formationsqliexceptions.exception.AucunDocumentTrouveException;
import com.negra.formationsqliexceptions.exception.DocumentInexistantException;
import com.negra.formationsqliexceptions.exception.ListeDocumentsVideException;

import java.util.List;

public interface IDocumentService {

    List<DocumentDto> getDocuments() throws ListeDocumentsVideException;
    DocumentDto getById(Long id) throws DocumentInexistantException;
    List<DocumentDto> getByTitleKeyWord(String keyWord) throws AucunDocumentTrouveException;

    DocumentDto save(DocumentDtoWithoutId documentDtoWithoutId);

    DocumentDto update(DocumentDto documentDto);

}
