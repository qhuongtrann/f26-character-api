package com.csc340.character_api.characters;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class CharacterController 
{

    private final CharacterService service;

    public CharacterController(CharacterService service) 
    {
        this.service = service;
    }

    @GetMapping
    public List<GhibliCharacter> list(@RequestParam(required = false) String name, @RequestParam(required = false) String universe) 
    {
        return service.search(name, universe);
    }

    @GetMapping("/{id}")
    public GhibliCharacter get(@PathVariable Long id) 
    {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GhibliCharacter create(@Valid @RequestBody GhibliCharacter character) 
    {
        return service.create(character);
    }

    @PutMapping("/{id}")
    public GhibliCharacter update(@PathVariable Long id, @Valid @RequestBody GhibliCharacter character) 
    {
        return service.update(id, character);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) 
    {
        service.delete(id);
    }

    @GetMapping("/pulse")
    public ResponseEntity<String> checkPulse() 
    {
        return ResponseEntity.ok("Pulse check successful");
    }
}