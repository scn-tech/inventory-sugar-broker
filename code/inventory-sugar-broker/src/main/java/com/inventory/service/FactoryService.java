
package com.inventory.service;

import com.inventory.entity.Factory;
import com.inventory.repository.FactoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j 
public class FactoryService {

	@Autowired 
	public FactoryRepository factoryRepository;

	public Factory createFactory(Factory factory) { 
		System.out.println("Repo :  Factory : "+factory);
		return factoryRepository.save(factory);
	}

	public List<Factory>  getListOfFactory(){
		return StreamSupport
				.stream(factoryRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}

	public List<Factory> getByFlag(boolean flag) {
		return factoryRepository.findByDeletedFlag(flag);
	}

	public Page<Factory> getAllFactoryByPageable(Pageable paging) {
		return factoryRepository.findAll(paging);
	}
}
