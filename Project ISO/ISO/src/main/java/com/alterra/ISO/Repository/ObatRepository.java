package com.alterra.ISO.Repository;

import com.alterra.ISO.Model.Obat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObatRepository extends CrudRepository<Obat, Integer> {
}
