package com.codevalue.rest.entities;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tank" )
@Data
public class TankQL {
    @Id
    @GraphQLQuery(name = "id", description = "A object id")
    private String id;
    @GraphQLQuery(name = "tankId", description = "A thank's id")
    private Integer tankId;
    @GraphQLQuery(name = "capacity", description = "A capacity tank")
    private Integer capacity;
}
