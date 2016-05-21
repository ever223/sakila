package com.xg.service;

import com.xg.domain.Language;
import com.xg.mapper.LanguageMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private LanguageMapper languageMapper;

    public Language get(int id) {
        return languageMapper.get(id);
    }
    public List<Language> list() {
        return languageMapper.list();
    }

    @Transactional(readOnly = false)
    public boolean add(Language language) {
        if (language == null) {
            return false;
        }
        language.setLastUpdate(new Date());
        languageMapper.add(language);
        return true;
    }
}
