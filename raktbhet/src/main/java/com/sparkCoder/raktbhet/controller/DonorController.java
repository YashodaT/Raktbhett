package com.sparkCoder.raktbhet.controller;

import com.sparkCoder.raktbhet.dto.DonorReqDto;
import com.sparkCoder.raktbhet.dto.DonorResDto;
import com.sparkCoder.raktbhet.service.DonorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/donors")
public class DonorController {

        private final DonorService donorService;
    Logger logs= LoggerFactory.getLogger(BloodBnakController.class);


    public DonorController(DonorService donorService) {
            this.donorService = donorService;
        }

        @PostMapping
        public ResponseEntity<?> createDonor(@RequestBody DonorReqDto req) {
            logs.info("The data is get from createDonor() endPoint");
            try {
                DonorResDto created = donorService.createDonor(req);
                URI location = URI.create(String.format("/donors/%s", created.getDonorId()));
                return ResponseEntity.created(location).body(created);
            } catch (IllegalArgumentException ex) {
                return ResponseEntity.badRequest().body(ex.getMessage());
            }
        }

        @GetMapping("/{id}")
        public ResponseEntity<DonorResDto> getById(@PathVariable("id") String id) {
            logs.info("The id is get from getById() endPoint");
            return donorService.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

        @GetMapping("/by-email")
        public ResponseEntity<DonorResDto> getByEmail(@RequestParam("email") String email) {
            logs.info("The getByEmail()  endPoint is called");
            return donorService.findByEmail(email).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

        @GetMapping("/raktbhet/{raktbhetId}")
        public ResponseEntity<DonorResDto> getByRaktbhet(@PathVariable("raktbhetId") Integer raktbhetId) {
            logs.info("The raktbhetNubmer  is get from getByRektbhet() endPoint");
            return donorService.findByRaktbhetId(raktbhetId).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

        @GetMapping("/blood/{bloodGrp}")
        public ResponseEntity<List<DonorResDto>> getByBloodGrp(@PathVariable("bloodGrp") String bloodGrp) {
            logs.info("The bloodGrp is get from getByBloodGrp() endPoint");
            List<DonorResDto> list = donorService.findByBloodGrp(bloodGrp);
            return ResponseEntity.ok(list);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteById(@PathVariable("id") String id) {
            logs.info("The id is get from deleteById() endPoint");
            donorService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
    }

