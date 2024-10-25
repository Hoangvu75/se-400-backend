package com.example.multimodule.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.multimodule.application.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
