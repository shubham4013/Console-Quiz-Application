import java.util.*;

public class QuizApp {
    public static void main(String[] args) throws Exception {

        // Arraylist 
        
        List<Question> questions = QuestionLoader.loadQuestions("quiz_questions.txt");
        Scanner sc = new Scanner(System.in);
        int score = 0;

        System.out.println("Welcome to the Quiz!\n");

        for (Question q : questions) {
            System.out.println(q.getQuestion());
            for (String opt : q.getOptions()) {
                System.out.println(opt);
            }

            System.out.print("Your answer (A/B/C/D): ");
            char ans = sc.next().toUpperCase().charAt(0);

            if (ans == q.getCorrectAnswer()) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! Correct: " + q.getCorrectAnswer() + "\n");
            }
        }

        System.out.println("Your Score: " + score + "/" + questions.size());
        sc.close();
    }
}
