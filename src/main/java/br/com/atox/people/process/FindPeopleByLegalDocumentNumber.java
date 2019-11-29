package br.com.atox.people.process;

import org.apache.commons.lang3.StringUtils;
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
public class FindPeopleByLegalDocumentNumber implements JavaDelegate {

	@Autowired
	private PeopleService peopleService;

	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		People example = (People) execution.getVariable(CamundaConstants.PEOPLE);
		
		if(StringUtils.isBlank(example.getLegalDocumentNumber()) ) {
			
			throw new Exception("O número do documento não pode ser nulo");
		}
		
		execution.setVariable(CamundaConstants.PEOPLE_EXISTS,  this.peopleService.getByLegalDocumentNumber(example.getLegalDocumentNumber()).isPresent());

	}

}
