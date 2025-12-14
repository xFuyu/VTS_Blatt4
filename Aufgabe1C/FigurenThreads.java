public class FigurenThreads {
  public static void main(String[] args) {
    Figur f = new MeineFigur();

    Thread schreiber = new Schreiber(f);
    Thread leser = new Leser(f);

    // TODO: beide daemon
    schreiber.setDaemon(true);
    leser.setDaemon(true);

    schreiber.start();
    leser.start();
	try{
    leser.join();
	} catch (InterruptedException e) {
	}
    // TODO: beide starten

    // Hinweis: Wenn main sofort endet, endet das Programm bei daemon-Threads sofort mit.
    // (D.h. evtl. musst du main kurz am Leben halten, damit Leser überhaupt drucken kann.)i

  }
}

