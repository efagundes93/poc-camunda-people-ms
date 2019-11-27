# poc-camunda-people-ms
## Motivação

No dia a dia de desenvolvedor de microsserviços percebo que por vezes profissionais mais ligados à áreas de negócio tem uma certa dificuldade de entender os processos realizados pelos serviços, sem falar na dificuldade de monitoria desses processos. Certo dia escutei falar do Camunda, um framework baseado em Java que permite criar uma interface de controle de processos baseada em BPMN 2.0 então motivei-me a estuda-lo.

A proposta deste repositório é estudar a viabilidade de construção de microsserviços fazendo uso do Camunda em conjunto com Spring Boot 2.0 adequando a realidade dos projetos que atuo, visando providenciar a interface de controle e manter processos existentes,  assim diminuindo o impacto em uma possível migração de microsserviços.


## A Stack de desenvolvimento:

- Maven 
- Banco de dados H2 embedded;
- Spring Boot 2.x
- Java 1.8


## Camunda

O Framework se propõe a prover interfaces de Gerenciamento de Processos de Negocio em aplicações, inclusive na página inicial da ferramenta eles dizem: 
“ *Nunca tema novamente o Gerenciamento de Processos de Negócios, pois você amará a Camunda. Se você acha isso difícil de acreditar, tente.*”

Um dos pontos mais legais que ví, é a possibilidade de executar workflows e decisões a partir de mecanismos disponibilizados pelo Camunda. Anteriormente tive contato com Oracle BPM, que tem uma proposta parecida com webservices, mas me atrevo a dizer que mesmo com todo tamanho da Oracle a curva de aprendizado, tempo e a parafernalha necessária para implementar um Hello Word é muito menor utilizando Camuda + Spring Boot (Só o tempo de abrir o jDeveloper já ferra com o TPPHW do Oracle, afinal eles nunca ligaram para Developer Experience haha) . 

Brincadeiras a parte, do ponto de vista técnico tive algumas dificuldades em relação a compreender como utilizar o Camunda em um microsserviço, e adianto que a principal diferença do método de trabalho que vinha adotando é mudar ou mesclar um paradigma orientado a eventos para um orientado a processos. A adoção do framework na construção da aplicação trouxe uma complexidade um pouco maior no desenvolvimento da aplicação, porém tornou possível monitorar os processos de uma forma completa e clara.

## Resumo da Ópera

Se não deseja se aprofundar muito no artigo,vamos direto ao ponto: O processo basicamente foi, construir um microsserviço com endpoint POST que visava criar o cadastro, modelar um processo BPMN que represente esse processo de negócio no Camunda Modeler, incluir as dependencias no Maven, criar componentes que implementam JavaDelegate e voia-la.

## Ao Desenvolvedor 

O que o desenvolvedor precisa compreender é que cada tarefa criada no BPMN deve ser representada no projeto em uma classe que implementa JavaDelegate. O Camunda identificará o Bean por seu nome e apartir disso fará sua mágica. Não é necessário reescrever seus services, pode ficar tranquilo e manter sua arquitetura, para o camunda funcionar, basta apenas que chame seus métodos de serviço através desta classe que implementa a interface JavaDelegate.

### Passo a Passo

A primeira coisa a se fazer é criar um processo de negocio, o famoso BPM, para isto é necessário uma ferramenta e adivinhe? O Camunda disponibiliza uma ferramenta para isto! 

#### Instale o Camunda Modeler 
- faça o download de acordo com seu sistema operacional em https://camunda.com/download/modeler/ 
- extraia os arquivos em uma pasta do seu sistema e execute-o.

#### Modele um processo
- Neste projeto, modelei um fluxo simples de cadastro de pessoas onde basicamente, após uma chama POST ao endpoint da API é feita verificação se o cadastro já existe, uma validação simples dos dados e a persistência do cadastro na base de dados. O BPMN ficou assim:

img 001 
Na ferramenta de modelagem, para cada tarefa em *“Details -> Implementation”* você deve selecionar a opção *“Delegate”* e em *“Delegate Expression”* deve declarar o nome do Bean implementado no Java que representa a tarefa e que implementa a interface **JavaDelegate**.

img 002 
**Inicios, condições e Finais de processos não tem implementações explicitas**
Para exemplificar claramente o que foi feito, para a tarefa “Buscar cadastro por documento” no projeto Java foi criado componente  “findPeopleByLegalDocumentNumber” que implementa a interface JavaDelegate. 

img003

A implementação desta interface basicamente consiste em sobrescrever o método execute, nele você deve escrever as regras de negócios referentes a esta tarefa ou então chamar componentes que executem esta tarefa, no caso da tarefa “Buscar cadastro por documento“ por exemplo, chamo o método “findByLegalDocumentNumber da classe PeopleService.


## Observações
- Tentei coexistir o Camunda com Spring WebFlux mas isto não é “naturalmente” possível devido a necessidade do Camunda instanciar WebMVC.. Pelo pouco que pesquisei vi que existem “workarounds” que podem ser feitas para construir uma aplicação reativa utilizando o Camunda, mas como o intuito principal não era este acabei não querendo me aprofundar. Em resumo, quando tentei rodar WebFlux e Camunda ocorreu a exceção

*“The Java/XML config for Spring MVC and Spring WebFlux cannot both be enabled, e.g. via @EnableWebMvc and @EnableWebFlux, in the same application.”


## Referências:
https://docs.camunda.org/manual/7.11/introduction/

https://stackoverflow.com/questions/55974200/integrate-camunda-webapp-in-spring-reactive-project
