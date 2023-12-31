package cphbusiness.noInPuts.eip;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class UserRoute extends RouteBuilder {

        @Override
        public void configure() throws Exception {
            rest("/user")
                    .post("/create")
                    .produces("application/json")
                    .outType(String.class)
                    .to("direct:createUser");

            from("direct:createUser")
                    .log("User is created")
                    .setBody(simple("User is created"))
                    .to("http://localhost:8082/camel/data/user/create?bridgeEndpoint=true");
        }
}
