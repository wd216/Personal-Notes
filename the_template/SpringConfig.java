package the_template;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "the_template")
@PropertySource("classpath:application.properties")
@Import({ JDBCTemplateConfig.class })
public class SpringConfig {

}
