package my.examples.was;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebServletMapperManager {
    public Map<String, Class> findServlet(String baseDir){
        Map<String, Class> map = new HashMap<>();

        ClassFinder classFinder = new ClassFinder(baseDir);
        List<String> classList = classFinder.findAllClass();

        for(String className : classList){
            try {
                Class clazz = Class.forName(className);
                Annotation annotation = clazz.getAnnotation(WebServlet.class);
                if (annotation != null) {
                    // WebServlet의 value값을 출력한다.
                    WebServlet webServlet = (WebServlet) annotation;
                    String value = webServlet.value();

                    map.put(value, clazz);
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        } // for

        return map;
    } // findServlet
}
