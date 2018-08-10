package com.example.rikuquiz.repository;

import com.example.rikuquiz.domain.Riku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RikuRepository extends JpaRepository<Riku, Long> {
}