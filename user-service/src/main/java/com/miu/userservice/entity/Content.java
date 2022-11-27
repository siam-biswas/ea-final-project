package com.miu.userservice.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

@Embeddable
@Data
public class Content implements Serializable {

    private Long contentId;
    private ContentType contentType;
}
