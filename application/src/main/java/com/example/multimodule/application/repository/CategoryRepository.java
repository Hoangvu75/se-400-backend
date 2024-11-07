package com.example.multimodule.application.repository;

import com.example.multimodule.application.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

}
