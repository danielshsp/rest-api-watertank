package com.codevalue.rest.service;

import com.codevalue.rest.entities.TankEntity;
import com.codevalue.rest.persistence.TankRepository;
import com.codevalue.restserver.dto.Tank;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
@AllArgsConstructor
public class TankService {
    private final TankRepository tankRepository;

    public void save(TankEntity tank){
        tankRepository.save(tank);
    }

    public List<Tank> all(){
        List<TankEntity> tankEntity =  tankRepository.findAll();
        Type listType = new TypeToken<List<Tank>>() {}.getType();
        List<Tank> tanklist = new ModelMapper().map(tankEntity, listType);
        return  tanklist;
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

    public synchronized Tank updateTankCapacity(Integer capacity){
        List<TankEntity> tankEntity = tankRepository.findAll();
        TankEntity tank = null;
        int capicityFlag = 0;
        for( TankEntity tanks: tankEntity){
            if (tanks.getCapacity() + capacity <= 50 && capacity > 0) {
                     tanks.setCapacity(tanks.getCapacity() + capacity);
                     tank = tankRepository.save(tanks);
            }else if (tanks.getCapacity() + capacity > 50 && capacity > 0) {
                        capicityFlag = 1;
            }else{
                     tanks.setCapacity(tanks.getCapacity() -1);
                     tank = tankRepository.save(tanks);
            }
        }
        Tank tankDTO;
        if (capicityFlag == 1 ){
                 tankDTO = null;
        }else {
                ModelMapper modelMapper = new ModelMapper();
                tankDTO = modelMapper.map(tank, Tank.class);
        }
        return tankDTO;
    }

}
