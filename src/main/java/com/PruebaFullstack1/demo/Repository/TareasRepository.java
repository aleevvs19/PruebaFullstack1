package com.PruebaFullstack1.demo.Repository;

import com.PruebaFullstack1.demo.Model.Gestionar;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TareasRepository {

    private Map<Long, Gestionar> tareas = new HashMap<>();
    private Long id = 1L;

    public Gestionar guardar(Gestionar tarea) {
        tarea.setId(id++);
        tareas.put(tarea.getId(), tarea);
        return tarea;
    }

    public List<Gestionar> listar() {
        return new ArrayList<>(tareas.values());
    }

    public Optional<Gestionar> buscar(Long id) {
        return Optional.ofNullable(tareas.get(id));
    }

    public Gestionar actualizar(Long id, Gestionar tarea) {
        tarea.setId(id);
        tareas.put(id, tarea);
        return tarea;
    }

    public void eliminar(Long id) {
        tareas.remove(id);
    }
}