package quiztastic.app;

import quiztastic.core.Category;
import quiztastic.core.Question;
import quiztastic.domain.QuestionRepository;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class MapQuestionRepository implements QuestionRepository {
    private final HashMap<Category, List<Question>> questionsByCategory;

    public MapQuestionRepository(HashMap<Category, List<Question>> questionsByCategory) {
        this.questionsByCategory = questionsByCategory;
    }

    public static MapQuestionRepository fromQuestionReader(QuestionReader reader) throws IOException, ParseException {
        Question q;
        while ((q = reader.readQuestion()) != null) {
            //System.out.println(q);
        }
        return new MapQuestionRepository(new HashMap<>());
    }


    @Override
    public List<Category> getCategories() {

        return List.copyOf(questionsByCategory.keySet());

        //question by categories hashmap
        //VIGTIGE
        //Få kun categorier her med hashmap
    }

    @Override
    public List<Question> getQuestionsWithCategory(Category category) {
        throw new UnsupportedOperationException("Not implemented yet!");


        //Map<String, String> favoritePets = new HashMap<>();
        //Få fat på kategorier med spørgsmål
    }
}
