
package com.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.entity.Party;
import com.inventory.repository.PartyRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j 
public class PartyService {

	@Autowired 
	public PartyRepository partyRepository;

	public Party createParty(Party party) { 
		System.out.println("Repo :  Factory : "+party);
		return partyRepository.save(party);
	}

}
