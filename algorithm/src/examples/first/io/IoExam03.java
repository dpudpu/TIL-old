package examples.first.io;

import java.io.*;

public class IoExam03 {
    // main메소드에서 Exception을 발생해도 무시하려면 throws Exception을 붙인다.
    public static void main(String[] args) throws Exception{
        String str = "hello world!";
        byte[] buffer = str.getBytes();

        InputStream in = new ByteArrayInputStream(buffer); // 배열을 파일로 생각하고 읽음
        OutputStream out = new FileOutputStream("/tmp/buffer.txt");

        CopyUtil.copy(in, out);

        InputStream in2 = new FileInputStream("/tmp/buffer.txt");
        OutputStream out2 = new ByteArrayOutputStream(); // 메모리에 담기때문에 파일이 커지면 메모리 부족 현상 위험

        CopyUtil.copy(in2, out2);

        byte[] result = ((ByteArrayOutputStream) out2).toByteArray();
        String str2 = new String(result);
        System.out.println(str2);
    }
}