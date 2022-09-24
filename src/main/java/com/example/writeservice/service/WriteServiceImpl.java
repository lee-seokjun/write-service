package com.example.writeservice.service;

import com.example.writeservice.dto.WriteDto;
import com.example.writeservice.jap.WriteEntity;
import com.example.writeservice.jap.WriteRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class WriteServiceImpl implements WriteService{
    WriteRepository writeRepository;

    public WriteServiceImpl(WriteRepository writeRepository) {
        this.writeRepository = writeRepository;
    }

    @Override
    public WriteDto createWrite(WriteDto writeDto) {
        writeDto.setWriteId(UUID.randomUUID().toString());
        ModelMapper mapper= new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        WriteEntity writeEntity = mapper.map(writeDto,WriteEntity.class);
        writeRepository.save(writeEntity);
        WriteDto returnValue = mapper.map(writeEntity,WriteDto.class);
        log.info(String.valueOf(writeRepository.findById(writeEntity.getId())));

        return returnValue;
    }

    @Override
    public Iterable<WriteEntity> getWritesByUserId(String userId) {
        return writeRepository.findByUserId(userId);
    }
    @Override
    public Iterable<WriteEntity> getAllWrites() {
        return writeRepository.findAll();
    }

    @Override
    public WriteEntity getWriteByWriteId(String writeId) {
        return writeRepository.findByWriteId(writeId);
    }
}
