package banco;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class MysqlBancoConexao extends BancoConexaoBase {

    @Override
    @Bean(name = "mysqlDataSource")
    public DataSource getDataSource() {
        return criarDataSource("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/viatech", "usuario_viatech", "viatech");
    }

    @Override
    @Bean(name = "mysqlJdbcTemplate")
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }
}
