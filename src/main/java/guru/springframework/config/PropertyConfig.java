package guru.springframework.config;

import guru.springframework.examplebeans.FakeDataSource;
import guru.springframework.examplebeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertyConfig {

    @Value("${paul.username}")
    String user;

    @Value("${paul.password}")
    String password;

    @Value("${paul.dburl}")
    String url;

    @Value("${paul.jms.username}")
    String jmsUsername;

    @Value("${paul.jms.password}")
    String jmsPassword;

    @Value("${paul.jms.url}")
    String jmsUrl;

    @Bean
    public FakeDataSource fakeDataSource(){

        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(user);
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);

        return fakeDataSource;
    }

    @Bean
    public FakeJmsBroker fakeJmsBroker(){

        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
        fakeJmsBroker.setUser(jmsUsername);
        fakeJmsBroker.setPassword(jmsPassword);
        fakeJmsBroker.setUrl(jmsUrl);

        return fakeJmsBroker;
    }

}
