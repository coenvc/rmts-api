import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by fhict on 28/03/2017.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket prospectsApi(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .apiInfo(apiInfo()).select().paths(prospectPaths()).build();
    }

    @Bean
    private Predicate<String> prospectPaths() {
        return or(regex("/.*/.*"));
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("RMTS API")
                .description("RMTS Reference APi")
                .version("3.0")
                .build();
    }


}
