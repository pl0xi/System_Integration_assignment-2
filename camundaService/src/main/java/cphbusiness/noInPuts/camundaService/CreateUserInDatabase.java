package cphbusiness.noInPuts.camundaService;

import jakarta.inject.Named;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.camunda.bpm.engine.delegate.JavaDelegate;
@Named
public class CreateUserInDatabase implements JavaDelegate {

        @Override
        public void execute(org.camunda.bpm.engine.delegate.DelegateExecution execution) throws Exception {
            CamelContext context = new DefaultCamelContext();
            context.start();

            ProducerTemplate producerTemplate = context.createProducerTemplate();
            String name = execution.getVariable("Name").toString();
            String phoneNumber = execution.getVariable("phone").toString();
            String email = execution.getVariable("email").toString();


            try {
                producerTemplate.sendBody("http://localhost:8081/camel/user/create", String.format("{" +
                        "    \"name\": \"%s\"," +
                        "    \"phone_number\": \"%s\"," +
                        "    \"email\": \"%s\"" +
                        "}", name, phoneNumber, email));
            } finally {
                context.stop();
            }
        }
}
