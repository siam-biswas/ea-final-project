package com.miu.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Actor {

    @Id
    int id;

    String firstName;
    String lastName;

    @OneToMany(mappedBy = "actor")
    List<ActorsMovies> actorsSeries;


}
