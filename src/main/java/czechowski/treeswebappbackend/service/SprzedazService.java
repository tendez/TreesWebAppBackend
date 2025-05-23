package czechowski.treeswebappbackend.service;


import czechowski.treeswebappbackend.repository.SprzedazRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SprzedazService {

    @Autowired
    private SprzedazRepository sprzedazRepository;


}
