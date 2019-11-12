package com.codevalue.rest.service;

import com.codevalue.rest.entities.TankEntity;
import com.codevalue.rest.persistence.TankRepository;
import com.codevalue.restserver.dto.Tank;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TankService {
    private final TankRepository tankRepository;

    public void save(TankEntity tank){
        tankRepository.save(tank);
    }
    public List<TankEntity> all(){
        return tankRepository.findAll();
    }

    public Tank maxTankCapacity(){
        TankEntity tankEntity = tankRepository.maxTankCapacity();
        ModelMapper modelMapper = new ModelMapper();
        Tank tankDTO = modelMapper.map(tankEntity, Tank.class);
        return tankDTO;
    }

    public Tank currentTankCapacity(){
        TankEntity tankEntity = tankRepository.currentTankCapacity();
        ModelMapper modelMapper = new ModelMapper();
        Tank tankDTO = modelMapper.map(tankEntity, Tank.class);
        return tankDTO;
    }

    public Tank updateTankCapacity(Integer capacity){
        List<TankEntity> tankEntity = tankRepository.findAll();
        TankEntity tank = null;
        for( TankEntity tanks: tankEntity){
            if (tanks.getCapacity() + capacity <= 50) {
                tanks.setCapacity(tanks.getCapacity() + capacity);
                 tank= tankRepository.save(tanks);
            }
        }
        ModelMapper modelMapper = new ModelMapper();
        Tank tankDTO = modelMapper.map(tank,Tank.class );
        return tankDTO;
    }

}
