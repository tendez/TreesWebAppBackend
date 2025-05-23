package czechowski.treeswebappbackend.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import czechowski.treeswebappbackend.model.Sprzedaz;
import czechowski.treeswebappbackend.repository.SprzedazRepository;

import java.time.LocalDate;

import java.util.List;

@Service
public class SprzedazService {

    @Autowired
    private SprzedazRepository sprzedazRepository;



}
