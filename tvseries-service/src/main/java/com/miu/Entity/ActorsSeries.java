package com.miu.Entity;

import javax.persistence.*;

@Entity
public class ActorsSeries {
    @EmbeddedId
    ActorsSeriesId id;

    @MapsId("actorId")
    @ManyToOne
    Actor actor;

    @MapsId("seriesId")
    @ManyToOne
    TVSeries series;

}
