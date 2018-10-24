package examples.daoexam.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@EnableTransactionManagement
public class DBConfig {
    private String driverClassName = "com.mysql.jdbc.Driver";

    private String url = "jdbc:mysql://localhost:3306/testdb?useUnicode=true&characterEncoding=utf8";

    private String username = "root";

    private String password = "root";

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
    
    
    @Bean
    public PlatformTransactionManager transactionManger(DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }
}