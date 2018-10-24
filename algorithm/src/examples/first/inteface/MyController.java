package examples.first.inteface;

public class MyController {
    private MyService service;

    public MyController(MyService service) {
        this.service = service;
    }

    public void hello(){

    }
}

