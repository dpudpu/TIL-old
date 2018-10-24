package examples.first.io;

import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class IoQuiz02 {
    public static void main(String args[]){

        Calendar cal = Calendar.getInstance();
        String fileName="\\tmp\\"+cal.get(Calendar.YEAR)+"\\"+String.format("%02d",cal.get(Calendar.MONTH)+1)+"\\"+cal.get(Calendar.DATE);
        System.out.println(fileName);

        File file = new File(fileName);
        if(!file.exists()){
            file.mkdirs();
        }
    }
}
