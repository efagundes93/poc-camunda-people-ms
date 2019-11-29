package br.com.atox.people.entity.builder;

import static br.com.atox.people.utils.RandomUtils.generateDate;
import static br.com.atox.people.utils.RandomUtils.generateEmail;
import static br.com.atox.people.utils.RandomUtils.generateLegalDocumentNumber;
import static br.com.atox.people.utils.RandomUtils.generateName;
import static java.time.LocalDateTime.now;

import java.time.LocalDate;
import  java.time.LocalDateTime;

import br.com.atox.people.entity.People;

public class PeopleBuilder {

	private People people;
	
	
	public PeopleBuilder() {
		
		this.people = new People();
	}
	
	public PeopleBuilder(People people) {
		
		this.people = people;
	}
	
	
	public PeopleBuilder withLegalDocumentNumber(String value) {
		this.people.setLegalDocumentNumber(value);
		return this;
		
	}
	
	public PeopleBuilder withBirthDate(LocalDate value) {
		this.people.setBirthDate(value);
		return this;
		
	}
	
	public PeopleBuilder withName(String value) {
		
		this.people.setName(value);
		return this;
	}
	
	
	public PeopleBuilder withEmail(String value) {
		
		this.people.setEmail(value);
		return this;
	
	}
	
	public PeopleBuilder withUpdateAt(LocalDateTime value) {
		this.people.setUpdatedAt(value);
		return this;
	}
	
	public PeopleBuilder any() {
		
		return this.withLegalDocumentNumber(generateLegalDocumentNumber())
							.withBirthDate(generateDate())
							.withEmail(generateEmail())
							.withName(generateName())
							.withUpdateAt(now());
	}
	 
	public People build() {
		
		return this.people;
	}
	
}
