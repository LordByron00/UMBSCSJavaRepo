package JavaProgress.Threading;

import java.util.Arrays;
import java.util.List;

public class FortuneTeller {
    public static void main(String[] args) {

        List<Question> questions = Arrays.asList(
                new Question(Question.Difficulty.EASY, "Am I a good coder?"),
                new Question(Question.Difficulty.MEDIUM, "Will I be able to finish this course?"),
                new Question(Question.Difficulty.EASY, "Will it rain tomorrow?"),
                new Question(Question.Difficulty.EASY, "Will it snow today?"),
                new Question(Question.Difficulty.HARD, "Are you really all-knowing?"),
                new Question(Question.Difficulty.HARD, "Do I have any hidden talents?"),
                new Question(Question.Difficulty.HARD, "Will I live to be greater than 100 years old?"),
                new Question(Question.Difficulty.MEDIUM, "Will I be rich one day?"),
                new Question(Question.Difficulty.MEDIUM, "Should I clean my room?")
        );
        CrystallBall c = new CrystallBall();
        List<Thread> threads = questions.stream().map(q -> {
            Thread t = new Thread(() -> {
                c.ask(q);
            });
            return t;
        }).toList();

        Thread supervisor = createSupervisor(threads);
        supervisor.start();

    }

    public static Thread createSupervisor(List<Thread> threads) {

        Thread supervisor = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "Running");
            threads.forEach(g -> {
                g.start();
                List<String> runningThread;
                do {
                    runningThread = threads.stream().filter(Thread::isAlive).map(Thread::getName).toList();
                    if (!runningThread.isEmpty()) {
                        System.out.println(runningThread.toString());
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } while (!runningThread.isEmpty());
                try {
                    g.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            System.out.println(Thread.currentThread().getName() + " - All threads completed!");
        });

        supervisor.setName("supervisor");
        return supervisor;
    }

}
