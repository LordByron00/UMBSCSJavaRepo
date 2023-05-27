package JavaProgress.Threading;

public class Question {
    private final String question;
    private final Difficulty difficulty;

    public Question(Difficulty difficulty, String question) {
        this.question = question;
        this.difficulty = difficulty;
    }

    public Difficulty getDifficulty() {
        return this.difficulty;
    }


    enum Difficulty {
        EASY,
        MEDIUM,
        HARD
    }

    public String getQuestion() {
        return this.question;
    }

}