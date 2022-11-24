package com.miu.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Actor {

    @Id
    int id;

    String firstName;
    String lastName;

    @OneToMany(mappedBy = "actor", fetch = FetchType.EAGER)
    List<ActorsSeries> actorsSeries;


}
