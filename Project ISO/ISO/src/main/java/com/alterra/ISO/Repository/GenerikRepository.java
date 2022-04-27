package com.alterra.ISO.Repository;

import com.alterra.ISO.Model.ObatGenerik;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenerikRepository extends CrudRepository<ObatGenerik, Integer> {
}
