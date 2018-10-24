package examples.first.inteface;

public class MyServiceImpl implements MyService {
    private MyDAO dao;

    public MyServiceImpl(MyDAO dao) {
        this.dao = dao;
    }

    @Override
    public void hi() {

    }
}
