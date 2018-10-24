package examples.first.inteface;

public class MyMain {
    public static void main(String args[]){
        MyDAO dao = new MyDAOImpl();
        MyService service = new MyServiceImpl(dao);
        MyController controller = new MyController(service);

    }
}
