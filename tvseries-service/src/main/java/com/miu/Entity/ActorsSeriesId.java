package com.miu.Entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ActorsSeriesId  implements Serializable {
    Long seriesId;
    Long actorId;
}
