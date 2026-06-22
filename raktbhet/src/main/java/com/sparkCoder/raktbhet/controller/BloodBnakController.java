package com.sparkCoder.raktbhet.controller;

import com.sparkCoder.raktbhet.dto.BloodBankDto;
import com.sparkCoder.raktbhet.service.BloodBankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class BloodBnakController
{

    @RestController
    @RequestMapping("/blood-bank")
    public class BloodBankController {

        @Autowired
        private BloodBankService service;
        Logger logs= LoggerFactory.getLogger(BloodBnakController.class);


        @PostMapping("/save")
        public BloodBankDto save(@RequestBody BloodBankDto dto)
        {
            logs.info("The data is come form SaveMethod");
            return service.save(dto);
        }


        @GetMapping("/{id}")
        public BloodBankDto getById(@PathVariable Integer id) {
            logs.info("The Id come form GetById endpoint");
            return service.getById(id);
        }

        @PutMapping("/{id}")
        public BloodBankDto update(@PathVariable Integer id,@RequestBody BloodBankDto dto) {
            logs.info("The id and info is come from update endpoint from update data");
            return service.update(id, dto);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<String> delete(@PathVariable Integer id) {
            logs.info("The is come from delete endpoint from Delete");
            return service.delete(id);
        }
    }
}
