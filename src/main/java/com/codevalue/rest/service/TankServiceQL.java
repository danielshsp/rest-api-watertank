package com.codevalue.rest.service;

import com.codevalue.rest.entities.TankQL;
import com.codevalue.rest.persistence.TankRepositoryQL;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@GraphQLApi
public class TankServiceQL {
    private final TankRepositoryQL tankRepository;

    @GraphQLQuery(name = "tanks")
    public List<TankQL> getTanks() {
        return tankRepository.findAll();
    }

    @GraphQLQuery(name = "tank")
    public Optional<TankQL> getTankById(@GraphQLArgument(name = "id") String id) {
        return tankRepository.findById(id);
    }

    @GraphQLMutation(name = "saveTank")
    public TankQL saveTank(@GraphQLArgument(name = "tankQL") TankQL tankQL) {
        return tankRepository.save(tankQL);
    }

    @GraphQLMutation(name = "deleteTank")
    public void deleteTank(@GraphQLArgument(name = "id") String id) {
        tankRepository.deleteById(id);
    }
}
