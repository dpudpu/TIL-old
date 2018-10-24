package my.examples.was;

public class RequestLineExam {
    public static void main(String[] args){
        String str1 = "GET / HTTP/1.1";

        String str2 = "GET /abc/index.html HTTP/1.1";

        String str3 = "GET /../windows/system32 HTTP/1.1";

        // 문자열을 나눈다.
        // 1. String 클래스가 가지는 메소드 사용.
        // 2. 정규표현식을 사용하는 방법.
        // 3. 파서를 만든다. http://www.antlr.org/ (파서생성기)

        String[] split = str2.split(" ");
        String method = null;
        String path = null;
        if(split.length > 2){
            method = split[0];
            path = split[1];
        }

        System.out.println(method);
        System.out.println(path);

        String header = "word: hel:lo";
        int index1 = header.indexOf(':');
        String headerName = null;
        String headerValue = null;
        if(index1 != -1) {
            headerName = header.substring(0, index1);
            headerValue = header.substring(index1 + 1).trim();
        }
        System.out.println(headerName);
        System.out.println(headerValue);
    }
}
