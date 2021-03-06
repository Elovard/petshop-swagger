package by.tms.service;

import by.tms.model.Category;
import by.tms.storage.InMemoryCategoryStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private InMemoryCategoryStorage inMemoryCategoryStorage;

    public boolean save(Category category){
        return inMemoryCategoryStorage.add(category);
    }

    public Category getById(long id){                 // в сервисе делаем валидацию всю, в сторадже - просто метод
        return inMemoryCategoryStorage.getById(id);    // в контроллере просто валидация данных (@Valid)
    }

}
