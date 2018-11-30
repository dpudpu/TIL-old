package my.examples.was;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Request {
    private InputStream in;
    private BufferedReader br;
    private Map<String, String> headers;
    private String path;
    private String method;


    public Request(InputStream in, BufferedReader br) {
        this.in = in;
        this.br = br;
        headers = new HashMap<>();

        try {
            String reqeustLine = br.readLine();
            String[] split = reqeustLine.split(" ");
            if(split.length>2){
                method = split[0];
                path = split[1];
            }

            String line;
            while((line=br.readLine())!=null){
                if(line.equals(""))
                    break;
                int index = line.indexOf(":");
                String headerName = null;
                String headerValue = null;

                if(index!=-1){
                    headerName = line.substring(0,index);
                    headerValue = line.substring(index+1).trim();
                }
                headers.put(headerName, headerValue);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPath() {
        return path;
    }

    public String getMethod() {
        return method;
    }
}