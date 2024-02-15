package com.bulletinboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bulletinboard.entity.Users;

public interface UserRepository extends JpaRepository<Users, String>{

}
