package my.examples.was;

public class ClassLoaderTest02 {
    public static void main(String[] args) throws Exception{
        Sample s1 = new Sample();
        s1.print();
        s1.print("world");

        Class clazz = Class.forName("my.examples.was.Sample");
        Sample sample = (Sample)clazz.newInstance();
        sample.print();
        sample.print("world");
    }
}
