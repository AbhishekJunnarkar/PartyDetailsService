package com.projectabhishek.partyDetailService.controller;

import com.projectabhishek.partyDetailService.domain.Party;
import com.projectabhishek.partyDetailService.exception.PartyNotFoundException;
import com.projectabhishek.partyDetailService.repository.PartyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @RestController indicates that the data returned by each method will be written straight into the response body instead
 * of rendering a template.
 */
@RestController
public class PartyController {
    private final PartyRepository repository;

    // An PartyRepository is injected by constructor into the controller.
    PartyController(PartyRepository repository) {
        this.repository = repository;
    }

    //Aggregate Root (get all)
    @GetMapping("/parties")
    List<Party> all() {
        return repository.findAll();
    }

    //Post new Party
    @PostMapping("/parties")
    Party newParty(@RequestBody Party party) {
        return repository.save(party);
    }

    //Retrieve Single Party
    @GetMapping("/parties/{id}")
    Party getParty(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new PartyNotFoundException(id));
    }

    // Update existing party
    @PutMapping("/parties/{id}")
    Party updateParty(@RequestBody final Party newParty, @PathVariable Long id) {

        return repository.findById(id).map(party -> {
            party.setName(newParty.getName());
            party.setType(newParty.getType());
            return repository.save(party);
        }).orElseGet(() -> {
            newParty.setId(id);
            return repository.save(newParty);
        });
    }

    //Delete Party
    @DeleteMapping("/party/{id}")
    @ResponseBody void deleteParty(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
