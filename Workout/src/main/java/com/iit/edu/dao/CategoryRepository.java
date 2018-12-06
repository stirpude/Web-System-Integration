package com.iit.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iit.edu.model.Category;

/**
 *
 * @author shruti
 * The CategoryRepository is an interface that extends to JpaRepository
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
