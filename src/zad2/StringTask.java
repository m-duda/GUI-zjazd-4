package zad2;

public class StringTask implements Runnable {
    private String letter;
    private volatile static String word;
    private int number;
    private volatile int counter;
    private static int state;
    private static Thread t;

    public StringTask(String letter, int number) {
        this.letter = letter;
        this.number = number;
        state = -1;
        word="";
    }

    public String getResult(){
        return word;
    }

    public TaskState getState(){
        if (state==-1){
            return TaskState.CREATED;
        }
        else if (state==0) {
            return TaskState.ABORTED;
        }
        else if (state==1){
            return TaskState.RUNNING;
        }
        else return TaskState.READY;
    }

    public void start(){
        t = new  Thread(this);
        t.start();
    }

    public void abort(){
        state = 0;
        t.interrupt();
    }

    public boolean isDone(){
        if (getState()==TaskState.READY) {
            return true;
        }
        else if (getState()==TaskState.ABORTED) {
            return true;
        }
        else return false;
    }

    @Override
    public void run() {
        state=1;
        while (counter < number && state != 0&&!Thread.currentThread().isInterrupted()) {
            word = word + letter;
            counter++;
        }
        if (counter == number) {
            state = 2;
        }
    }    
}
