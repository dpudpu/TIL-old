package my.examples.was;



import java.util.Map;
import java.util.Set;

public class ClassLoaderTest06 {
    public static void main(String[] args) throws Exception{
        String baseDir = "C:/fastcampus/TIL/miniwas/target/classes/";
        WebServletMapperManager wsmm = new WebServletMapperManager();
        Map<String, Class> map = wsmm.findServlet(baseDir);

        Set<String> paths = map.keySet();
        for(String path : paths){
            System.out.println(path + " : " + map.get(path).getName());
        }

    } // main
}