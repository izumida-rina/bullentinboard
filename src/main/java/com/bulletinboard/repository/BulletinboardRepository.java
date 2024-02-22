package com.bulletinboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bulletinboard.entity.Bulletinboard;

public interface BulletinboardRepository extends JpaRepository<Bulletinboard, Integer>{
    public void deleteById(int id);
    public Bulletinboard findById(int id);
    public List<Bulletinboard> findByTitleContaining(String keyword);
}
