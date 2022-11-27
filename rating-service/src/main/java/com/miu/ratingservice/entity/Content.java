package com.miu.ratingservice.entity;

import lombok.Data;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class Content implements Serializable {

    private Long contentId;
    private ContentType contentType;
}
