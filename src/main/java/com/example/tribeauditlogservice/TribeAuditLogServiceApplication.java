package com.example.tribeauditlogservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "VestraPay PGS Audit Log Service", version = "v1.0.0"),servers = @Server(url = "/auditlog"))
public class TribeAuditLogServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TribeAuditLogServiceApplication.class, args);
    }

}
