package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QuizMain {
	private static Connection connection;

    public static void main(String[] args) throws SQLException {

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "");

        // Create a new quiz
        Quiz quiz = new Quiz();
        quiz.setTitle("My First Quiz");
        quiz.setDescription("This is my first quiz.");
        Question question1 = new Question();
        question1.setQuestion("which is the largest coffee producing state in India?");
        question1.setAnswer("Kerala");

        Question question2 = new Question();
        question2.setQuestion("which state has the largest area?");
        question2.setAnswer("rajasthan");
        
        Question question2 = new Question();
        question2.setQuestion("which state has the largest population?");
        question2.setAnswer("Bihar");


        quiz.addQuestion(question1);
        quiz.addQuestion(question2);
        quiz.addQuestion(question3);

        // Save the quiz to the database
        saveQuiz(quiz);

        // Delete a quiz
        int quizId = 1;
        deleteQuiz(quizId);

        // Update a quiz
        int quizId = 2;
        Quiz quiz2 = new Quiz();
        quiz2.setTitle("My Second Quiz");
        quiz2.setDescription("This is my second quiz.");
        updateQuiz(quizId, quiz2);
        
        int quizId = 3;
        Quiz quiz2 = new Quiz();
        quiz3.setTitle("My Second Quiz");
        quiz3.setDescription("This is my Third quiz.");
        updateQuiz(quizId, quizz3);

        // Close the connection to the database
        connection.close();
    }

    private static void saveQuiz(Quiz quiz) throws SQLException {

        PreparedStatement statement = connection.prepareStatement("INSERT INTO quizzes (title, description) VALUES (?, ?)");
        statement.setString(1, quiz.getTitle());
        statement.setString(2, quiz.getDescription());
        statement.executeUpdate();

        // Get the id of the newly created quiz
        int quizId = statement.getGeneratedKeys().getInt(1);

        // Add questions to the quiz
        for (Question question : quiz.getQuestions()) {
            PreparedStatement statement2 = connection.prepareStatement("INSERT INTO questions (quiz_id, question, answer) VALUES (?, ?, ?)");
            statement2.setInt(1, quizId);
            statement2.setString(2, question.getQuestion());
            statement2.setString(3, question.getAnswer());
            statement2.executeUpdate();
        }
    }

    private static void deleteQuiz(int quizId) throws SQLException {

        PreparedStatement statement = connection.prepareStatement("DELETE FROM quizzes WHERE id = ?");
        statement.setInt(1, quizId);
        statement.executeUpdate();
    }

    private static void updateQuiz(int quizId, Quiz quiz) throws SQLException {

        PreparedStatement statement = connection.prepareStatement("UPDATE quizzes SET title = ?, description = ? WHERE id = ?");
        statement.setString(1, quiz.getTitle());
        statement.setString(2, quiz.getDescription());
        statement.setInt(3, quizId);
        statement.executeUpdate();

        // Delete all questions from the quiz
        PreparedStatement statement2 = connection.prepareStatement("DELETE FROM questions WHERE quiz_id = ?");
        statement2.setInt(1, quizId);
        statement2.executeUpdate();

        // Add new questions to the quiz
        for (Question question : quiz.getQuestions()) {
            PreparedStatement statement3 = connection.prepareStatement("INSERT INTO questions (quiz_id, question, answer) VALUES (?, ?, ?)");
            statement3.setInt(1, quizId);
            statement3.setString(2, question.getQuestion());
            statement3.setString(3, question.getAnswer());
            statement3.executeUpdate();
        }
    }
}



