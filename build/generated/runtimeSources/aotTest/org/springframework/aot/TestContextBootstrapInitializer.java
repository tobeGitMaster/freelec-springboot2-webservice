package org.springframework.aot;

import java.lang.Class;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.springframework.aot.test.boot.AotSpringBootConfigContextLoader;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.test.context.SmartContextLoader;

public class TestContextBootstrapInitializer {
  public static Map<String, Supplier<SmartContextLoader>> getContextLoaders() {
    Map<String, Supplier<SmartContextLoader>> entries = new HashMap<>();
    entries.put("com.jojoldu.book.springboot.FreelecSpringboot2WebserviceApplicationTests", () -> new AotSpringBootConfigContextLoader(FreelecSpringboot2WebserviceApplicationTestsContextInitializer.class, WebApplicationType.SERVLET, SpringBootTest.WebEnvironment.MOCK));
    entries.put("com.jojoldu.book.springboot.web.HomeControllerTest", () -> new AotSpringBootConfigContextLoader(HomeControllerTestContextInitializer.class, WebApplicationType.SERVLET, SpringBootTest.WebEnvironment.NONE));
    return entries;
  }

  public static Map<String, Class<? extends ApplicationContextInitializer<?>>> getContextInitializers(
      ) {
    Map<String, Class<? extends ApplicationContextInitializer<?>>> entries = new HashMap<>();
    entries.put("com.jojoldu.book.springboot.FreelecSpringboot2WebserviceApplicationTests", FreelecSpringboot2WebserviceApplicationTestsContextInitializer.class);
    entries.put("com.jojoldu.book.springboot.web.HomeControllerTest", HomeControllerTestContextInitializer.class);
    return entries;
  }
}
