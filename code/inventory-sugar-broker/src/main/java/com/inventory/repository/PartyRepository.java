
package com.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.entity.Party;

@Repository 
public interface PartyRepository extends JpaRepository<Party,Integer> {  
}
	