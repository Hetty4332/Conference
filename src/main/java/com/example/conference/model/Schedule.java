package com.example.conference.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@NoArgsConstructor
@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column (nullable = false)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Room room;
    @OneToOne
    private Talk talk;
    @Column
    private Date date;
}
