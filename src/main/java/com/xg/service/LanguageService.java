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

    //@CachePut("users") //每次都会执行方法，并将结果存入指定的缓存中
    @Cacheable("languageById") //执行前检查缓存中是否存在之前执行过的结果
    public Language get(int id) {
        return languageMapper.get(id);
    }

    //condition	缓存的条件，可以为空，使用 SpEL 编写，
    // 返回 true 或者 false，只有为 true 才进行缓存
    @Cacheable("languages")
    public List<Language> list() {
        return languageMapper.list();
    }

    @Cacheable("languageByName")
    public List<Language> findByName(String name) {
        return languageMapper.findByName(name);
    }

    // @CacheEvict是用来标注在需要清除缓存元素的方法或类上的。
    // allEntries是boolean类型，表示是否需要清除缓存中的所有元素
    // beforeInvocation属性 清除操作默认是在对应方法成功执行之后触发的，
    // 即方法如果因为抛出异常而未能成功返回时也不会触发清除操作。
    // 使用beforeInvocation可以改变触发清除操作的时间，
    // 当我们指定该属性值为true时，Spring会在调用该方法之前清除缓存中的指定元素。
    @CacheEvict(value = {"languages"}, allEntries = true, beforeInvocation = false)
    @Transactional(readOnly = false)
    public boolean add(Language language) {
        if (language == null) {
            return false;
        }
        language.setLastUpdate(new Date());
        languageMapper.add(language);
        return true;
    }

    @CacheEvict(value = {"languages", "languageById", "languageByName"}, allEntries = true)
    @Transactional(readOnly = false)
    public boolean update(Language language) {
        if (language == null) {
            return false;
        }
        language.setLastUpdate(new Date());
        languageMapper.update(language);
        return true;
    }

    @CacheEvict(value = {"languages", "languageById", "languageByName"}, allEntries = true)
    @Transactional(readOnly = false)
    public boolean delete(Language language) {
        if (language == null) {
            return false;
        }
        languageMapper.delete(language);
        return true;
    }

}
