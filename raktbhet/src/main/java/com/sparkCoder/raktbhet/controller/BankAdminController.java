package com.sparkCoder.raktbhet.controller;

import com.sparkCoder.raktbhet.dto.BankAdminDto;
import com.sparkCoder.raktbhet.service.BankAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/admin")
public class BankAdminController {

        @Autowired
        private BankAdminService service;
        Logger logs= LoggerFactory.getLogger(BankAdminController.class);


        @PostMapping("/adminreg")

        public ResponseEntity<BankAdminDto> register( @Validated  @RequestBody BankAdminDto dto)
        {
            BankAdminDto msg=service.register(dto);
            logs.info("The admin data is resive");
            return new ResponseEntity<>(msg, HttpStatus.CREATED);
        }

        @GetMapping("/{id}")
        public ResponseEntity<BankAdminDto> getById( @Validated @PathVariable Integer id)
        {
            logs.info("The admin data is resive");
            return  new ResponseEntity<>(service.getById(id),HttpStatus.OK);
        }

        @PutMapping("update/{id}")
        public ResponseEntity<String> update(  @Validated @PathVariable Integer id, @RequestBody BankAdminDto dto)
        {
            logs.info("The admin data is resive");
            String msg=service.update(id, dto);
            return new ResponseEntity<>(msg, HttpStatus.OK);
        }

        @DeleteMapping("delete/{id}")
        public ResponseEntity<String> delete( @Validated @PathVariable Integer id)
        {
            logs.info("The admin data is resive");
            return new ResponseEntity<String>(service.delete(id),HttpStatus.OK);
        }
    }

