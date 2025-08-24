import java.io.*;
import java.util.*;

public class QuestionLoader {
    public static List<Question> loadQuestions(String filePath) throws IOException {
        List<Question> questions = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("Q:")) {
                String question = line.substring(2).trim();
                String[] options = new String[4];
                for (int i = 0; i < 4; i++) {
                    options[i] = reader.readLine();
                }
                String answerLine = reader.readLine();
                char correctAnswer = answerLine.split(":")[1].trim().charAt(0);
                questions.add(new Question(question, options, correctAnswer));
            }
        }

        reader.close();
        return questions;
    }
}
