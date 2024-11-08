package com.example.tribeauditlogservice.audit.repositories;

import com.example.tribeauditlogservice.audit.models.AuditLog;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditLogRepository extends ReactiveMongoRepository<AuditLog,String> {
}
