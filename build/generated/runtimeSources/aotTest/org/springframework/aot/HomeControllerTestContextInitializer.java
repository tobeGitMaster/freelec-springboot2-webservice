package org.springframework.aot;

import com.jojoldu.book.springboot.Application;
import com.jojoldu.book.springboot.web.HelloController;
import java.lang.Override;
import java.util.List;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.jackson.JacksonProperties;
import org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration;
import org.springframework.boot.autoconfigure.task.TaskExecutionProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath;
import org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.context.properties.BoundConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor;
import org.springframework.boot.jackson.JsonComponentModule;
import org.springframework.boot.task.TaskExecutorBuilder;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.SpringBootMockMvcBuilderCustomizer;
import org.springframework.boot.validation.beanvalidation.MethodValidationExcludeFilter;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.filter.OrderedFormContentFilter;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.util.PathMatcher;
import org.springframework.validation.Validator;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.RequestContextFilter;
import org.springframework.web.method.support.CompositeUriComponentsContributor;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.RequestToViewNameTranslator;
import org.springframework.web.servlet.ThemeResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.function.support.HandlerFunctionAdapter;
import org.springframework.web.servlet.function.support.RouterFunctionMapping;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;
import org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter;
import org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.resource.ResourceUrlProvider;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.util.UrlPathHelper;
import org.springframework.web.util.pattern.PathPatternParser;

/**
 * AOT generated context for {@code HomeControllerTest}.
 */
