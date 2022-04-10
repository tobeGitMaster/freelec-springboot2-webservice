package org.springframework.boot.autoconfigure.web.servlet;

import java.util.List;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

public final class HomeControllerTestContextInitializer {
  public static void registerWebMvcAutoConfiguration_EnableWebMvcConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration", WebMvcAutoConfiguration.EnableWebMvcConfiguration.class).withConstructor(WebMvcProperties.class, WebProperties.class, ObjectProvider.class, ObjectProvider.class, ListableBeanFactory.class)
        .instanceSupplier((instanceContext) -> {
          WebMvcAutoConfiguration.EnableWebMvcConfiguration bean = instanceContext.create(beanFactory, (attributes) -> new WebMvcAutoConfiguration.EnableWebMvcConfiguration(attributes.get(0), attributes.get(1), attributes.get(2), attributes.get(3), attributes.get(4)));
          instanceContext.method("setConfigurers", List.class)
              .resolve(beanFactory, false).ifResolved((attributes) -> bean.setConfigurers(attributes.get(0)));
          return bean;
        }).register(beanFactory);
  }

  public static void registerEnableWebMvcConfiguration_welcomePageHandlerMapping(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("welcomePageHandlerMapping", WelcomePageHandlerMapping.class).withFactoryMethod(WebMvcAutoConfiguration.EnableWebMvcConfiguration.class, "welcomePageHandlerMapping", ApplicationContext.class, FormattingConversionService.class, ResourceUrlProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(WebMvcAutoConfiguration.EnableWebMvcConfiguration.class).welcomePageHandlerMapping(attributes.get(0), attributes.get(1), attributes.get(2)))).register(beanFactory);
  }

  public static void registerWebMvcAutoConfiguration_WebMvcAutoConfigurationAdapter(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$WebMvcAutoConfigurationAdapter", WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter.class).withConstructor(WebProperties.class, WebMvcProperties.class, ListableBeanFactory.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> new WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter(attributes.get(0), attributes.get(1), attributes.get(2), attributes.get(3), attributes.get(4), attributes.get(5), attributes.get(6)))).register(beanFactory);
  }

  public static void registerHttpEncodingAutoConfiguration_localeCharsetMappingsCustomizer(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("localeCharsetMappingsCustomizer", HttpEncodingAutoConfiguration.LocaleCharsetMappingsCustomizer.class).withFactoryMethod(HttpEncodingAutoConfiguration.class, "localeCharsetMappingsCustomizer")
        .instanceSupplier(() -> beanFactory.getBean(HttpEncodingAutoConfiguration.class).localeCharsetMappingsCustomizer()).register(beanFactory);
  }
}
