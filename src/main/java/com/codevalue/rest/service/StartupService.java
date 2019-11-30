package com.codevalue.rest.service;

import com.codevalue.rest.facade.TankFacade;
import com.codevalue.restserver.dto.Tank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class StartupService implements CommandLineRunner {

    @Autowired
    TankFacade tankFacade;

    @Override
    public void run(String...args) throws Exception {
        //Init the tank
        CompletableFuture<Tank> page1 = tankFacade.startupTanks();
        CompletableFuture.anyOf(page1);
        log.info("tank data:" +page1.get());
        //schedule delete for water tank
        CompletableFuture<Void> page2 = tankFacade.deleteCapacityOfTank(0);
        // Block and wait for the future to complete
        CompletableFuture.anyOf(page2);
       // page2.get();


    }
}
