package com.bulletinboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bulletinboard.entity.Bulletinboard;

public interface BulletinboardRepository extends JpaRepository<Bulletinboard, Integer>{
    public void deleteById(int id);
    public Bulletinboard findById(int id);
}
