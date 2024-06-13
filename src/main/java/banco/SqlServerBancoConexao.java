package banco;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class SqlServerBancoConexao extends BancoConexaoBase {

    @Override
    @Bean(name = "sqlServerDataSource")
    public DataSource getDataSource() {
        return criarDataSource("com.microsoft.sqlserver.jdbc.SQLServerDriver", "jdbc:sqlserver://34.197.44.86;databaseName=viatech", "sa", "urubu100");
    }

    @Override
    @Bean(name = "sqlServerJdbcTemplate")
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }
}
