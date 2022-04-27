package com.alterra.ISO.Repository;

import com.alterra.ISO.Model.EfekTerapi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerapiRepository extends CrudRepository<EfekTerapi, Integer> {
}
