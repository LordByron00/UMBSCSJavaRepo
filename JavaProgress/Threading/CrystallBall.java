package JavaProgress.Threading;

import java.util.Random;

public class CrystallBall {

    public void ask(Question question) {
        System.out.println("Question: " + question.getQuestion());
        this.think(question);
        System.out.println("Answer: " + this.answer());

    }

    private void think(Question question) {
        System.out.println("*Thinking* Hmm...");
        try {
            Thread.sleep(this.difficultyTime(question.getDifficulty()));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private String answer() {
        String[] answers = {
                "Signs point to yes!",
                "Certainly!",
                "No opinion",
                "Answer is a little cloudy. Try again.",
                "Surely.",
                "No.",
                "Signs point to no.",
                "It could very well be!",
                "Definitely not",
                "You are totally fucked",
                "Unfortunately",
                "Unfortunately yes!"
        };
        return answers[new Random().nextInt(answers.length)];
    }

    private int difficultyTime(Question.Difficulty difficulty) {
        return switch (difficulty) {
            case EASY -> 1;
            case MEDIUM -> 1;
            case HARD -> 1;
        };

    }

}
