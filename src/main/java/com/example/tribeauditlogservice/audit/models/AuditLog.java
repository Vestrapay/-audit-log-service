package com.example.tribeauditlogservice.audit.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "audits")
public class AuditLog {
    @Id
    private String id;
    private String userId;
    private String userEmail;
    private String action;
    @CreatedDate
    @Indexed(expireAfterSeconds = 120) // 7 days in seconds
    private LocalDateTime dateCreated;
}
