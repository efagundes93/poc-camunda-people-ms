package br.com.atox.people.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@Configuration
@EntityScan("br.com.atox.people.entity")
@EnableJpaRepositories("br.com.atox.people.repository")
public class InfraestructureConfig {

}
