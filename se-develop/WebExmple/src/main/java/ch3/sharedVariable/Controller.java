
package ch3.sharedVariable;

import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet(urlPatterns={"/ch3/sharedVariable/Controller"})
public class Controller 
extends ch3.sharedVariable.error.Controller 
{       
    public void incrementSharedVariable() {
        synchronized (this) {
            int temp = accessCount;
            temp++;
            System.out.println(temp);
            try {
              Thread.sleep(3000);
            } catch (java.lang.InterruptedException ie) {
              //Just keep going
            }
            accessCount = temp;
        }
    }  
}
