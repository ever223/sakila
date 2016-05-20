package com.xg.mapper;

import com.xg.domain.Actor;
import org.apache.ibatis.annotations.Mapper;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-20 16:36.
 * @DESCRIPTION:
 */
@Mapper
public interface ActorMapper {
    Actor findActorById(int id);
}
