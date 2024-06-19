import java.util.*;

public class QuizApplication {

    private Quiz quiz;
    private Scanner scanner;
    private int score;

    public QuizApplication() {
        quiz = new Quiz();
        scanner = new Scanner(System.in);
        score = 0;
    }

    // Setup the quiz with some questions
    public void setupQuiz() {
        List<String> options1 = new ArrayList<>();
        options1.add("Java");
        options1.add("Python");
        options1.add("C++");
        options1.add("JavaScript");

        List<String> options2 = new ArrayList<>();
        options2.add("1991");
        options2.add("1995");
        options2.add("2000");
        options2.add("2005");

        List<String> options3 = new ArrayList<>();
        options3.add("Guido van Rossum");
        options3.add("James Gosling");
        options3.add("Bjarne Stroustrup");
        options3.add("Brendan Eich");

        quiz.addQuestion(new Question("Which programming language is known as the 'write once, run anywhere' language?", options1, "Java"));
        quiz.addQuestion(new Question("In which year was Java released?", options2, "1995"));
        quiz.addQuestion(new Question("Who is the creator of Java?", options3, "James Gosling"));
    }

    // Start the quiz and handle the user interaction
    public void startQuiz() {
        System.out.println("Welcome to the Quiz!");
        for (Question question : quiz.getQuestions()) {
            System.out.println(question.getQuestionText());
            for (int i = 0; i < question.getOptions().size(); i++) {
                System.out.println((i + 1) + ": " + question.getOptions().get(i));
            }
            int userAnswer = getUserAnswer(question.getOptions().size());
            evaluateAnswer(question, userAnswer);
        }
        System.out.println("Your final score is: " + score + "/" + quiz.getQuestions().size());
    }

    // Get user answer with input validation
    private int getUserAnswer(int numOptions) {
        int answer = -1;
        while (answer < 1 || answer > numOptions) {
            System.out.print("Your answer (1-" + numOptions + "): ");
            if (scanner.hasNextInt()) {
                answer = scanner.nextInt();
                if (answer < 1 || answer > numOptions) {
                    System.out.println("Please enter a number between 1 and " + numOptions);
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
            }
        }
        return answer;
    }

    // Evaluate user answer and provide feedback
    private void evaluateAnswer(Question question, int userAnswer) {
        if (question.getOptions().get(userAnswer - 1).equals(question.getCorrectAnswer())) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Wrong! The correct answer is " + question.getCorrectAnswer());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QuizApplication app = new QuizApplication();
        app.setupQuiz();
        app.startQuiz();
    }

}
