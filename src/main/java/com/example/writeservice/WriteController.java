package com.example.writeservice;

import com.example.writeservice.dto.WriteDto;
import com.example.writeservice.jap.WriteEntity;
import com.example.writeservice.service.WriteService;
import com.example.writeservice.vo.RequestWrite;
import com.example.writeservice.vo.ResponseWrite;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
@Slf4j
public class WriteController {

    WriteService writeService;

    public WriteController(WriteService writeService) {
        this.writeService = writeService;
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "hello";
    }

    @PostMapping("/{userId}/write")
    public ResponseEntity<ResponseWrite> createWrite(@PathVariable String userId, @RequestBody RequestWrite requestWrite){
        WriteDto writeDto = new ModelMapper().map(requestWrite,WriteDto.class);
        writeDto.setUserId(userId);
        WriteDto createdWrite = writeService.createWrite(writeDto);

        ResponseWrite responseWrite = new ModelMapper().map(createdWrite,ResponseWrite.class);
        log.info(userId);


        return ResponseEntity.status(HttpStatus.CREATED).body(responseWrite);
    }

    @GetMapping("/{userId}/write")
    public ResponseEntity<List<ResponseWrite>> getAllWrite(@PathVariable String userId){

//        Iterable<WriteEntity> writeEntities = writeService.getWritesByUserId(userId);
        Iterable<WriteEntity> writeEntities = writeService.getAllWrites();
        List<ResponseWrite> responseWriteList = new ArrayList<>();

        writeEntities.forEach(
                (v) -> {
                    responseWriteList.add(new ModelMapper().map(v,ResponseWrite.class));
                }
        );

        return ResponseEntity.status(HttpStatus.OK).body(responseWriteList);
    }
    @GetMapping("/{userId}/write/{writeId}")
    public ResponseEntity<ResponseWrite> getMyWrite(@PathVariable String userId, @PathVariable String writeId){

        WriteEntity writeEntitie = writeService.getWriteByWriteId(writeId);
        ResponseWrite result = new ModelMapper().map(writeEntitie,ResponseWrite.class);



        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
