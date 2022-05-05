package nl.workingtalentapp.library.persistance;

import nl.workingtalentapp.library.domein.Boek;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoekRepo extends JpaRepository<Boek, Long> {
    void deleteBoekById(Long id);
    Optional <Boek> findBoekById(long id);
}
