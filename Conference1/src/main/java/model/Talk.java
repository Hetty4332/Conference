package model;

import lombok.Data;
import org.hibernate.service.spi.InjectService;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Talk {
    @Id
    @GeneratedValue
    private long id;
    private long id_user;


}
