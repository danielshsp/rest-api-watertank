package com.codevalue.rest.web;

import com.codevalue.rest.entities.TankEntity;
import com.codevalue.rest.service.TankService;
import com.codevalue.restserver.api.TankApi;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TankController implements TankApi {
    private final TankService tankService;

    @GetMapping("/tank/all")
    public List<TankEntity> all(){
        return tankService.all();
    }

}
