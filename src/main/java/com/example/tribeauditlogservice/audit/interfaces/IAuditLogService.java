package com.example.tribeauditlogservice.audit.interfaces;

import com.example.tribeauditlogservice.audit.dtos.AuditLogDTO;
import com.example.tribeauditlogservice.audit.models.AuditLog;
import com.example.tribeauditlogservice.audit.utils.Response;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

public interface IAuditLogService {
    Mono<Response<AuditLog>> log(AuditLogDTO request);
    Mono<Response<List<AuditLog>>> getLog(Map<String,Object> request);

}
