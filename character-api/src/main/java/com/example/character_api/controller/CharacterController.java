package com.example.character_api.controller;

import com.example.character_api.model.GhibliCharacter;
import com.example.character_api.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    @Autowired
    private CharacterRepository repository;

    @GetMapping
    public List<GhibliCharacter> getAllCharacters() 
    {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GhibliCharacter> getCharacterById(@PathVariable Long id) 
    {
        GhibliCharacter character = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Character not found with id " + id));
        return ResponseEntity.ok(character);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GhibliCharacter createCharacter(@RequestBody GhibliCharacter character) 
    {
        return repository.save(character);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GhibliCharacter> updateCharacter(@PathVariable Long id, @RequestBody GhibliCharacter characterDetails) 
    {
        GhibliCharacter character = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Character not found with id " + id));
        
        character.setName(characterDetails.getName());
        character.setUniverse(characterDetails.getUniverse());
        character.setRole(characterDetails.getRole());
        character.setImageUrl(characterDetails.getImageUrl());
        character.setDescription(characterDetails.getDescription());
        character.setActiveDate(characterDetails.getActiveDate());

        GhibliCharacter updatedCharacter = repository.save(character);
        return ResponseEntity.ok(updatedCharacter);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCharacter(@PathVariable Long id) 
    {
        repository.deleteById(id);
    }

    @GetMapping("/pulse")
    public ResponseEntity<String> checkPulse() 
    {
        return ResponseEntity.ok("Pulse check successful");
    }
}