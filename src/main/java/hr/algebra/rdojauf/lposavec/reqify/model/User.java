package hr.algebra.rdojauf.lposavec.reqify.model;

import hr.algebra.rdojauf.lposavec.reqify.enums.RecruitmentRole;
import hr.algebra.rdojauf.lposavec.reqify.enums.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "recruitment_users",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "recruitment_user_email",
                        columnNames = "email"
                )
        }
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @Column(nullable = false)
    private String displayName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private RecruitmentRole role;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private UserStatus status;

    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @Column(nullable = false)
    private Instant updatedAt;

    private Instant lastLoginAt;
    private Instant passwordChangeAt;

    @Column(nullable = false)
    private boolean mfaEnabled;

    @Version
    private long version;

    public boolean isActive() {
        return status == UserStatus.ACTIVE;
    }

    public boolean requiresAnonymizedCandidateData() {
        return role == RecruitmentRole.ANONYMIZED_REVIEWER;
    }
}
