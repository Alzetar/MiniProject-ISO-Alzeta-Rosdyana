package com.alterra.ISO.Repository;

import com.alterra.ISO.Model.GolonganObat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GolonganRepository extends CrudRepository<GolonganObat, Integer> {
}
