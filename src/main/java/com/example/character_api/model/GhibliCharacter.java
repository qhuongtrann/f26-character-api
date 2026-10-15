package com.example.character_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "characters")
public class GhibliCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long characterId;

    @NotBlank
    private String name;

    @NotBlank
    private String universe;
    private String role;
    private String imageUrl;

    @NotBlank
    private String description;
    private LocalDate activeDate;

    public GhibliCharacter() 
    {

    }

    public Long getCharacterId() 
    {
        return characterId;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getUniverse() 
    {
        return universe;
    }

    public void setUniverse(String universe) 
    {
        this.universe = universe;
    }

    public String getRole() 
    {
        return role;
    }

    public void setRole(String role) 
    {
        this.role = role;
    }

    public String getImageUrl() 
    {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) 
    {
        this.imageUrl = imageUrl;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public LocalDate getActiveDate() 
    {
        return activeDate;
    }

    public void setActiveDate(LocalDate activeDate) 
    {
        this.activeDate = activeDate;
    }
}