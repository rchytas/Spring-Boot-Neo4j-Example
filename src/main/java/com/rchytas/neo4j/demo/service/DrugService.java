package com.rchytas.neo4j.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rchytas.neo4j.demo.model.Drug;
import com.rchytas.neo4j.demo.repository.DrugRepository;

@Service
public class DrugService {
	
	@Autowired
	DrugRepository drugRepository;
	
	public Collection<Drug> getAll() {
		return drugRepository.getAllDrugs();
		
	}
}
