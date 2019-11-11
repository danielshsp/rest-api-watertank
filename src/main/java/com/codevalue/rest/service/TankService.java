package com.codevalue.rest.service;

import com.codevalue.rest.entities.TankEntity;
import com.codevalue.rest.persistence.TankRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TankService {
    private final TankRepository tankRepository;

    public List<TankEntity> all(){
        return tankRepository.findAll();
    }

}
