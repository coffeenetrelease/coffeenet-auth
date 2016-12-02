package coffee.synyx.auth.config.dev;

import coffee.synyx.auth.oauth.client.web.AuthClient;

import org.slf4j.Logger;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

import javax.annotation.PostConstruct;

import static org.slf4j.LoggerFactory.getLogger;

import static java.lang.invoke.MethodHandles.lookup;


/**
 * @author  Yannic Klem - klem@synyx.de
 */
@Configuration
@DependsOn("liquibase")
@ConditionalOnProperty(prefix = "coffeenet", name = "development", havingValue = "true", matchIfMissing = true)
public class LiquibaseConfiguration {

    private static final Logger LOGGER = getLogger(lookup().lookupClass());

    private final JdbcClientDetailsService jdbcClientDetailsService;

    public LiquibaseConfiguration(JdbcClientDetailsService jdbcClientDetailsService) {

        this.jdbcClientDetailsService = jdbcClientDetailsService;
    }

    @PostConstruct
    void createDefaultClient() {

        AuthClient authClient = new AuthClient();
        authClient.setAutoApprove(true);
        authClient.setClientId("coffeeNetClient");
        authClient.setClientSecret("coffeeNetClientSecret");
        authClient.getScope().add("openid");
        jdbcClientDetailsService.addClientDetails(authClient);

        LOGGER.info("Added default OAuth Client: coffeeNetClient/coffeeNetClientSecret");
    }
}
