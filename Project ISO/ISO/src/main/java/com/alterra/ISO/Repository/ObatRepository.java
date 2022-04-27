package com.alterra.ISO.Repository;

import com.alterra.ISO.Model.Obat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObatRepository extends JpaRepository<Obat, Integer> {
}
