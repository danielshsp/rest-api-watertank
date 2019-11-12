package com.codevalue.rest.service;

import com.codevalue.rest.facade.TankFacade;
import com.codevalue.restserver.dto.Tank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class StartupService implements CommandLineRunner {

    @Autowired
    TankFacade tankFacade;

    @Override
    public void run(String...args) throws Exception {
        CompletableFuture<Tank> page1 = tankFacade.startupTanks();
        CompletableFuture<Void> page2 = tankFacade.deleteCapacityOfTank(0);
        // Wait until they are all done
        CompletableFuture.allOf(page1);
        System.out.println("get data from async method" +page1.get());



    }
}
