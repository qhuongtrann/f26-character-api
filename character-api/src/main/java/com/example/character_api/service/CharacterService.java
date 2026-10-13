package com.example.character_api.service;

import com.example.character_api.CharacterNotFoundException;
import com.example.character_api.model.GhibliCharacter;
import com.example.character_api.repository.CharacterRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CharacterService 
{

    private final CharacterRepository repository;

    public CharacterService(CharacterRepository repository) 
    {
        this.repository = repository;
    }

    public List<GhibliCharacter> findAll() 
    {
        return repository.findAll();
    }

    public List<GhibliCharacter> findByUniverse(String universe) 
    {
        return repository.findByUniverse(universe);
    }

    public List<GhibliCharacter> search(String name, String universe) 
    {
        boolean hasName = name != null && !name.isBlank();
        boolean hasUniverse = universe != null && !universe.isBlank();

        if (hasName && hasUniverse) {
            return repository.findByNameContainingIgnoreCaseAndUniverse(name.trim(), universe.trim());
        }
        if (hasName) {
            return repository.findByNameContainingIgnoreCase(name.trim());
        }
        if (hasUniverse) {
            return repository.findByUniverse(universe.trim());
        }
        return repository.findAll();
    }

    public GhibliCharacter findById(Long id) 
    {
        return repository.findById(id).orElseThrow(() -> new CharacterNotFoundException(id));
    }

    public GhibliCharacter create(GhibliCharacter character) 
    {
        return repository.save(character);
    }

    public GhibliCharacter update(Long id, GhibliCharacter updated) 
    {
        GhibliCharacter existing = findById(id);
        existing.setName(updated.getName());
        existing.setUniverse(updated.getUniverse());
        existing.setRole(updated.getRole());
        existing.setImageUrl(updated.getImageUrl());
        existing.setDescription(updated.getDescription());
        existing.setActiveDate(updated.getActiveDate());
        return repository.save(existing);
    }

    public void delete(Long id) 
    {
        findById(id);
        repository.deleteById(id);
    }
}