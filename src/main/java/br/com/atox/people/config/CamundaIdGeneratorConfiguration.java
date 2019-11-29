package br.com.atox.people.config;
import org.camunda.bpm.engine.impl.persistence.StrongUuidGenerator;
import org.camunda.bpm.engine.spring.SpringProcessEngineConfiguration;
import org.camunda.bpm.spring.boot.starter.configuration.CamundaHistoryLevelAutoHandlingConfiguration;
import org.camunda.bpm.spring.boot.starter.configuration.impl.AbstractCamundaConfiguration;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CamundaIdGeneratorConfiguration extends AbstractCamundaConfiguration implements CamundaHistoryLevelAutoHandlingConfiguration {

  @Override
  public void preInit(SpringProcessEngineConfiguration configuration) {
    configuration.setIdGenerator(new StrongUuidGenerator());
  }
}