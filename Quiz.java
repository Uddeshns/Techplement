package Techplement.Week_1_Test;
import java.util.ArrayList;
import java.util.List;

// Class quiz
class Quiz {
    private List<Question> questions;

    public Quiz() {
        questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
