package com.api.resources.repositories;

import com.api.resources.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "User", path = "user")
public interface UserRepository extends CrudRepository<User, Integer> {
    
}
