package com.xg.mapper;

import com.xg.domain.Actor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-20 16:36.
 * @DESCRIPTION:
 */

@Mapper
public interface ActorMapper {
    Actor findActorById(int id);
    List<Actor> findActorByFirstName(String firstName);
    void insertActor(Actor actor);
    void deleteActorById(Actor actor);
}
