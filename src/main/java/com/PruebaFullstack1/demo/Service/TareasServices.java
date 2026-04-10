package com.PruebaFullstack1.demo.Service;

import com.PruebaFullstack1.demo.Model.Gestionar;
import com.PruebaFullstack1.demo.Repository.TareasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareasServices {

    @Autowired
    private TareasRepository repo;

    public Gestionar crear(Gestionar tarea) {
        if (tarea.getDescripcion() == null || tarea.getDescripcion().isEmpty()) {
            throw new RuntimeException("Descripcion vacia");
        }
        return repo.guardar(tarea);
    }

    public List<Gestionar> listar() {
        return repo.listar();
    }

    public Gestionar obtener(Long id) {
        return repo.buscar(id).orElseThrow(() -> new RuntimeException("No existe"));
    }

    public Gestionar actualizar(Long id, Gestionar tarea) {
        obtener(id);
        return repo.actualizar(id, tarea);
    }

    public void eliminar(Long id) {
        obtener(id);
        repo.eliminar(id);
    }
}