package com.Alterra.ISO.Repository;

import com.Alterra.ISO.Model.SubEfekTerapi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubEfekTerapiRepository extends JpaRepository<SubEfekTerapi, Integer> {
}