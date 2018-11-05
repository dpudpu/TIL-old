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

## 필독 
에러가 난다면 username을 확인해봐야한다. 
username은 윈도우 계정명과 겹쳐서 root가 아닌 윈도우 유저명이 넘어가서 에러가 났다.