public class HomeControllerTestContextInitializer implements ApplicationContextInitializer<GenericApplicationContext> {
  @Override
  public void initialize(GenericApplicationContext context) {
    // infrastructure
    DefaultListableBeanFactory beanFactory = context.getDefaultListableBeanFactory();
    beanFactory.setAutowireCandidateResolver(new ContextAnnotationAutowireCandidateResolver());

    BeanDefinitionRegistrar.of("application", Application.class)
        .instanceSupplier(Application::new).register(beanFactory);
    BeanDefinitionRegistrar.of("helloController", HelloController.class)
        .instanceSupplier(HelloController::new).register(beanFactory);
    org.springframework.boot.autoconfigure.HomeControllerTestContextInitializer.registerAutoConfigurationPackages_BasePackages(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration", TaskExecutionAutoConfiguration.class)
        .instanceSupplier(TaskExecutionAutoConfiguration::new).register(beanFactory);
    BeanDefinitionRegistrar.of("taskExecutorBuilder", TaskExecutorBuilder.class).withFactoryMethod(TaskExecutionAutoConfiguration.class, "taskExecutorBuilder", TaskExecutionProperties.class, ObjectProvider.class, ObjectProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(TaskExecutionAutoConfiguration.class).taskExecutorBuilder(attributes.get(0), attributes.get(1), attributes.get(2)))).register(beanFactory);
    BeanDefinitionRegistrar.of("applicationTaskExecutor", ThreadPoolTaskExecutor.class).withFactoryMethod(TaskExecutionAutoConfiguration.class, "applicationTaskExecutor", TaskExecutorBuilder.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(TaskExecutionAutoConfiguration.class).applicationTaskExecutor(attributes.get(0)))).customize((bd) -> bd.setLazyInit(true)).register(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor", ConfigurationPropertiesBindingPostProcessor.class)
        .instanceSupplier(ConfigurationPropertiesBindingPostProcessor::new).customize((bd) -> bd.setRole(2)).register(beanFactory);
    org.springframework.boot.context.properties.HomeControllerTestContextInitializer.registerConfigurationPropertiesBinder_Factory(beanFactory);
    org.springframework.boot.context.properties.HomeControllerTestContextInitializer.registerConfigurationPropertiesBinder(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.context.properties.BoundConfigurationProperties", BoundConfigurationProperties.class)
        .instanceSupplier(BoundConfigurationProperties::new).customize((bd) -> bd.setRole(2)).register(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.context.properties.EnableConfigurationPropertiesRegistrar.methodValidationExcludeFilter", MethodValidationExcludeFilter.class)
        .instanceSupplier(() -> MethodValidationExcludeFilter.byAnnotation(ConfigurationProperties.class)).customize((bd) -> bd.setRole(2)).register(beanFactory);
    BeanDefinitionRegistrar.of("spring.task.execution-org.springframework.boot.autoconfigure.task.TaskExecutionProperties", TaskExecutionProperties.class)
        .instanceSupplier(TaskExecutionProperties::new).register(beanFactory);
    org.springframework.boot.autoconfigure.web.servlet.error.HomeControllerTestContextInitializer.registerErrorMvcAutoConfiguration_WhitelabelErrorViewConfiguration(beanFactory);
    org.springframework.boot.autoconfigure.web.servlet.error.HomeControllerTestContextInitializer.registerWhitelabelErrorViewConfiguration_error(beanFactory);
    org.springframework.boot.autoconfigure.web.servlet.error.HomeControllerTestContextInitializer.registerWhitelabelErrorViewConfiguration_beanNameViewResolver(beanFactory);
    org.springframework.boot.autoconfigure.web.servlet.error.HomeControllerTestContextInitializer.registerErrorMvcAutoConfiguration_DefaultErrorViewResolverConfiguration(beanFactory);
    BeanDefinitionRegistrar.of("spring.web-org.springframework.boot.autoconfigure.web.WebProperties", WebProperties.class)
        .instanceSupplier(WebProperties::new).register(beanFactory);
    BeanDefinitionRegistrar.of("spring.mvc-org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties", WebMvcProperties.class)
        .instanceSupplier(WebMvcProperties::new).register(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration", ErrorMvcAutoConfiguration.class).withConstructor(ServerProperties.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> new ErrorMvcAutoConfiguration(attributes.get(0)))).register(beanFactory);
    BeanDefinitionRegistrar.of("errorAttributes", DefaultErrorAttributes.class).withFactoryMethod(ErrorMvcAutoConfiguration.class, "errorAttributes")
        .instanceSupplier(() -> beanFactory.getBean(ErrorMvcAutoConfiguration.class).errorAttributes()).register(beanFactory);
    BeanDefinitionRegistrar.of("basicErrorController", BasicErrorController.class).withFactoryMethod(ErrorMvcAutoConfiguration.class, "basicErrorController", ErrorAttributes.class, ObjectProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(ErrorMvcAutoConfiguration.class).basicErrorController(attributes.get(0), attributes.get(1)))).register(beanFactory);
    org.springframework.boot.autoconfigure.web.servlet.error.HomeControllerTestContextInitializer.registerErrorMvcAutoConfiguration_errorPageCustomizer(beanFactory);
    org.springframework.boot.autoconfigure.web.servlet.error.HomeControllerTestContextInitializer.registerErrorMvcAutoConfiguration_preserveErrorControllerTargetClassPostProcessor(beanFactory);
    BeanDefinitionRegistrar.of("server-org.springframework.boot.autoconfigure.web.ServerProperties", ServerProperties.class)
        .instanceSupplier(ServerProperties::new).register(beanFactory);
    org.springframework.boot.autoconfigure.web.servlet.HomeControllerTestContextInitializer.registerWebMvcAutoConfiguration_EnableWebMvcConfiguration(beanFactory);
    BeanDefinitionRegistrar.of("requestMappingHandlerAdapter", RequestMappingHandlerAdapter.class).withFactoryMethod(WebMvcAutoConfiguration.EnableWebMvcConfiguration.class, "requestMappingHandlerAdapter", ContentNegotiationManager.class, FormattingConversionService.class, Validator.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(WebMvcAutoConfiguration.EnableWebMvcConfiguration.class).requestMappingHandlerAdapter(attributes.get(0), attributes.get(1), attributes.get(2)))).register(beanFactory);
    BeanDefinitionRegistrar.of("requestMappingHandlerMapping", RequestMappingHandlerMapping.class).withFactoryMethod(WebMvcAutoConfiguration.EnableWebMvcConfiguration.class, "requestMappingHandlerMapping", ContentNegotiationManager.class, FormattingConversionService.class, ResourceUrlProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(WebMvcAutoConfiguration.EnableWebMvcConfiguration.class).requestMappingHandlerMapping(attributes.get(0), attributes.get(1), attributes.get(2)))).customize((bd) -> bd.setPrimary(true)).register(beanFactory);
    org.springframework.boot.autoconfigure.web.servlet.HomeControllerTestContextInitializer.registerEnableWebMvcConfiguration_welcomePageHandlerMapping(beanFactory);
    BeanDefinitionRegistrar.of("localeResolver", LocaleResolver.class).withFactoryMethod(WebMvcAutoConfiguration.EnableWebMvcConfiguration.class, "localeResolver")
        .instanceSupplier(() -> beanFactory.getBean(WebMvcAutoConfiguration.EnableWebMvcConfiguration.class).localeResolver()).register(beanFactory);
    BeanDefinitionRegistrar.of("themeResolver", ThemeResolver.class).withFactoryMethod(WebMvcAutoConfiguration.EnableWebMvcConfiguration.class, "themeResolver")
        .instanceSupplier(() -> beanFactory.getBean(WebMvcAutoConfiguration.EnableWebMvcConfiguration.class).themeResolver()).register(beanFactory);
    BeanDefinitionRegistrar.of("flashMapManager", FlashMapManager.class).withFactoryMethod(WebMvcAutoConfiguration.EnableWebMvcConfiguration.class, "flashMapManager")
        .instanceSupplier(() -> beanFactory.getBean(WebMvcAutoConfiguration.EnableWebMvcConfiguration.class).flashMapManager()).register(beanFactory);
    BeanDefinitionRegistrar.of("mvcConversionService", FormattingConversionService.class).withFactoryMethod(WebMvcAutoConfiguration.EnableWebMvcConfiguration.class, "mvcConversionService")
        .instanceSupplier(() -> beanFactory.getBean(WebMvcAutoConfiguration.EnableWebMvcConfiguration.class).mvcConversionService()).register(beanFactory);
    BeanDefinitionRegistrar.of("mvcValidator", Validator.class).withFactoryMethod(WebMvcAutoConfiguration.EnableWebMvcConfiguration.class, "mvcValidator")
        .instanceSupplier(() -> beanFactory.getBean(WebMvcAutoConfiguration.EnableWebMvcConfiguration.class).mvcValidator()).register(beanFactory);
    BeanDefinitionRegistrar.of("mvcContentNegotiationManager", ContentNegotiationManager.class).withFactoryMethod(WebMvcAutoConfiguration.EnableWebMvcConfiguration.class, "mvcContentNegotiationManager")
        .instanceSupplier(() -> beanFactory.getBean(WebMvcAutoConfiguration.EnableWebMvcConfiguration.class).mvcContentNegotiationManager()).register(beanFactory);
    BeanDefinitionRegistrar.of("mvcPatternParser", PathPatternParser.class).withFactoryMethod(WebMvcConfigurationSupport.class, "mvcPatternParser")
        .instanceSupplier(() -> beanFactory.getBean(WebMvcConfigurationSupport.class).mvcPatternParser()).register(beanFactory);
    BeanDefinitionRegistrar.of("mvcUrlPathHelper", UrlPathHelper.class).withFactoryMethod(WebMvcConfigurationSupport.class, "mvcUrlPathHelper")
        .instanceSupplier(() -> beanFactory.getBean(WebMvcConfigurationSupport.class).mvcUrlPathHelper()).register(beanFactory);
    BeanDefinitionRegistrar.of("mvcPathMatcher", PathMatcher.class).withFactoryMethod(WebMvcConfigurationSupport.class, "mvcPathMatcher")
        .instanceSupplier(() -> beanFactory.getBean(WebMvcConfigurationSupport.class).mvcPathMatcher()).register(beanFactory);
    BeanDefinitionRegistrar.of("viewControllerHandlerMapping", HandlerMapping.class).withFactoryMethod(WebMvcConfigurationSupport.class, "viewControllerHandlerMapping", FormattingConversionService.class, ResourceUrlProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(WebMvcConfigurationSupport.class).viewControllerHandlerMapping(attributes.get(0), attributes.get(1)))).register(beanFactory);
    BeanDefinitionRegistrar.of("beanNameHandlerMapping", BeanNameUrlHandlerMapping.class).withFactoryMethod(WebMvcConfigurationSupport.class, "beanNameHandlerMapping", FormattingConversionService.class, ResourceUrlProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(WebMvcConfigurationSupport.class).beanNameHandlerMapping(attributes.get(0), attributes.get(1)))).register(beanFactory);
    BeanDefinitionRegistrar.of("routerFunctionMapping", RouterFunctionMapping.class).withFactoryMethod(WebMvcConfigurationSupport.class, "routerFunctionMapping", FormattingConversionService.class, ResourceUrlProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(WebMvcConfigurationSupport.class).routerFunctionMapping(attributes.get(0), attributes.get(1)))).register(beanFactory);
    BeanDefinitionRegistrar.of("resourceHandlerMapping", HandlerMapping.class).withFactoryMethod(WebMvcConfigurationSupport.class, "resourceHandlerMapping", ContentNegotiationManager.class, FormattingConversionService.class, ResourceUrlProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(WebMvcConfigurationSupport.class).resourceHandlerMapping(attributes.get(0), attributes.get(1), attributes.get(2)))).register(beanFactory);
    BeanDefinitionRegistrar.of("mvcResourceUrlProvider", ResourceUrlProvider.class).withFactoryMethod(WebMvcConfigurationSupport.class, "mvcResourceUrlProvider")
        .instanceSupplier(() -> beanFactory.getBean(WebMvcConfigurationSupport.class).mvcResourceUrlProvider()).register(beanFactory);
    BeanDefinitionRegistrar.of("defaultServletHandlerMapping", HandlerMapping.class).withFactoryMethod(WebMvcConfigurationSupport.class, "defaultServletHandlerMapping")
        .instanceSupplier(() -> beanFactory.getBean(WebMvcConfigurationSupport.class).defaultServletHandlerMapping()).register(beanFactory);
    BeanDefinitionRegistrar.of("handlerFunctionAdapter", HandlerFunctionAdapter.class).withFactoryMethod(WebMvcConfigurationSupport.class, "handlerFunctionAdapter")
        .instanceSupplier(() -> beanFactory.getBean(WebMvcConfigurationSupport.class).handlerFunctionAdapter()).register(beanFactory);
    BeanDefinitionRegistrar.of("mvcUriComponentsContributor", CompositeUriComponentsContributor.class).withFactoryMethod(WebMvcConfigurationSupport.class, "mvcUriComponentsContributor", FormattingConversionService.class, RequestMappingHandlerAdapter.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(WebMvcConfigurationSupport.class).mvcUriComponentsContributor(attributes.get(0), attributes.get(1)))).register(beanFactory);
    BeanDefinitionRegistrar.of("httpRequestHandlerAdapter", HttpRequestHandlerAdapter.class).withFactoryMethod(WebMvcConfigurationSupport.class, "httpRequestHandlerAdapter")
        .instanceSupplier(() -> beanFactory.getBean(WebMvcConfigurationSupport.class).httpRequestHandlerAdapter()).register(beanFactory);
    BeanDefinitionRegistrar.of("simpleControllerHandlerAdapter", SimpleControllerHandlerAdapter.class).withFactoryMethod(WebMvcConfigurationSupport.class, "simpleControllerHandlerAdapter")
        .instanceSupplier(() -> beanFactory.getBean(WebMvcConfigurationSupport.class).simpleControllerHandlerAdapter()).register(beanFactory);
    BeanDefinitionRegistrar.of("handlerExceptionResolver", HandlerExceptionResolver.class).withFactoryMethod(WebMvcConfigurationSupport.class, "handlerExceptionResolver", ContentNegotiationManager.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(WebMvcConfigurationSupport.class).handlerExceptionResolver(attributes.get(0)))).register(beanFactory);
    BeanDefinitionRegistrar.of("mvcViewResolver", ViewResolver.class).withFactoryMethod(WebMvcConfigurationSupport.class, "mvcViewResolver", ContentNegotiationManager.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(WebMvcConfigurationSupport.class).mvcViewResolver(attributes.get(0)))).register(beanFactory);
    BeanDefinitionRegistrar.of("mvcHandlerMappingIntrospector", HandlerMappingIntrospector.class).withFactoryMethod(WebMvcConfigurationSupport.class, "mvcHandlerMappingIntrospector")
        .instanceSupplier(() -> beanFactory.getBean(WebMvcConfigurationSupport.class).mvcHandlerMappingIntrospector()).customize((bd) -> bd.setLazyInit(true)).register(beanFactory);
    BeanDefinitionRegistrar.of("viewNameTranslator", RequestToViewNameTranslator.class).withFactoryMethod(WebMvcConfigurationSupport.class, "viewNameTranslator")
        .instanceSupplier(() -> beanFactory.getBean(WebMvcConfigurationSupport.class).viewNameTranslator()).register(beanFactory);
    org.springframework.boot.autoconfigure.web.servlet.HomeControllerTestContextInitializer.registerWebMvcAutoConfiguration_WebMvcAutoConfigurationAdapter(beanFactory);
    BeanDefinitionRegistrar.of("defaultViewResolver", InternalResourceViewResolver.class).withFactoryMethod(WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter.class, "defaultViewResolver")
        .instanceSupplier(() -> beanFactory.getBean(WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter.class).defaultViewResolver()).register(beanFactory);
    BeanDefinitionRegistrar.of("viewResolver", ContentNegotiatingViewResolver.class).withFactoryMethod(WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter.class, "viewResolver", BeanFactory.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter.class).viewResolver(attributes.get(0)))).register(beanFactory);
    BeanDefinitionRegistrar.of("requestContextFilter", RequestContextFilter.class).withFactoryMethod(WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter.class, "requestContextFilter")
        .instanceSupplier(() -> WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter.requestContextFilter()).register(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration", WebMvcAutoConfiguration.class)
        .instanceSupplier(WebMvcAutoConfiguration::new).register(beanFactory);
    BeanDefinitionRegistrar.of("formContentFilter", OrderedFormContentFilter.class).withFactoryMethod(WebMvcAutoConfiguration.class, "formContentFilter")
        .instanceSupplier(() -> beanFactory.getBean(WebMvcAutoConfiguration.class).formContentFilter()).register(beanFactory);
    org.springframework.boot.autoconfigure.jackson.HomeControllerTestContextInitializer.registerJacksonAutoConfiguration_Jackson2ObjectMapperBuilderCustomizerConfiguration(beanFactory);
    org.springframework.boot.autoconfigure.jackson.HomeControllerTestContextInitializer.registerJackson2ObjectMapperBuilderCustomizerConfiguration_standardJacksonObjectMapperBuilderCustomizer(beanFactory);
    BeanDefinitionRegistrar.of("spring.jackson-org.springframework.boot.autoconfigure.jackson.JacksonProperties", JacksonProperties.class)
        .instanceSupplier(JacksonProperties::new).register(beanFactory);
    org.springframework.boot.autoconfigure.jackson.HomeControllerTestContextInitializer.registerJacksonAutoConfiguration_JacksonObjectMapperBuilderConfiguration(beanFactory);
    org.springframework.boot.autoconfigure.jackson.HomeControllerTestContextInitializer.registerJacksonObjectMapperBuilderConfiguration_jacksonObjectMapperBuilder(beanFactory);
    org.springframework.boot.autoconfigure.jackson.HomeControllerTestContextInitializer.registerJacksonAutoConfiguration_ParameterNamesModuleConfiguration(beanFactory);
    org.springframework.boot.autoconfigure.jackson.HomeControllerTestContextInitializer.registerParameterNamesModuleConfiguration_parameterNamesModule(beanFactory);
    org.springframework.boot.autoconfigure.jackson.HomeControllerTestContextInitializer.registerJacksonAutoConfiguration_JacksonObjectMapperConfiguration(beanFactory);
    org.springframework.boot.autoconfigure.jackson.HomeControllerTestContextInitializer.registerJacksonObjectMapperConfiguration_jacksonObjectMapper(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration", JacksonAutoConfiguration.class)
        .instanceSupplier(JacksonAutoConfiguration::new).register(beanFactory);
    BeanDefinitionRegistrar.of("jsonComponentModule", JsonComponentModule.class).withFactoryMethod(JacksonAutoConfiguration.class, "jsonComponentModule")
        .instanceSupplier(() -> beanFactory.getBean(JacksonAutoConfiguration.class).jsonComponentModule()).register(beanFactory);
    org.springframework.boot.autoconfigure.http.HomeControllerTestContextInitializer.registerHttpMessageConvertersAutoConfiguration_StringHttpMessageConverterConfiguration(beanFactory);
    org.springframework.boot.autoconfigure.http.HomeControllerTestContextInitializer.registerStringHttpMessageConverterConfiguration_stringHttpMessageConverter(beanFactory);
    org.springframework.boot.autoconfigure.http.HomeControllerTestContextInitializer.registerJacksonHttpMessageConvertersConfiguration_MappingJackson2HttpMessageConverterConfiguration(beanFactory);
    org.springframework.boot.autoconfigure.http.HomeControllerTestContextInitializer.registerMappingJackson2HttpMessageConverterConfiguration_mappingJackson2HttpMessageConverter(beanFactory);
    org.springframework.boot.autoconfigure.http.HomeControllerTestContextInitializer.registerJacksonHttpMessageConvertersConfiguration(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration", HttpMessageConvertersAutoConfiguration.class)
        .instanceSupplier(HttpMessageConvertersAutoConfiguration::new).register(beanFactory);
    BeanDefinitionRegistrar.of("messageConverters", HttpMessageConverters.class).withFactoryMethod(HttpMessageConvertersAutoConfiguration.class, "messageConverters", ObjectProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(HttpMessageConvertersAutoConfiguration.class).messageConverters(attributes.get(0)))).register(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration", HttpEncodingAutoConfiguration.class).withConstructor(ServerProperties.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> new HttpEncodingAutoConfiguration(attributes.get(0)))).register(beanFactory);
    BeanDefinitionRegistrar.of("characterEncodingFilter", CharacterEncodingFilter.class).withFactoryMethod(HttpEncodingAutoConfiguration.class, "characterEncodingFilter")
        .instanceSupplier(() -> beanFactory.getBean(HttpEncodingAutoConfiguration.class).characterEncodingFilter()).register(beanFactory);
    org.springframework.boot.autoconfigure.web.servlet.HomeControllerTestContextInitializer.registerHttpEncodingAutoConfiguration_localeCharsetMappingsCustomizer(beanFactory);
    org.springframework.boot.test.autoconfigure.web.servlet.HomeControllerTestContextInitializer.registerMockMvcAutoConfiguration(beanFactory);
    BeanDefinitionRegistrar.of("dispatcherServletPath", DispatcherServletPath.class).withFactoryMethod(MockMvcAutoConfiguration.class, "dispatcherServletPath")
        .instanceSupplier(() -> beanFactory.getBean(MockMvcAutoConfiguration.class).dispatcherServletPath()).register(beanFactory);
    BeanDefinitionRegistrar.of("mockMvcBuilder", DefaultMockMvcBuilder.class).withFactoryMethod(MockMvcAutoConfiguration.class, "mockMvcBuilder", List.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(MockMvcAutoConfiguration.class).mockMvcBuilder(attributes.get(0)))).register(beanFactory);
    BeanDefinitionRegistrar.of("springBootMockMvcBuilderCustomizer", SpringBootMockMvcBuilderCustomizer.class).withFactoryMethod(MockMvcAutoConfiguration.class, "springBootMockMvcBuilderCustomizer")
        .instanceSupplier(() -> beanFactory.getBean(MockMvcAutoConfiguration.class).springBootMockMvcBuilderCustomizer()).register(beanFactory);
    BeanDefinitionRegistrar.of("mockMvc", MockMvc.class).withFactoryMethod(MockMvcAutoConfiguration.class, "mockMvc", MockMvcBuilder.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(MockMvcAutoConfiguration.class).mockMvc(attributes.get(0)))).register(beanFactory);
    BeanDefinitionRegistrar.of("dispatcherServlet", DispatcherServlet.class).withFactoryMethod(MockMvcAutoConfiguration.class, "dispatcherServlet", MockMvc.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(MockMvcAutoConfiguration.class).dispatcherServlet(attributes.get(0)))).register(beanFactory);
  }
}
