package com.negra.formationsqliexceptions.mapper;

import com.negra.formationsqliexceptions.dto.DocumentDto;
import com.negra.formationsqliexceptions.dto.DocumentDtoWithoutId;
import com.negra.formationsqliexceptions.model.Document;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper(withIoC = IoC.SPRING, withIgnoreFields = {"date_creation", "date_modification"})
public interface IDocumentDtoSelmaMapper {

    DocumentDto documentToDocumentDto(Document document);
    Document documentDtoToDocument(DocumentDto documentDto);

    List<DocumentDto> documentToDocumentDto(Collection<Document> documentCollection);
    List<Document> documentDtoToDocument(Collection<DocumentDto> documentDtoCollection);
}
