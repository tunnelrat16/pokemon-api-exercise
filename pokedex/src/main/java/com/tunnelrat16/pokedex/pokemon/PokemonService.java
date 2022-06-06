package com.tunnelrat16.pokedex.pokemon;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {
  @Autowired
  private PokemonRepository pokemonRepository;

  public Iterable<Pokemon> list(){
    return pokemonRepository.findAll();
  }

  public Optional<Pokemon> findById(Long id){
    return pokemonRepository.findById(id);
  }

  public Pokemon create(Pokemon pokemon) {
    return pokemonRepository.save(pokemon);
  }

  public Optional<Pokemon> update(Pokemon pokemon) {
    Optional<Pokemon> foundPokemon = pokemonRepository.findById(pokemon.getId());

    if (foundPokemon.isPresent()) {
        Pokemon updatedPokemon = foundPokemon.get();
        updatedPokemon.setImageUrl(pokemon.getImageUrl());

        pokemonRepository.save(updatedPokemon);
        return Optional.of(updatedPokemon);
      } else {
        return Optional.empty();
      }
  }

  public void deleteById(Long id) {
    pokemonRepository.deleteById(id);
  }
}