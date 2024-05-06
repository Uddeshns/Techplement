package Techplement.Week_1_Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class UserGeneratedQuiz  {  // Main class
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        // Add questions to the quiz
        addQuestionsToQuiz(quiz);

        // Display the quiz Q and A
        displayQuiz(quiz);

        scanner.close();
    }

    private static void addQuestionsToQuiz(Quiz quiz) {
        System.out.println("Welcome to Quiz Generator!");
        System.out.println("Please enter your quiz questions:");
        System.out.println("(Enter 'done' to finish)");

        while (true) {
            System.out.print("Enter question: ");
            String questionText = scanner.nextLine();
            
            //end check statement
            if (questionText.equalsIgnoreCase("done")) {
                break;
            }

            // Input options for the question
            List<String> options = new ArrayList<>();
            for (char option = 'A'; option <= 'D'; option++) {
                System.out.print("Enter option " + option + ": ");
                String optionText = scanner.nextLine();
                options.add(optionText);
            }

            // Correct Ans
            System.out.print("Enter correct answer index (A=0, B=1, C=2, D=3): ");
            int correctOptionIndex = scanner.nextInt();
            scanner.nextLine(); // consume newline character
            
            // Create Question object and add it to the quiz
            Question question = new Question(questionText, options, correctOptionIndex);
            quiz.addQuestion(question);
        }
    }

    private static void displayQuiz(Quiz quiz) {
        List<Question> questions = quiz.getQuestions();
        int totalQuestions = questions.size();
        int score = 0;

        System.out.println("\nHere's your generated quiz:");
        System.out.println("----------------------------");

        
        for (int i = 0; i < totalQuestions; i++) {
            Question question = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + question.getQuestionText());
            
            
            List<String> options = question.getOptions();
            for (int j = 0; j < options.size(); j++) {
                System.out.println((char)('A' + j) + ") " + options.get(j));
            }

            // Take user input for answer
            System.out.print("Your answer: ");
            char userAnswer = scanner.next().charAt(0);
            int userOptionIndex = userAnswer - 'A';

            // Check answer is correct
            if (userOptionIndex == question.getCorrectOptionIndex()) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
            }

            System.out.println("----------------------------");
        }

        // Display quiz results
        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score + "/" + totalQuestions);
        double percentage = (double) score / totalQuestions * 100;
        System.out.println("Percentage: " + percentage + "%");

        // Provide score
        if (percentage >= 70) {
            System.out.println("Congratulations! You passed the quiz.");
        } else {
            System.out.println("You need to study more. Try again!");
        }
    }
}