package by.svyat.spring.security.basic.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DbConfig {

    private static final String POSTGRES_DATASOURCE_PROPERTIES = "postgresDatasourceProperties";
    public static final String POSTGRES_JDBC_TEMPLATE = "postgresJdbcTemplate";
    private static final String POSTGRES_SETTINGS = "spring.datasource";
    private static final String POSTGRES_HIKARI = "spring.datasource.hikari";

    @Bean(POSTGRES_DATASOURCE_PROPERTIES)
    @ConfigurationProperties(POSTGRES_SETTINGS)
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties(POSTGRES_HIKARI)
    public DataSource dataSource(
            @Qualifier(POSTGRES_DATASOURCE_PROPERTIES)
            DataSourceProperties properties
    ) {
        return properties.initializeDataSourceBuilder().build();
    }

    @Bean(POSTGRES_JDBC_TEMPLATE)
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
