package com.codevalue.rest.persistence;

import com.codevalue.rest.entities.TankEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TankRepository extends MongoRepository<TankEntity,String> {
}
