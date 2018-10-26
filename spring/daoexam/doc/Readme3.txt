Spring JUnit Test

1. pom.xml ���Ͽ� ������ �߰�

		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-test</artifactId>
			<version>${spring.version}</version>
		</dependency>

        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>

2. DataSource�κ��� ������ ���� ����

DataSource��ü�� ��������� �ڵ����� schema.sql �� �����Ѵ�.

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        DatabasePopulatorUtils.execute(createDatabasePopulator(), dataSource);
        return dataSource;
    }

    private DatabasePopulator createDatabasePopulator() {
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        databasePopulator.setContinueOnError(true);
        databasePopulator.addScript(new ClassPathResource("schema.sql"));
        return databasePopulator;
    }

3. Test Ŭ������ �ۼ�

Controller --> Service --> Dao

Service�� �޼ҵ带 �׽�Ʈ.

* ���� �׽�Ʈ�� ��������?
* ���� �׽�Ʈ�� ��������?
* JUnit �� ��������?
* Mock �� ��������?
* ���� ������ ��� �ұ�?

test/java/ ��Ű���� / Ŭ������ �ۼ�


@RunWith �� JUnit �� �����ϴ� �ֳ����̼��ε�, Ȯ������ �����Ѵ�.

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
���� 2���� �������� JUnit�� ����� Ȯ���Ͽ� ApplicationConfig.class��
�о�鿩 ���������� ApplicationContext�� �����Ѵ�.


package examples.daoexam.dao;

import examples.daoexam.config.ApplicationConfig;
import examples.daoexam.config.DBConfig;
import examples.daoexam.dto.Board;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class BoardDaoTest {

    @Test
    public void init(){

    }

}