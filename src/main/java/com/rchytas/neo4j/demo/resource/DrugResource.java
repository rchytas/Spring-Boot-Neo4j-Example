package com.rchytas.neo4j.demo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rchytas.neo4j.demo.model.Drug;
import com.rchytas.neo4j.demo.service.DrugService;

import java.util.Collection;

@RestController
@RequestMapping("/graph/neo4j/drugs")
public class DrugResource {

	@Autowired
	DrugService drugService;

	@GetMapping
	public Collection<Drug> getAll() {
		return drugService.getAll();
	}

}
