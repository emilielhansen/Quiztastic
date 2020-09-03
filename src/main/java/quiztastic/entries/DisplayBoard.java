package quiztastic.entries;

import quiztastic.app.MapQuestionRepository;
import quiztastic.app.QuestionReader;
import quiztastic.core.Board;
import quiztastic.domain.BoardController;
import quiztastic.domain.QuestionRepository;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;

public class DisplayBoard {
    private final BoardController boardController;

    public DisplayBoard() {
        InputStream s = this.getClass()
                .getClassLoader()
                .getResourceAsStream("master_season1-35clean.tsv");
        QuestionReader reader = new QuestionReader(new InputStreamReader(s));
        QuestionRepository questionRepository =
                null;
        try {
            questionRepository = MapQuestionRepository.fromQuestionReader(reader);
        } catch (IOException e) {
            System.out.println("Forventede at..");;
        } catch (ParseException e) {
            System.out.println("Forventede at..");;
        }
        this.boardController = new BoardController(questionRepository);
    }

    public void displayBoard () {
        Board board = boardController.makeBoard();
        System.out.println(board);
    }

    public static void main(String[] args) throws IOException, ParseException {
        new DisplayBoard().displayBoard();
    }
}
