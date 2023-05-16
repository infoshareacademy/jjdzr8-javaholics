package com.javaholics.web.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "USERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
                name = "user_event_jointable",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "event_id")
        )
    private List<Event> events;

    @OneToMany(mappedBy = "routeOwner")
    private List<Route> routes;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "login",
            nullable = false)
    private String login;

    @Enumerated(EnumType.STRING)
    private SexChoice sex;

    @Email
    @Column(nullable = false,
    unique = true)
    private String email;

    @Column(name = "location")
    private String location;

    @Enumerated(EnumType.STRING)
    private Region prefferedRegionEvents;

    @Column(name = "description")
    private String desctription;

    @Enumerated(EnumType.STRING)
    //@NotNull
    private UserProvider loginProvider;

    //@JsonIgnore
    @Column(nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRoles role;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
