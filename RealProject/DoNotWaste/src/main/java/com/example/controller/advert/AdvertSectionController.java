package com.example.controller.advert;

import com.example.dto.advert.AdvertSectionCreationDTO;
import com.example.dto.advert.AdvertSectionGetDTO;
import com.example.enums.Language;
import com.example.service.AdvertSectionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Alisher Odilov
 * Date: 21.06.2023
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/advertSection")
public class AdvertSectionController {

    private final AdvertSectionService advertSectionService;
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody AdvertSectionCreationDTO dto,
                                    @RequestHeader(value = "Accept-Language") Language language){
        log.info("create AdvertSectionCreationDTO  -> ", dto);
        AdvertSectionCreationDTO result=advertSectionService.create(dto, language);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody AdvertSectionCreationDTO dto, @PathVariable("id") Integer id,
                                    @RequestHeader(value = "Accept-Language") Language language){
        log.info("update advertSection by id: {}", id);
        AdvertSectionCreationDTO result=advertSectionService.update(dto,id,language);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id,
                                        @RequestHeader(value = "Accept-Language") Language language){
        log.info(" delete advertSection by Id: {}", id);
      Boolean result=advertSectionService.deleteById(id, language);
      return ResponseEntity.ok(result);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id,
                                     @RequestHeader(value = "Accept-Language") Language language){
        log.info("get AdvertSection by id: {}", id);
        AdvertSectionGetDTO result=advertSectionService.getById(id, language);
        return ResponseEntity.ok(result);
    }

}

