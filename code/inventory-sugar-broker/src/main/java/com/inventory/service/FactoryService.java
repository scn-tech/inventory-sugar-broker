
package com.inventory.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inventory.entity.Factory;
import com.inventory.repository.FactoryRepository;
import lombok.extern.slf4j.Slf4j;

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
}
