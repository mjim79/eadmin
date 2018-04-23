package es.fpdual.eadmin.eadmin;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;

@SpringBootApplication
@ImportResource({ "classpath:spring-configuracion/eadmin-persistencia.xml",
        "classpath:spring-configuracion/eadmin-sqlserver-persistencia.xml" })
public class EadminApplication {

    public static void main(String[] args) {
        SpringApplication.run(EadminApplication.class, args);
    }
}
