package com.miu.Enum;

public enum FilterType {
    RELEASE_DATE(1) ,
    GENRE(2),
    DIRECTOR(3),
    ACTOR(4),
    DURATION(5),
    RATING(6);

    int v;
    FilterType(int value){
        this.v = value;
    }
}
