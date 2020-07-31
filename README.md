# Drug-Condition Graph Project

This example is for visualizing drug(s) and condition(s) its prescribed for using Neo4j + Spring Boot Integration.  Provides following REST API -

- `GET - /graph/neo4j/drugs` returns the list of Drugs from the Neo4j Instance running as a Docker container

## Technologies explored
    Docker
    Neo4j - Docker Container, Bolt Driver, Spring Boot Integration
    Spring Boot
    REST API

## Neo4J 
- Docker command to bring up Neo4J server
```
docker run --publish=7474:7474 --publish=7687:7687 neo4j:latest
```
- Neo4J Browser URL
```
http://localhost:7474/browser
```

## Cypher Queries for Neo4J
- Creation of Drug and Condition nodes:

```
CREATE (Asthma:Condition {name: 'Asthma', symptom: 'Shortness of Breath'})
CREATE (Diabetes:Condition {name: 'Diabetes', symptom: 'Fatigue'})
CREATE (Amevive:Drug {name: 'Amevive', therapeuticArea: 'Diabetes', activeIngredient: 'Pixie Dust'})
CREATE (Ketoconazole:Drug {name: 'Ketoconazole', therapeuticArea: 'Diabetes and COPD', activeIngredient: 'Benzoid Sulphur'})
CREATE (Tacrolimus:Drug {name: 'Tacrolimus', therapeuticArea: 'Asthma and Multiple Sclerosis', activeIngredient: 'Propylene glycol'})

MATCH (a:Drug),(b:Condition)
WHERE a.name = 'Amevive' AND b.name = 'Asthma'
CREATE (a)-[r:PRESCRIBED {dose: 2}]->(b)
RETURN type(r)

MATCH (a:Drug),(b:Condition)
WHERE a.name = 'Amevive' AND b.name = 'Diabetes'
CREATE (a)-[r:PRESCRIBED {dose: 3}]->(b)
RETURN type(r)

MATCH (a:Drug),(b:Condition)
WHERE a.name = 'Ketoconazole' AND b.name = 'Diabetes'
CREATE (a)-[r:PRESCRIBED {dose: 2}]->(b)
RETURN type(r)

MATCH (a:Drug),(b:Condition)
WHERE a.name = 'Ketoconazole' AND b.name = 'Asthma'
CREATE (a)-[r:PRESCRIBED {dose: 4}]->(b)
RETURN type(r)
;
```
- Adding new relationship

```
MATCH (a:Drug),(b:Condition)
WHERE a.name = 'Tacrolimus' AND b.name = 'Asthma'
CREATE (a)-[r:PRESCRIBED {dose: 6}]->(b)
RETURN type(r)
;
```

## Neo4j - broweser console
![Alt text](neo4j.png?raw=true "neo4j")

## Drug Graph REST Response

![Alt text](rest_response.png?raw=true "Drug Graph")
