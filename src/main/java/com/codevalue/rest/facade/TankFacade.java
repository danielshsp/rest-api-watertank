package com.codevalue.rest.facade;

import com.codevalue.rest.entities.TankEntity;
import com.codevalue.restserver.dto.Tank;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public interface TankFacade {
     List<TankEntity> all();
     Tank maxTankCapacity();
     Tank currentTankCapacity();
     boolean updateTankCapacity(Integer capacity);
     CompletableFuture<Void> deleteCapacityOfTank(Integer capacity) throws InterruptedException;
     CompletableFuture<Tank> startupTanks() throws InterruptedException;
}
