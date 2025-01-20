package com.trainibit.first_api.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;

    @Column(name = "updated_date", nullable = false)
    private Timestamp updatedDate;

    @Column(name = "uuid")
    private UUID uuid;

    @Column(name = "planet")
    private String planet;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "federal_state_id", nullable = false)
    private FederalState federalState;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<RolesByUser> roles = new ArrayList<>();
}
