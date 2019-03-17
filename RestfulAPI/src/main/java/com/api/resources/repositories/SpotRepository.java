package com.api.resources.repositories;

import com.api.resources.entities.Spot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "Spot", path = "spot")
public interface SpotRepository extends CrudRepository<Spot, Integer> {

}
