package com.java.practice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Entity to store the running jobs details
 */
@Getter
@Setter
@ToString
public class InstanceJob  {
  private UUID instanceId;
  private String displayName;
  private String jobId;
  private UUID tenantId;
  private LocalDateTime startedAt;
  private LocalDateTime completedAt;
  private String queueName;
  private Integer numberOfCPUs;
  private Double cpuUtilization;
  private String username;
}
