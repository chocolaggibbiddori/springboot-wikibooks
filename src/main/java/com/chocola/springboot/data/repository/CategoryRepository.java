package com.chocola.springboot.data.repository;

import com.chocola.springboot.data.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
