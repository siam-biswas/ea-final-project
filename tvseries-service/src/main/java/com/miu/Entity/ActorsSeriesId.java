package com.miu.Entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ActorsSeriesId  implements Serializable {
    int seriesId;
    int actorId;
}
