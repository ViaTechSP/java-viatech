package banco;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


public class BancoConexao {
    private JdbcTemplate conexaoDoBanco;



    public BancoConexao() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/viatech");
        dataSource.setUsername("root");
        dataSource.setPassword("33010092003");

        conexaoDoBanco = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getBancoConexao() {
        return conexaoDoBanco;
    }

}