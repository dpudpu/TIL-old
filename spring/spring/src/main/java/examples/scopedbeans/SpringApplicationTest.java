package examples.scopedbeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplicationTest {
    public static void main(String[] args) throws Exception{
        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("scoped-beans.xml");
        System.out.println("-------------------------");
        Notepad notepad1 = applicationContext.getBean(Notepad.class);
        Notepad notepad2 = applicationContext.getBean(Notepad.class);
        System.out.println("-------------------------");
        UniqueThing uniqueThing1 = applicationContext.getBean(UniqueThing.class);
        UniqueThing uniqueThing2 = applicationContext.getBean(UniqueThing.class);

    }
}