package com.registro.registro.Controller;

import com.registro.registro.Model.Persona;
import com.registro.registro.Service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"${frontend.url}"})
@RestController
@RequestMapping("/api")
public class PersonaController {

    @Autowired
    public IPersonaService personaService;

    @GetMapping("/persona")
    public List<Persona> listarPersonas(){
        return personaService.findAll();
    }

    @GetMapping("/persona/{id}")
    public Persona personaById(@PathVariable Long id){
        return personaService.findById(id);
    }

    @PostMapping("/persona")
    public Persona crear(@RequestBody Persona persona){
        return  personaService.save(persona);
    }

    @PutMapping("/persona/{id}")
    public Persona actualizar(@RequestBody Persona persona, @PathVariable Long id){
        Persona personaActalizar = personaService.findById(id);

        personaActalizar.setNombre(persona.getNombre());
        personaActalizar.setApellido(persona.getApellido());
        personaActalizar.setEmail(persona.getEmail());
        personaActalizar.setCelular(persona.getCelular());
        personaActalizar.setCedula(persona.getCedula());
        personaActalizar.setCarrera(persona.getCarrera());

        return personaService.save(personaActalizar);
    }

    @DeleteMapping("/persona/{id}")
    public void eliminar(@PathVariable Long id){
        personaService.delete(id);
    }
}
