package com.example.wc.config;

import com.example.wc.ui.PagerDirective;
import freemarker.template.Configuration;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Freemarker 自定义标签
 */
@Component
public class FreemarkerConfig {

    @Autowired
    private Configuration configuration;

    @Autowired
    private PagerDirective pagerDirective;


    @PostConstruct
    public void setSharedVariable() throws TemplateModelException {
        Map<String, TemplateDirectiveModel> map = new HashMap();
        map.put("pager", pagerDirective);
        configuration.setSharedVaribles(map);
    }

}
