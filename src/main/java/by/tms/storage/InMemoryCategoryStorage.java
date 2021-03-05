package by.tms.storage;

import by.tms.model.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryCategoryStorage {

    private static long gen = 0;
    private List<Category>categoryList = new ArrayList<>();

    public boolean add(Category category){
        category.setId(gen++);
        return categoryList.add(category);
    }

    public Category getById(long id){
        for (Category category : categoryList) {
            if(category.getId() == id){
                return category;
            }
        }
        return null;
    }
}
