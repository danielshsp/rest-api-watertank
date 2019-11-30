package com.codevalue.rest.facade;

import com.codevalue.rest.entities.TankEntity;
import com.codevalue.rest.service.TankService;
import com.codevalue.restserver.dto.Tank;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
@AllArgsConstructor
public class TankFacadeimpl implements TankFacade {

    private final TankService tankService;
    @Override
    public List<TankEntity> all() {
        return tankService.all();
    }

    @Override
    public Tank maxTankCapacity() {
        return tankService.maxTankCapacity();
    }

    @Override
    public Tank currentTankCapacity() {
        return tankService.currentTankCapacity();
    }

    @Override
    public boolean updateTankCapacity(Integer capacity) {
        Tank tankDTO = tankService.updateTankCapacity(capacity);
        if(tankDTO != null ){
            return true;
        }
        return false;
    }

    //Init 0-9 tanks with 50 liter of water
    @Async("threadPoolTaskExecutor")
    //@PostConstruct
    public CompletableFuture<Tank> startupTanks() throws InterruptedException {
        TankEntity tank = null;
        log.info("Start - add the tanks");
        for (int i =0; i<10;i++){
            tank = new TankEntity();
            tank.setTankId(0+i);
            tank.setCapacity(50);
            tankService.save(tank);
        }
        ModelMapper modelMapper = new ModelMapper();
        Tank tankDTO = modelMapper.map(tank,Tank.class);
        // Artificial delay of 1s for terminated the thread
        Thread.sleep(1000L);
        return CompletableFuture.completedFuture(tankDTO);

    }

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<Void> deleteCapacityOfTank(Integer capacity) throws InterruptedException {
        int i = 1;
        while (i > 0){
            log.info("Begin - delete liter from the tanks" );
            // Artificial delay of 1m for tank logic purposes
            Thread.sleep(60000L);
            Tank tankDTO = tankService.updateTankCapacity(capacity);
            log.info("finish - delete liter from the tanks" );
            if(tankDTO != null)
                i++;
            else
                i=0;
        }
        return CompletableFuture.completedFuture(null);
    }
}
