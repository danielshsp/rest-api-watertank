package com.codevalue.rest.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tank" )
@Data
public class TankEntity {
    @Id
    private String id;
    private String name;
}
