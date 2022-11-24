package com.miu.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Actor {

    @Id
    int id;

    String firstName;
    String lastName;

    @OneToMany(mappedBy = "actor", fetch = FetchType.EAGER)
            @JsonIgnore
    List<ActorsSeries> actorsSeries;


}
