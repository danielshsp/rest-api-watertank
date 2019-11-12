package com.codevalue.rest.persistence;

import com.codevalue.rest.entities.TankEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomRepository {
    TankEntity maxTankCapacity();
    TankEntity currentTankCapacity();
}
