package br.com.gmtechnology.api.arduinomonitor.services;

import br.com.gmtechnology.api.arduinomonitor.controllers.exceptions.NotFoundException;
import br.com.gmtechnology.api.arduinomonitor.models.Location;
import br.com.gmtechnology.api.arduinomonitor.repositories.LocationRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LocationService {

    @Autowired
    LocationRepository repository;

    public List<Location> findAll() {
        return repository.findAll();
    }

    public Location insert(Location location) {
        location.setCreatedAt(new Date());
        location.setLastUpdated(new Date());
        return repository.save(location);
    }

    public Location update(Location location) {
        location.setLastUpdated(new Date());
        return repository.save(location);
    }

    public Location findOne(String id) {
        val entity = repository.findById(id);
        if(!entity.isPresent())
            throw new NotFoundException("Localização não encontrada");
        return entity.get();
    }
}
