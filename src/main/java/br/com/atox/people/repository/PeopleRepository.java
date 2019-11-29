package br.com.atox.people.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.atox.people.entity.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {


	Optional<People> findOneByLegalDocumentNumber(String legalDocumentNumber); 

}
