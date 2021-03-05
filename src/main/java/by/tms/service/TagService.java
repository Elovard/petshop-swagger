package by.tms.service;

import by.tms.model.Tag;
import by.tms.storage.InMemoryTagStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {

    @Autowired
    private InMemoryTagStorage inMemoryTagStorage;

    public boolean save(Tag tag){
        return inMemoryTagStorage.add(tag);
    }

    public Tag getById(long id){
        return inMemoryTagStorage.getById(id);
    }
}
