package Utilities;

public class Perf {

  private Perf() {}

  public static void measure(Runnable task) {
    Runtime runtime = Runtime.getRuntime();
    runtime.gc();

    long beforeMem = runtime.totalMemory() - runtime.freeMemory();
    long startTime = System.nanoTime();

    task.run();

    long endTime = System.nanoTime();
    long afterMem = runtime.totalMemory() - runtime.freeMemory();

    System.out.printf(
        "Time: %d ns, Memory: %d KB%n",
        (endTime - startTime) / 1_000, (afterMem - beforeMem) / 1024);
  }

  public static <T> T measure(java.util.concurrent.Callable<T> task) {
    Runtime runtime = Runtime.getRuntime();
    runtime.gc();

    long beforeMem = runtime.totalMemory() - runtime.freeMemory();
    long startTime = System.nanoTime();

    T result;
    try {
      result = task.call();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    long endTime = System.nanoTime();
    long afterMem = runtime.totalMemory() - runtime.freeMemory();

    System.out.printf(
        "Time: %d ns, Memory: %d KB%n",
        (endTime - startTime) / 1_000, (afterMem - beforeMem) / 1024);

    return result;
  }
}
