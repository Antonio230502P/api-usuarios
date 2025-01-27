package com.trainibit.first_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@Entity
@Table(name = "federal_states")
public class FederalState implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "created_date", nullable = false, insertable = false, updatable = false)
    // @ColumnDefault("CURRENT_TIMESTAMP")
    @CreationTimestamp
    private Timestamp createdDate;

    @Column(name = "updated_date", nullable = false, insertable = false)
    // @ColumnDefault("CURRENT_TIMESTAMP")
    @UpdateTimestamp
    private Timestamp updatedDate;

    @Column(name = "uuid", nullable = false, updatable = false)
    private UUID uuid;
}