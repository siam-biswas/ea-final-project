package com.miu.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
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
