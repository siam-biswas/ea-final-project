package com.miu.Repository;

import com.miu.Entity.ActorsSeries;
import com.miu.Entity.ActorsSeriesId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ActorSeriesRepo extends CrudRepository<ActorsSeries , ActorsSeriesId> {

    List<ActorsSeries> findAllByActor_FirstName(String FName);
}
