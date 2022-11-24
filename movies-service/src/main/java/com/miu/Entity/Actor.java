package com.miu.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

//@Data
@Data
@Entity
public class Actor {

    @Id
    int id;

    String firstName;
    String lastName;

    @JsonIgnore
    @OneToMany(mappedBy = "actor", fetch = FetchType.EAGER)
    List<ActorsMovies> actorsMovies;


}
