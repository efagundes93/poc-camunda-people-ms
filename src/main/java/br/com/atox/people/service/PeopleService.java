package br.com.atox.people.service;

import static java.time.LocalDateTime.now;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.atox.people.entity.People;
import br.com.atox.people.entity.builder.PeopleBuilder;
import br.com.atox.people.repository.PeopleRepository;

@Service
public class PeopleService{


	private final PeopleRepository peopleRepository;
	 
	public PeopleService(PeopleRepository peopleRepository) {
		
		this.peopleRepository = peopleRepository;
	}

	/**
	 *  
	 * @param legalDocumentNumber
	 * @return people
	 */
	public People create(People people) {
				
		//TODO implementar fluxo de controle para evitar duplicidades.
		
		return 	this.peopleRepository.findOneByLegalDocumentNumber(people.getLegalDocumentNumber())
																		.orElse( this.peopleRepository.save(new PeopleBuilder(people)
																																		.withUpdateAt(now())
																																		.build()));

	}
	
	
	/**
	 *  save people
	 * @param legalDocumentNumber
	 * @return people
	 */
	public People save(People people) {
				
		
		return 	this.peopleRepository.save(new PeopleBuilder(people)
														.withUpdateAt(now())
														.build());

	}
	

	public People  getOne(Long id) {
		
		return 	this.peopleRepository.findById(id).orElse(null);

	}
	
	public Optional<People> getByLegalDocumentNumber(String legalDocumentNumber) {
		
		return 	this.peopleRepository.findOneByLegalDocumentNumber(legalDocumentNumber);
	}	
	
	public List<People> getAll(){
		return this.peopleRepository.findAll();
	}
}
