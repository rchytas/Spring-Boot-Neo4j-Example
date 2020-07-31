package com.rchytas.neo4j.demo.repository;

import java.util.Collection;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.rchytas.neo4j.demo.model.Drug;


public interface DrugRepository extends Neo4jRepository<Drug, Long>{
	
    @Query("MATCH p=()-[r:PRESCRIBED]->() RETURN p LIMIT 25")
    Collection<Drug> getAllDrugs();

}
