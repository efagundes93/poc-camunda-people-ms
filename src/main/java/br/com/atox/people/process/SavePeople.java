package br.com.atox.people.process;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.atox.people.config.CamundaConstants;
import br.com.atox.people.entity.People;
import br.com.atox.people.service.PeopleService;

@Component
@ConfigurationProperties
@Transactional
public class SavePeople  implements JavaDelegate {

	@Autowired
	private PeopleService peopleService;
	
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		People people = (People) execution.getVariable(CamundaConstants.PEOPLE);		
		execution.setVariable(CamundaConstants.CREATED_PEOPLE,  this.peopleService.save(people));		
	}
}
