package com.mitocode;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.mitocode.person;


@Repository
public interface PersonRepository {

	List<person> findByName(@Param("nombre") String nombre);

	List<person> findAll();

	person save(person person);

	void deleteById(Long id);
	
}
