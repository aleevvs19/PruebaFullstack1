package com.PruebaFullstack1.demo.Controller;

import com.PruebaFullstack1.demo.Model.Gestionar;
import com.PruebaFullstack1.demo.Service.TareasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tareas")
public class TareasController {

    @Autowired
    private TareasServices service;

    @PostMapping
    public Gestionar crear(@RequestBody Gestionar tarea) {
        return service.crear(tarea);
    }

    @GetMapping
    public List<Gestionar> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Gestionar obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @PutMapping("/{id}")
    public Gestionar actualizar(@PathVariable Long id, @RequestBody Gestionar tarea) {
        return service.actualizar(id, tarea);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "Eliminada";
    }
}