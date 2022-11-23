package com.miu.Entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ActorsMoviesId implements Serializable {
    int movieId;
    int actorId;
}
