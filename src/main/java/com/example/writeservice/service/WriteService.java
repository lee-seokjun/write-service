package com.example.writeservice.service;

import com.example.writeservice.dto.WriteDto;
import com.example.writeservice.jap.WriteEntity;

public interface WriteService {
    WriteDto createWrite(WriteDto writeDto);
    Iterable<WriteEntity> getWritesByUserId(String userId);
    WriteEntity getWriteByWriteId(String writeId);
    Iterable<WriteEntity> getAllWrites();
}
