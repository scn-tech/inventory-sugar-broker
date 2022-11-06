
package com.inventory.repository;

import com.inventory.entity.Party;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository 
public interface PartyRepository extends PagingAndSortingRepository<Party,Integer> {
    List<Party> findByDeletedFlag(boolean deletedFlag);
}
	