package com.codevalue.rest.persistence;

import com.codevalue.rest.entities.TankQL;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TankRepositoryQL extends MongoRepository<TankQL,String> {
}
