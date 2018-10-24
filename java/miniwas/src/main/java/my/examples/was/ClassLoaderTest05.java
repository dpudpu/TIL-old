package my.examples.was;


import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.Enumeration;
import java.util.List;

public class ClassLoaderTest05 {
    public static void main(String[] args) throws Exception{
        String baseDir = "C:/fastcampus/TIL/miniwas/target/classes/";
        ClassFinder classFinder = new ClassFinder(baseDir);
        List<String> allClass =
                classFinder.findAllClass();



        for(String className : allClass){
            Class clazz = Class.forName(className);
            Annotation annotation = clazz.getAnnotation(WebServlet.class);
            if(annotation != null){
                // WebServlet의 value값을 출력한다.
                WebServlet webServlet = (WebServlet)annotation;
                String value = webServlet.value();
                System.out.println(className + " :" + value);
            }
        }
    } // main
}