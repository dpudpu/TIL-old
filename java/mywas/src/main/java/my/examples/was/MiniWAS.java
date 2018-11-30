package my.examples.was;

public class MiniWAS {
    public MiniWAS() {
        Connector connector = new Connector(8888);
        connector.start();
    }
}
