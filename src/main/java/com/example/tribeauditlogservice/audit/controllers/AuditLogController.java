package com.example.tribeauditlogservice.audit.controllers;

import com.example.tribeauditlogservice.audit.dtos.AuditLogDTO;
import com.example.tribeauditlogservice.audit.interfaces.IAuditLogService;
import com.example.tribeauditlogservice.audit.models.AuditLog;
import com.example.tribeauditlogservice.audit.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/audit")
@RequiredArgsConstructor
@Slf4j
public class AuditLogController {
    private final IAuditLogService auditLogService;
    @PostMapping("log")
    public Mono<ResponseEntity<Response<AuditLog>>> log(@RequestBody AuditLogDTO request){
        log.info("about logging {}",request);
        return auditLogService.log(request)
                .map(auditLogResponse -> ResponseEntity.status(auditLogResponse.getStatus()).body(auditLogResponse));
    }

    @PostMapping("get-log")
    public Mono<ResponseEntity<Response<List<AuditLog>>>> getLog(@RequestBody Map<String, Object> request){
        return auditLogService.getLog(request)
                .map(auditLogResponse -> {
                    log.info("{}",auditLogResponse.toString());
                    return ResponseEntity.status(auditLogResponse.getStatus()).body(auditLogResponse);
                });
    }
}
