
package com.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.entity.Factory;

@Repository 
public interface FactoryRepository extends JpaRepository<Factory,Integer> {  
}
	