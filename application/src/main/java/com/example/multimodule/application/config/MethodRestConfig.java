package com.example.multimodule.application.config;

import com.example.multimodule.application.entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;


@Configuration
public class MethodRestConfig implements RepositoryRestConfigurer {
    private String url ="localhost:8080";

    @Autowired
    private EntityManager entityManager;

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(entityManager.getMetamodel().getEntities().stream().map(Type::getJavaType).toArray(Class[]::new));

        HttpMethod[] disableMethods = {
                HttpMethod.POST, HttpMethod.PUT, HttpMethod.PATCH, HttpMethod.DELETE
        };

        disableHTTPMethods(Category.class, config, disableMethods);
    }

    private void disableHTTPMethods(Class c, RepositoryRestConfiguration config, HttpMethod[] disableMethods) {
        config.getExposureConfiguration().forDomainType(c).withItemExposure((metdata, httpMethods) ->
                httpMethods.disable(disableMethods)).withCollectionExposure((metdata, httpMethods) ->
                httpMethods.disable(disableMethods));
    }
}
