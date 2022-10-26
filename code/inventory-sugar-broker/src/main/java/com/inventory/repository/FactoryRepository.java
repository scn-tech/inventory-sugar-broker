
package com.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.entity.Factory;

import java.util.List;

@Repository 
public interface FactoryRepository extends JpaRepository<Factory,Integer> {

    public List<Factory> findByDeletedFlag(boolean deletedFlag);
}
	