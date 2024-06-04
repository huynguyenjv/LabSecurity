package fit.hutech.labsecurity.entites;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(unique = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    private String password;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @Column(nullable = true)
    private Boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
}
