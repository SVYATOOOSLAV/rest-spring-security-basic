package by.svyat.spring.security.basic.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import static by.svyat.spring.security.basic.config.DbConfig.POSTGRES_JDBC_TEMPLATE;

@Repository
public class UserDaoRepository {

    private final String CREATE_USER = """
            insert into users (username, password, enabled) values (:username,:password,:enabled)
            """;

    private final String ADD_ROLE = """
            insert into authorities (username, authority) values (:username,:authority)
            """;

    @Qualifier(POSTGRES_JDBC_TEMPLATE)
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public UserDaoRepository(
            @Qualifier(POSTGRES_JDBC_TEMPLATE)
            NamedParameterJdbcTemplate jdbcTemplate
    ){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createUser(UserDetails user) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("username", user.getUsername())
                .addValue("password", user.getPassword())
                .addValue("enabled", user.isEnabled() ? 1 : 0);

        jdbcTemplate.update(CREATE_USER, params);
    }

    public void addRole(UserDetails user) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("username", user.getUsername())
                .addValue("authority", user.getAuthorities()
                        .iterator().next().getAuthority());

        jdbcTemplate.update(ADD_ROLE, params);
    }
}
