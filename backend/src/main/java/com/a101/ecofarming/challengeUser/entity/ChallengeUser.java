package com.a101.ecofarming.challengeUser.entity;

import com.a101.ecofarming.challenge.entity.Challenge;
import com.a101.ecofarming.global.entity.BaseEntity;
import com.a101.ecofarming.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "challenge_user")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder

public class ChallengeUser extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Challenge challenge;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;

    @Column(nullable = false)
    private Integer betAmount;

    @Column(nullable = false)
    private Byte balanceGamePick;

    @Builder.Default
    @Column(nullable = false)
    private Integer returnAmount = 0;

    @Builder.Default
    @Column(nullable = false)
    private Byte successRate = 0;
}
