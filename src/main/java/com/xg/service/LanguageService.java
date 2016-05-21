package com.xg.service;

import com.xg.domain.Language;
import com.xg.mapper.LanguageMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-21 17:25.
 * @DESCRIPTION:
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class LanguageService {

    private final Log logger = LogFactory.getLog(this.getClass());
    @Autowired
    private LanguageMapper languageMapper;

    @Cacheable("languageById")
    public Language get(int id) {
        return languageMapper.get(id);
    }

    @Cacheable("languages")
    public List<Language> list() {
        return languageMapper.list();
    }

    @CacheEvict(value = {"languages"}, allEntries = true)
    @Transactional(readOnly = false)
    public boolean add(Language language) {
        if (language == null) {
            return false;
        }
        language.setLastUpdate(new Date());
        languageMapper.add(language);
        return true;
    }

    @CacheEvict(value = {"languages", "languageById"}, allEntries = true)
    @Transactional(readOnly = false)
    public boolean update(Language language) {
        if (language == null) {
            return false;
        }
        language.setLastUpdate(new Date());
        languageMapper.update(language);
        return true;
    }

    @CacheEvict(value = {"languages", "languageById"}, allEntries = true)
    @Transactional(readOnly = false)
    public boolean delete(Language language) {
        if (language == null) {
            return false;
        }
        languageMapper.delete(language);
        return true;
    }

}
