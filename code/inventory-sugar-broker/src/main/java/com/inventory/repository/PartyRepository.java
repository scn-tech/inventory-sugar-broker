
package com.inventory.repository;

import com.inventory.entity.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository 
public interface PartyRepository extends JpaRepository<Party,Integer> {
    List<Party> findByDeletedFlag(boolean deletedFlag);
}
	