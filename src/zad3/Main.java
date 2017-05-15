/**
 *
 *  @author Duda MichaĹ‚ S14228
 *
 */

package zad3;

import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    Towar towar = new Towar(0,0.0);
    Thread threadReader = new Reader(towar);
    Thread threadCounter = new Counter(towar);
    threadReader.start();
    threadCounter.start();
  }
}

