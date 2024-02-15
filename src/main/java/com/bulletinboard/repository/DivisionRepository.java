package com.bulletinboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bulletinboard.entity.Division;

public interface DivisionRepository extends JpaRepository<Division, Integer>{
    public Division findById(int id);
}
