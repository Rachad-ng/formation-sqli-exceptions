package com.negra.formationsqliexceptions.mapper;

import com.negra.formationsqliexceptions.dto.DocumentDto;
import com.negra.formationsqliexceptions.model.Document;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface IDocumentDtoMapStructMapper {

    DocumentDto documentToDocumentDto(Document document);

    List<DocumentDto> documentToDocumentDto(Collection<Document> documentCollection);

}
