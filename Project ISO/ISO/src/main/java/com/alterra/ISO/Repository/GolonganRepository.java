package com.alterra.ISO.Repository;

import com.alterra.ISO.Model.GolonganObat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GolonganRepository extends JpaRepository<GolonganObat, Integer> {
}
