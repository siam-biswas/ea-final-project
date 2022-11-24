package com.miu.Entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Actor {

    @Id
    int id;

    String firstName;
    String lastName;

    @OneToMany(mappedBy = "actor" , fetch = FetchType.EAGER)
    List<ActorsMovies> actorsSeries;


}
