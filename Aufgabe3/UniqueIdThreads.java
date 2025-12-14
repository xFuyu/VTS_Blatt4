import java.util.*;
import java.io.*;

public class UniqueIdThreads {

  static class Worker extends Thread {
    private final UniqueId uid;
    private final Set<Integer> seen;
    private final int n;

    Worker(UniqueId uid, Set<Integer> seen, int n) {
      this.uid = uid;
      this.seen = seen;
      this.n = n;
    }

    public void run() {
      for (int i = 0; i < n; i++) {
	      try{
         int id = uid.getNext();
         if( seen.add(id) ==  false){System.out.println("DUPLIKAT: " + id);}
      } catch(IOException e) {
      	System.out.println("IO Fehler i, Worker: " + e.getMessage()); return;
      }
      }
    }
  }

  public static void main(String[] args) throws Exception {
    UniqueId uid = new UniqueId("id.dat");
    uid.init(0);

    // threads/iterationen einstellen
    int THREADS = 4;
    int PRO_THREAD = 200;

    // Thread-sicheres Set zum Prüfen von Duplikaten
    Set<Integer> seen = Collections.synchronizedSet(new HashSet<>());

    //THREADS Worker erzeugen, starten, joinen
	Worker[] ws = new Worker[THREADS];
	for (int i = 0; i < THREADS  ; i++){
		ws[i] = new Worker(uid, seen, PRO_THREAD);
		ws[i].start();
	}	
	for (int i = 0; i < THREADS  ; i++){
		ws[i].join();
	}
    // TODO: am Ende: erwartete Anzahl vs. seen.size() ausgeben
    	
	int expected = THREADS * PRO_THREAD;

	int actual = seen.size();

	System.out.println("expected=" + expected + " actual=" + actual);
	}
}

