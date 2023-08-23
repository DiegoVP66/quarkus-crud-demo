package org.acme;


import io.quarkus.runtime.Startup;
import jakarta.transaction.Transactional;


@jakarta.enterprise.context.ApplicationScoped
@Startup
public class DataInitializer {

    @Transactional
    void initData() {
        if (Person.count() == 0) {
            for (int i = 1; i <= 10; i++) {
                Person person = new Person();
                person.setEmail("email" + i + "@example.com");
                person.setObservacao("Observationssss " + i);
                person.persist();
            }
        }
    }
}
