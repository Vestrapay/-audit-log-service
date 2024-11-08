package com.example.tribeauditlogservice.audit.service;

import com.example.tribeauditlogservice.audit.dtos.AuditLogDTO;
import com.example.tribeauditlogservice.audit.interfaces.IAuditLogService;
import com.example.tribeauditlogservice.audit.models.AuditLog;
import com.example.tribeauditlogservice.audit.repositories.AuditLogRepository;
import com.example.tribeauditlogservice.audit.utils.DtoToEntityUtil;
import com.example.tribeauditlogservice.audit.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
@Service
@RequiredArgsConstructor
@Slf4j
public class AuditLogService implements IAuditLogService {
    private final AuditLogRepository auditLogRepository;

    @Override
    public Mono<Response<AuditLog>> log(AuditLogDTO request) {

        return auditLogRepository.insert(DtoToEntityUtil.dtoToEntity(request))
                .flatMap(auditLog -> {
                    return Mono.just(Response.<AuditLog>builder()
                                    .status(HttpStatus.CREATED)
                                    .statusCode(HttpStatus.CREATED.value())
                                    .message("SUCCESSFUL")
                                    .data(auditLog)
                            .build());
                });
    }

    @Override
    public Mono<Response<List<AuditLog>>> getLog(Map<String, Object> request) {
        log.info("about fetching logs for request {}",request.toString());
        AuditLog auditLog = new AuditLog();
        if (request.isEmpty()){
            return auditLogRepository.findAll()
                    .collectList()
                    .flatMap(auditLogs -> Mono.just(Response.<List<AuditLog>>builder()
                                    .message("Successful")
                                    .data(auditLogs)
                                    .statusCode(HttpStatus.OK.value())
                                    .status(HttpStatus.OK)
                            .build()));
        }
        else {
            for (String key: request.keySet()) {
                if (key.equalsIgnoreCase("id"))
                    auditLog.setId((String) request.get(key));
                if (key.equalsIgnoreCase("userId"))
                    auditLog.setUserId((String) request.get(key));
                if (key.equalsIgnoreCase("userEmail"))
                    auditLog.setUserEmail((String) request.get(key));
            }
            return auditLogRepository.findAll(Example.of(auditLog, ExampleMatcher.matchingAny()),Sort.by("date_created").descending())
                    .collectList()
                    .flatMap(auditLogs -> Mono.just(Response.<List<AuditLog>>builder()
                            .message("Successful")
                            .data(auditLogs)
                            .statusCode(HttpStatus.OK.value())
                            .status(HttpStatus.OK)
                            .build()));
        }

    }
}
