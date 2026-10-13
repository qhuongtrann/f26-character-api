package com.example.character_api.repository;
import com.example.character_api.model.GhibliCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CharacterRepository extends JpaRepository<GhibliCharacter, Long> 
{
    List<GhibliCharacter> findByUniverse(String universe);
    List<GhibliCharacter> findByNameContainingIgnoreCase(String name);
    List<GhibliCharacter> findByNameContainingIgnoreCaseAndUniverse(String name, String universe);
}