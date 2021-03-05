package by.tms.storage;

import by.tms.model.Tag;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryTagStorage {
    private static long gen = 0;
    private List<Tag> petList = new ArrayList<>();

    public boolean add(Tag tag){
        tag.setId(gen++);
        return petList.add(tag);
    }

    public Tag getById(long id){
        for (Tag tag : petList) {
            if(tag.getId() == id){
                return tag;
            }
        }
        return null;
    }
}
