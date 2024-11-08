package com.example.tribeauditlogservice.audit.utils;

import com.example.tribeauditlogservice.audit.dtos.AuditLogDTO;
import com.example.tribeauditlogservice.audit.models.AuditLog;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

public class DtoToEntityUtil {
    public static AuditLog dtoToEntity(AuditLogDTO dto){
        AuditLog auditLog = new AuditLog();
        BeanUtils.copyProperties(dto,auditLog);
        auditLog.setDateCreated(LocalDateTime.now());
        return auditLog;
    }
}
