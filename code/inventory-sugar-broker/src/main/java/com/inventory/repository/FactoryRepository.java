
package com.inventory.repository;

import com.inventory.entity.Factory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository 
public interface FactoryRepository extends PagingAndSortingRepository<Factory,Integer> {

    List<Factory> findByDeletedFlag(boolean deletedFlag);
}
	