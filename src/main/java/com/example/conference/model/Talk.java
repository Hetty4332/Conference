package com.example.conference.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Talk {
    @Id
    private Long id;
    @ManyToMany(mappedBy = "talks")
    private Set<User> users;
    @OneToOne
    private Schedule schedule;
    @Column
    private String name;

}
