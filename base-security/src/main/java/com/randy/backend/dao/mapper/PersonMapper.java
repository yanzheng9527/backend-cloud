package com.randy.backend.dao.mapper;

import com.randy.backend.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonMapper {

  List<Person> getAll();

  Person getOne(String name);

  void insert(Person person);

  void update(Person person);

  void delete(String name);
}
