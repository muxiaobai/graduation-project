/**
 * Project Name:spring-boot
 * File Name:JerseyConfig.java
 * Package Name:config
 * Date:2017年2月28日上午9:55:49
 * Copyright (c) 2017, All Rights Reserved.
 *
*/

package config;

import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.web.filter.RequestContextFilter;

/**
 * ClassName:JerseyConfig <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年2月28日 上午9:55:49 <br/>
 * @author   Lenovo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */ 
@Component
public class JerseyConfig extends ResourceConfig{
    public JerseyConfig() {
        register(RequestContextFilter.class);
       // packages("rest");
        ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new RegexPatternTypeFilter(Pattern.compile(".*")));
        Set<BeanDefinition> candidateComponents = provider.findCandidateComponents("rest");
        for (BeanDefinition candidateComponent : candidateComponents) {
          register(ClassUtils.resolveClassName(candidateComponent.getBeanClassName(), ClassUtils.getDefaultClassLoader()));
        }
//        register(LoggingFilter.class);
    }
}

