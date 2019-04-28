package br.com.gmtechnology.api.arduinomonitor.controllers;

import br.com.gmtechnology.api.arduinomonitor.dtos.LocationDTO;
import br.com.gmtechnology.api.arduinomonitor.models.Location;
import br.com.gmtechnology.api.arduinomonitor.services.LocationService;
import lombok.val;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RestController
@RequestMapping(path = "/location")
public class LocationController {

    @Autowired
    LocationService service;

    private final ModelMapper convert = new ModelMapper();

    @GetMapping
    public ResponseEntity<List<LocationDTO>> findAll() {
        val locations = service.findAll();
        val locationDTO = locations.stream().map(location -> convert.map(location, LocationDTO.class)).collect(Collectors.toList());
        return ResponseEntity.ok(locationDTO);
    }

    @PostMapping
    public ResponseEntity<LocationDTO> insert(@RequestBody @Valid LocationDTO body) {
        val document = convert.map(body, Location.class);
        val locaion = convert.map(service.insert(document), LocationDTO.class);
        return ResponseEntity.ok(locaion);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<LocationDTO> update(@PathVariable("id") String id, @RequestBody @Valid LocationDTO body) {
        val document = convert.map(body, Location.class);
        document.setId(id);
        val locaion = convert.map(service.update(document), LocationDTO.class);
        return ResponseEntity.ok(locaion);
    }
}
