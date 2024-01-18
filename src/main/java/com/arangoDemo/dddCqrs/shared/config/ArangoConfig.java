package com.arangoDemo.dddCqrs.shared.config;

import com.arangodb.ArangoDB;
import com.arangodb.springframework.annotation.EnableArangoRepositories;
import com.arangodb.springframework.config.ArangoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableArangoRepositories(basePackages = {"com.arangoDemo.dddCqrs"})
public class ArangoConfig implements ArangoConfiguration {

    @Override
    public ArangoDB.Builder arango() {
        return new ArangoDB.Builder()
                .host("localhost", 8529)
//                .useProtocol(Protocol.HTTP_JSON)
                .user("root").password(null);
    }

    @Override
    public String database() {
        return "dddCqrsDB";
    }
}
