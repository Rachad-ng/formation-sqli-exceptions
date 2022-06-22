package com.negra.formationsqliexceptions.mapper;

import com.negra.formationsqliexceptions.dto.DocumentDto;
import com.negra.formationsqliexceptions.model.Document;
import fr.xebia.extras.selma.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper
public interface IDocumentDtoSelmaMapper {

    DocumentDto documentToDocumentDto(Document document);

    List<DocumentDto> documentToDocumentDto(Collection<Document> documentCollection);
}
