package br.com.atox.people.process;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import br.com.atox.people.config.CamundaConstants;
import br.com.atox.people.entity.People;
/**
 * Esta tarefa visa validar os dados do cadastro antes da persistência na base de dados,
 * poderia ser feita validação utilizando as constraints do Spring/Java @NotNull, @NotBlank, @Email
 * porém na modelagem BPMN desenhada foi proposto que isto fosse realizado após a validação
 * se cadastro já existe.
 * 
 *  Isto foi feito para exemplificar a mudança no pensamento de desenvolvimento tradicional
 *  em relação a orientação a processos.
 *  
 * @author Emiliano Fagundes 
 *
 */
@Component
@ConfigurationProperties
public class ValidatePeople   implements JavaDelegate {

	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		People people = (People) execution.getVariable(CamundaConstants.PEOPLE);			
		
		List<String> errors = new ArrayList<String>();
		if(StringUtils.isEmpty(people.getEmail())) {
			errors.add("0001 - Email não pode estar em branco.");
		}
		
		if(StringUtils.isEmpty(people.getName())) {
			errors.add("0002 - Nome não pode estar em branco.");
		}
		
		if(null == people.getBirthDate()) {
			errors.add("0003 - Data de nascimento não pode estar em branco.");
		}
		
		if(!errors.isEmpty()) {
			throw new Exception(errors.toString());
		}
	}

}
