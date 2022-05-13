package com.Alterra.ISO.Repository;

import com.Alterra.ISO.Model.GolonganObat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GolonganObatRepository extends JpaRepository<GolonganObat, Integer> {
}