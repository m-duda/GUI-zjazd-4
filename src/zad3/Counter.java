package zad3;

public class Counter extends Thread{
    Towar towar;
    private double sum=0;
    private int counter=0;

    Counter (Towar t){
        this.towar=t;
    }

    @Override
    public void run (){

        while (true){
            Towar tmp=towar.get();
            if (tmp==null){
                System.out.println(sum);
                return;
            }
            sum = sum + tmp.getWeight();
            counter++;
            if (counter%100==0){
                System.out.println("policzono wage "+counter+" towarów");
            }

        }

    }
}
