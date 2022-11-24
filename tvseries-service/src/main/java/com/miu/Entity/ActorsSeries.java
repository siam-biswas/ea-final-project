package com.miu.Entity;

import javax.persistence.*;

@Entity
public class ActorsSeries {
    @EmbeddedId
    ActorsSeriesId id;

    @MapsId("actorId")
    @ManyToOne(fetch = FetchType.EAGER)
    Actor actor;

    @MapsId("seriesId")
    @ManyToOne(fetch = FetchType.EAGER)
    TVSeries series;

}
