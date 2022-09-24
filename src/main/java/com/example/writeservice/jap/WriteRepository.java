package com.example.writeservice.jap;

import org.springframework.data.repository.CrudRepository;

public interface WriteRepository extends CrudRepository<WriteEntity,Long> {
    Iterable<WriteEntity> findByUserId(String userId);
    WriteEntity findByWriteId(String userId);
}
