#### 1. @PropertySource("classpath:jdbc.properties")
#### 2. @Autowired private Environment environment; 추가 

```java
@Configuration
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement
public class DBConfig {

    @Autowired
    private Environment environment;


    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(environment.getProperty("driverClassName"));
        dataSource.setUrl(environment.getProperty("url"));
        dataSource.setUsername(environment.getProperty("username"));
        dataSource.setPassword(environment.getProperty("password"));
        return dataSource;
    }


    @Bean
    public PlatformTransactionManager transactionManger(DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }
}

```

#### 3. src/main/resouces/properties 추가

```
 driverClassName=com.mysql.jdbc.Driver
 url=jdbc:mysql://localhost:3306/ffboard?useUnicode=true&characterEncoding=utf8
 username=아이디
 password=비번
```
