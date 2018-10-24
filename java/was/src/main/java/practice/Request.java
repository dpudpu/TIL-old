package practice;

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
            String requestLine = br.readLine();
            System.out.println(requestLine);
            String[] str = requestLine.split(" ");
            if (str.length > 2) {
                method = str[0];
                path = str[1];
            }


            String line = null;
            while ((line = br.readLine()) != null) {
                if (line.equals(""))
                    break;
                int index1 = line.indexOf(":");
                String headerName = null;
                String headerValue = null;

                if (index1 != -1) {
                    headerName = line.substring(0, index1);
                    headerValue = line.substring(index1 + 1).trim();
                }
                headers.put(headerName, headerValue);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public InputStream getIn() {
        return in;
    }

    public BufferedReader getBr() {
        return br;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getPath() {
        return path;
    }

    public String getMethod() {
        return method;
    }


}
