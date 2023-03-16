package com.hospital.citas_m.services;

import com.hospital.citas_m.DTO.CitaDTO;
import com.hospital.citas_m.DTO.DiagnosticoDtoRcort;
import com.hospital.citas_m.entities.Cita;
import com.hospital.citas_m.repositories.CitaRepositorio;
import com.hospital.citas_m.repositories.DiagnosticoRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CitaServiceImp implements CitaService{

    @Autowired
    private CitaRepositorio citarep;
    @Autowired
    private DiagnosticoRepositorio diagnosticoRepositorio;
    private ModelMapper maper = new ModelMapper();

    private CitaDTO convertDTO(Cita c){
        CitaDTO dto = maper.map(c, CitaDTO.class);
        return dto;
    }

    @Override
    public List<CitaDTO> listacita() {
        List<Cita> citas = citarep.findAll();
        //utilizar linkedList cuando ser requieran muchas inserciones y deletes, tambien se podria usar arraylist
        List<CitaDTO> citaDTo= new LinkedList<CitaDTO>();
        for(Cita c: citas){
            //convertDTO convierte c en un objeto para poder anadirlo a citaDTO
            citaDTo.add(convertDTO(c));
        }
        return citaDTo;
    }

    @Override
    public CitaDTO listaById(Long id) {
        Cita c = citarep.findCitaById(id);
        if (c == null){
            //se lanzara una excepcion si la cita busca es null
            throw new RuntimeException("Cita no encontrada");
        }else {
            return convertDTO(c);
        }

    }

    @Override
    public CitaDTO guardarCita(Cita newCita) {
        citarep.save(newCita);
        //diagnosticoRepositorio.save(newCita.getDiagnostico());
        return convertDTO(newCita);
    }
    @Override
    public void delete(long id) {
        if (citarep.existsById(id)) {
            citarep.deleteById(id);
        }else{
            throw new RuntimeException("Cita no encontrada");
        }
    }

}
