package uz.bakhodirov.census;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import uz.bakhodirov.census.dto.auth.AuthCreateDto;
import uz.bakhodirov.census.enums.Gender;
import uz.bakhodirov.census.enums.Role;
import uz.bakhodirov.census.properties.OpenApiProperties;
import uz.bakhodirov.census.properties.ServerProperties;
import uz.bakhodirov.census.services.auth.AuthUserService;

@SpringBootApplication
@OpenAPIDefinition
@RequiredArgsConstructor
@EnableConfigurationProperties({
        ServerProperties.class,
        OpenApiProperties.class}
)
public class SpringTemplateApplication {
    private final AuthUserService service;

    public static void main(String[] args) {
        SpringApplication.run(SpringTemplateApplication.class, args);
    }

    @Bean
    public void run() throws Exception {
        CommandLineRunner runner = (a) -> {
            AuthCreateDto user = AuthCreateDto.builder()
                    .fullName("Baxodirov Azizbek")
                    .role(Role.ADMIN.name())
                    .passportInfo("AB5701705")
                    .username("admin")
                    .password("123")
                    .address("Namangan viloyati")
                    .gender(Gender.MALE.name())
                    .phoneNumber("+998942790117")
                    .build();

            service.createUser(user);
        };
        runner.run("s", "b");
    }

}
