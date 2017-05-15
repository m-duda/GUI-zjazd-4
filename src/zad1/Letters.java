package zad1;

import java.util.ArrayList;
import java.util.List;

public class Letters {
	
    private List <Thread> watki = new ArrayList <Thread>();

    public Letters(String letters) {
        for (char a : letters.toCharArray()){
        	watki.add(new Thread ( () -> {
                while (true) {
                    System.out.print (a);
                	try {
                        Thread.sleep(1000);
                    } catch(InterruptedException exc) {
                        return;
                    }
                }
        	}, "Thread "+a));
       }
    }

    public List<Thread> getThreads (){
        return watki;
    }
}