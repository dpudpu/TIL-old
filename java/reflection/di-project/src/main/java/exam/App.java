package exam;

import di.ContainerService;

public class App {
    public static void main(String[] args) {
        AccoutService accoutService = ContainerService.getObject(AccoutService.class);
        accoutService.join();
    }
}
