package examples.scopedbeans;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Notepad {

    public Notepad(){
        System.out.println("Notepad()");
    }
    // the details of this class are inconsequential to this example
}