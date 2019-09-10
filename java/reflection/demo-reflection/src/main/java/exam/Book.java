package exam;

@MyAnnotation(name = "bedi")
public class Book {
    private String a = "a";
    private static String B = "b";
    private static final String C = "c";
    protected String d = "d";
    public String e = "e";

    public Book(final String a, final String d, final String e) {
        this.a = a;
        this.d = d;
        this.e = e;
    }

    public Book() {
    }

    private void f(){
        System.out.println("F");
    }

    public void g(){
        System.out.println("G");
    }

    public int h(){
        return 100;
    }
}
