package examples.boot.springboard.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Iterator;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    // 1번째 방법
    @Autowired
    Environment environment;
    @Autowired
    ServerInfoConfig serverInfoConfig;

    //  2번째 방법
//    @Value("${serverinfo.ip}")
//    String ip;
//
//    @Value("${serverinfo.port}")
//    int port;

    @Bean
    public ServerInfo serverInfo() {
//        for (Iterator it = ((AbstractEnvironment) environment).getPropertySources().iterator(); it.hasNext(); ) {
//            PropertySource propertySource = (PropertySource) it.next();
//            if (propertySource instanceof MapPropertySource) {
//                String[] propertyNames = ((MapPropertySource) propertySource).getPropertyNames();
//                for (int i = 0; i < propertyNames.length; i++) {
//                    System.out.println(propertyNames[i] + ", " + propertySource.getProper(propertyNames[i]));
//                }
//            }
//        }
        ServerInfo serverInfo = new ServerInfo();
// 1번째방법
        serverInfo.setIp(environment.getProperty("serverinfo.ip"));
        serverInfo.setPort(Integer.parseInt(environment.getProperty("serverinfo.port")));
        System.out.println(serverInfo.getPort());


        serverInfo.setIp(serverInfoConfig.getIp());
        serverInfo.setPort(serverInfoConfig.getPort());
        System.out.println("-----");
        System.out.println(serverInfoConfig.getHardware().getCpu());
        System.out.println("-----");

        return serverInfo;
    }

}
