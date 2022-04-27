package com.alterra.ISO.Repository;

import com.alterra.ISO.Model.ObatGenerik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenerikRepository extends JpaRepository<ObatGenerik, Integer> {
}
