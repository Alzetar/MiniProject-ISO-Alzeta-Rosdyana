package com.alterra.ISO.Repository;

import com.alterra.ISO.Model.EfekTerapi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerapiRepository extends JpaRepository<EfekTerapi, Integer> {
}
