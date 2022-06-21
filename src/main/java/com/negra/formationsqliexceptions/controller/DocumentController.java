package com.negra.formationsqliexceptions.controller;

import com.negra.formationsqliexceptions.dto.DocumentDto;
import com.negra.formationsqliexceptions.service.specification.IDocumentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/document")
public class DocumentController {

    private IDocumentService documentService;

    @GetMapping
    public ResponseEntity<List<DocumentDto>> getDocuments(@RequestParam(required = false) String key){

        List<DocumentDto> documentDtoList = (key == null) ? documentService.getDocuments() : documentService.getByTitleKeyWord(key);

        return ResponseEntity.ok(documentDtoList);

    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentDto> getDocumentById(@PathVariable Long id){

        DocumentDto documentDto = documentService.getById(id);;

        return ResponseEntity.ok(documentDto);

    }

}
