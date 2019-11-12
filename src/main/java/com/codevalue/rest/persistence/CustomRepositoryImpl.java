package com.codevalue.rest.persistence;

import com.codevalue.rest.entities.TankEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.TypedSort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

public class CustomRepositoryImpl implements CustomRepository {

    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public TankEntity maxTankCapacity() {
        Query query = new Query();
        query.with(TypedSort.by("capacity").descending());
        query.limit(1);
        return mongoTemplate.findOne(query, TankEntity.class);

    }

    @Override
    public TankEntity currentTankCapacity() {
        Query query = new Query();
        query.limit(1);
        return mongoTemplate.findOne(query, TankEntity.class);
    }
}
