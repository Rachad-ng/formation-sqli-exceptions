package com.negra.formationsqliexceptions.mapper;

import com.negra.formationsqliexceptions.dto.DocumentDtoWithoutId;
import com.negra.formationsqliexceptions.model.Document;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

@Mapper(withIoC = IoC.SPRING, withIgnoreFields = {"id", "date_creation", "date_modification"})
public interface IDocumentDtoWithoutIdSelmaMapper {

    Document documentDtoWithoutIdToDocument(DocumentDtoWithoutId documentDtoWithoutId);

}
