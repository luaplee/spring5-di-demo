package guru.springframework.config;

import guru.springframework.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {

    @Bean
    GreetingServiceFactory greetingServiceFactory(GreetingRepository greetingRepository) {
        return new GreetingServiceFactory(greetingRepository);
    }

    @Bean
    @Primary
    @Profile("de")
    GreetingService primaryGermanGreetingService(GreetingRepository greetingRepository) {
        return new PrimaryGermanGreetingService(greetingRepository);
    }


    @Bean
    @Primary
    @Profile({"default", "en"})
    GreetingService primaryGreetingService(GreetingRepository greetingRepository) {
        return new PrimaryGreetingService(greetingRepository);
    }


    @Bean
    @Primary
    @Profile("es")
    GreetingService primarySpanishGreetingService(GreetingRepository greetingRepository) {
        return new PrimarySpanishGreetingService(greetingRepository);
    }
}
