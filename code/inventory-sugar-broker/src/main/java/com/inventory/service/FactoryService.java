
package com.inventory.service;

import com.inventory.entity.Factory;
import com.inventory.repository.FactoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
		return factoryRepository.findAll();
	}

	public List<Factory> getByFlag(boolean flag) {
		return factoryRepository.findByDeletedFlag(flag);
	}
}
