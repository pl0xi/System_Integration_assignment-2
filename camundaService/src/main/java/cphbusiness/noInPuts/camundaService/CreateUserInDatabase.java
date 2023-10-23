package cphbusiness.noInPuts.camundaService;

import jakarta.inject.Named;
import org.camunda.bpm.engine.delegate.JavaDelegate;
@Named
public class CreateUserInDatabase implements JavaDelegate {

        @Override
        public void execute(org.camunda.bpm.engine.delegate.DelegateExecution execution) throws Exception {
            System.out.println("CreateUserInDatabase");
        }
}
