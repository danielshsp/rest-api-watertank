package com.codevalue.rest.web;

import com.codevalue.rest.entities.TankEntity;
import com.codevalue.rest.facade.TankFacade;
import com.codevalue.rest.service.TankService;
import com.codevalue.restserver.api.TankApi;

import com.codevalue.restserver.dto.Tank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TankController implements TankApi {
    private final TankFacade tankFacade;

    @GetMapping("/tank/all")
    public List<TankEntity> all(){
        return tankFacade.all();
    }

    public ResponseEntity<Tank> findCurrentTank() {
        return ResponseEntity.ok(tankFacade.currentTankCapacity());
    }
    public ResponseEntity<Tank> findMaxTankCapacity() {
        return ResponseEntity.ok(tankFacade.maxTankCapacity());
    }
    public ResponseEntity<Tank> updateTankCapacity(Integer capacity) {

        return new ResponseEntity(tankFacade.updateTankCapacity(capacity), HttpStatus.ACCEPTED);
    }


}
