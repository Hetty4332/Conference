package model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String login;
    private String password;
    private String role;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="id_user")
    private List<Talk> talks = new ArrayList<>();
}
