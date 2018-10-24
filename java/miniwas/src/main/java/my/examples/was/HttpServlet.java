package my.examples.was;

public abstract class HttpServlet {

    public void init(){

    }

    public void doGet(Request request, Response response){

    }

    public void doPost(Request request, Response response){

    }

    public void destroy(){

    }

    public void service(Request request, Response response){
        if("GET".equals(request.getMethod().toUpperCase())){
            doGet(request, response);
        }else if("POST".equals(request.getMethod().toUpperCase())){
            doPost(request, response);
        }
    }
}
