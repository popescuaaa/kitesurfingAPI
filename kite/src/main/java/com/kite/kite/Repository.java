package com.kite.kite;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface Repository extends CrudRepository<Entry, Integer> {

}
