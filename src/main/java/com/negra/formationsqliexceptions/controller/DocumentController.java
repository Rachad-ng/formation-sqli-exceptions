package com.negra.formationsqliexceptions.controller;

import com.negra.formationsqliexceptions.dto.DocumentDto;
import com.negra.formationsqliexceptions.dto.DocumentDtoWithoutId;
import com.negra.formationsqliexceptions.service.specification.IDocumentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/document")
public class DocumentController {

    private IDocumentService documentServiceQuerydslImp;

    @GetMapping
    public ResponseEntity<List<DocumentDto>> getDocuments(@RequestParam(required = false) String key){

        List<DocumentDto> documentDtoList = (key == null) ? documentServiceQuerydslImp.getDocuments() : documentServiceQuerydslImp.getByTitleKeyWord(key);

        return ResponseEntity.ok(documentDtoList);

    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentDto> getDocumentById(@PathVariable Long id){

        DocumentDto documentDto = documentServiceQuerydslImp.getById(id);;

        return ResponseEntity.ok(documentDto);

    }

    @PostMapping
    public ResponseEntity<DocumentDto> save(@Valid @RequestBody DocumentDtoWithoutId documentDtoWithoutId){
        DocumentDto documentDto = documentServiceQuerydslImp.save(documentDtoWithoutId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(documentDto);
    }

    @PutMapping
    public ResponseEntity<DocumentDto> update(@Valid @RequestBody DocumentDto documentDto){
        documentServiceQuerydslImp.update(documentDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(documentDto);
    }

}
