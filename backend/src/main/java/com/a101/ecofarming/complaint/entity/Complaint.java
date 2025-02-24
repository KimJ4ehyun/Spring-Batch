package com.a101.ecofarming.complaint.entity;

import com.a101.ecofarming.global.entity.BaseEntity;
import com.a101.ecofarming.proof.entity.Proof;
import com.a101.ecofarming.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "complaint")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Complaint extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Proof proof;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;

    private String description;

    private Boolean aiPass;

    private Boolean adminPass;
}

