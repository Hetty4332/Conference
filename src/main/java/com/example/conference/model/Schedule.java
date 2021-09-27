package com.example.conference.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;
}
