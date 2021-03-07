package by.tms.storage;

import by.tms.model.Pet;
import by.tms.model.PetStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findAllByPetStatusEnum(PetStatusEnum petStatusEnum);
    boolean existsById(long id);
}
