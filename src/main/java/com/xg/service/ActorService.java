package com.xg.service;

import com.xg.domain.Actor;
import com.xg.mapper.ActorMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-20 16:32.
 * @DESCRIPTION:
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor=Exception.class, readOnly = true)
public class ActorService {
    private final Log logger = LogFactory.getLog(ActorService.class);

    @Autowired
    ActorMapper actorMapper;

    public Actor findActor(int id) {
        return this.actorMapper.findActorById(id);
    }


}
