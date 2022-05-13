package com.Alterra.ISO.Repository;

import com.Alterra.ISO.Model.ObatGenerik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObatGenerikRepository extends JpaRepository<ObatGenerik, Integer> {
}