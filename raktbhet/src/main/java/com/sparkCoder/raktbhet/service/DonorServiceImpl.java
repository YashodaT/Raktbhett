package com.sparkCoder.raktbhet.service;

import com.sparkCoder.raktbhet.controller.BloodBnakController;
import com.sparkCoder.raktbhet.dto.DonorReqDto;
import com.sparkCoder.raktbhet.dto.DonorResDto;
import com.sparkCoder.raktbhet.entity.DonorEntity;
import com.sparkCoder.raktbhet.mapper.DonorMapper;
import com.sparkCoder.raktbhet.repository.DonorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@Transactional
public class DonorServiceImpl implements DonorService {

        private final DonorRepository donorRepository;
        private final DonorMapper donorMapper;
    Logger logs= LoggerFactory.getLogger(BloodBnakController.class);


    @Autowired
        public DonorServiceImpl(DonorRepository donorRepository, DonorMapper donorMapper) {
            this.donorRepository = donorRepository;
            this.donorMapper = donorMapper;
        }


       /* public DonorServiceImpl(DonorRepository donorRepository, DonorMapper donorMapper) {
            this.donorRepository = donorRepository;
            this.donorMapper = donorMapper;
        }*/

        @Override
        public DonorResDto createDonor(DonorReqDto createDTO) {
            logs.info("CreatingDonor() of DonerService called");
            if (createDTO == null) throw new IllegalArgumentException("createDTO must not be null");
            if (createDTO.getEmail() != null && donorRepository.existsByEmail(createDTO.getEmail())) {
                throw new IllegalArgumentException("Email already registered");
            }

            DonorEntity entity = donorMapper.toEntityFromCreate(createDTO);
            // Password is stored as provided (no encryption) per request

            // Ensure raktbhetId is set: if not provided, generate next available number
            if (entity.getRaktbhetId() == null) {
                Optional<DonorEntity> top = donorRepository.findTopByOrderByRaktbhetIdDesc();
                int next = 1;
                if (top.isPresent() && top.get().getRaktbhetId() != null) {
                    next = top.get().getRaktbhetId() + 1;
                }
                entity.setRaktbhetId(next);
            }

            DonorEntity saved = donorRepository.save(entity);
            return donorMapper.toDto(saved);
        }

        @Override
        public Optional<DonorResDto> findById(String donorId) {
            logs.info("findById() of DonerService called");
            return donorRepository.findById(donorId).map(donorMapper::toDto);
        }

        @Override
        public Optional<DonorResDto> findByEmail(String email) {
            logs.info("findByEmail() of DonerService called");
            return donorRepository.findByEmail(email).map(donorMapper::toDto);
        }

        @Override
        public Optional<DonorResDto> findByRaktbhetId(Integer raktbhetId) {
            logs.info("findByRaktbhetId() of DonerService called");
            return donorRepository.findByRaktbhetId(raktbhetId).map(donorMapper::toDto);
        }

        @Override
        public List<DonorResDto> findByBloodGrp(String bloodGrp) {
            logs.info("findByBloodGrp() of DonerService called");
            return donorRepository.findByBloodGrp(bloodGrp).stream().map(donorMapper::toDto).collect(Collectors.toList());
        }

        @Override
        public void deleteById(String donorId) {
            logs.info("deleteById() of DonerService called");
            donorRepository.deleteById(donorId);
        }
    }






