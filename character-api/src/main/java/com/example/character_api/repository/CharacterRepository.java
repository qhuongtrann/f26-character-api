package com.csc340.character_api.characters;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CharacterRepository extends JpaRepository<GhibliCharacter, Long> 
{
    List<GhibliCharacter> findByUniverse(String universe);
    List<GhibliCharacter> findByNameContainingIgnoreCase(String name);
    List<GhibliCharacter> findByNameContainingIgnoreCaseAndUniverse(String name, String universe);
}