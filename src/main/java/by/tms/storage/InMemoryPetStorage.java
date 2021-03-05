package by.tms.storage;

import by.tms.model.Pet;
import by.tms.model.PetDTO;
import by.tms.model.PetStatusEnum;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryPetStorage {

    private static long gen = 0;
    private List<Pet> petList = new ArrayList<>();

    public boolean add(Pet pet){
        pet.setId(gen++);
        return petList.add(pet);
    }

    public boolean update(Pet pet){
        for (int i = 0; i < petList.size(); i++) {
            if(petList.get(i).getId() == pet.getId()){
                petList.set(i, pet);
                return true;
            }
        }
        return false;
    }

    public List<Pet> getByStatus(PetStatusEnum status){
        List<Pet>pets = new ArrayList<>();
        for (Pet pet : petList) {
            if (pet.getStatus().equals(status)) {
                pets.add(pet);
            }
        }
        return pets;
    }

    public Pet getById(long id){
        for (Pet pet : petList) {
            if (pet.getId()==id) {
                return pet;
            }
        }
        return null;
    }

    public boolean updateById(PetDTO pet){
        for (Pet oldPet : petList) {
            if(oldPet.getId() == pet.getId()){
                oldPet.setStatus(pet.getStatus().toString());
                oldPet.setName(pet.getName());
                return true;
            }
        }
        return false;
    }


    public boolean deleteById(long id){
        for (Pet pet : petList) {
            if (pet.getId()==id) {
                petList.remove(pet);
                return true;
            }
        }
        return false;
    }
}
