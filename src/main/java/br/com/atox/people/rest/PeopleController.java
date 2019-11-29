package br.com.atox.people.rest;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.atox.people.config.CamundaConstants;
import br.com.atox.people.entity.People;
import br.com.atox.people.service.PeopleService;

@RestController
@RequestMapping("/peoples")
public class PeopleController {

	@Autowired
	private PeopleService peopleService;

	@Autowired
	private ProcessEngine camunda;

	@PostMapping
	@ResponseStatus(CREATED)
	public void save(@RequestBody People people) {
		
		placePeople(people);

	}

	@GetMapping("/{id}")
	public People findById(@PathVariable("id") Long id) {
		return peopleService.getOne(id);
	}

	@GetMapping
	public List<People> findAll() {
		return peopleService.getAll();
	}

	public ProcessInstance placePeople(People people) {
		
		return camunda.getRuntimeService().startProcessInstanceByKey(CamundaConstants.PROCESS_KEY,
				Variables.putValue(CamundaConstants.PEOPLE, people));
	}
}
