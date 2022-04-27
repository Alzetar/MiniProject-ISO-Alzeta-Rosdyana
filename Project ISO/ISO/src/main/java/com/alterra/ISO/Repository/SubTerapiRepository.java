package com.alterra.ISO.Repository;

import com.alterra.ISO.Model.SubEfekTerapi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubTerapiRepository extends CrudRepository<SubEfekTerapi, Integer> {
}
