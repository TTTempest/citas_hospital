package com.hospital.citas_m.services;

import com.hospital.citas_m.DTO.PacienteDTO;
import com.hospital.citas_m.entities.Cita;
import com.hospital.citas_m.entities.Medico;
import com.hospital.citas_m.entities.Paciente;
import com.hospital.citas_m.repositories.PacienteRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImp implements PacienteService {
    @Autowired
    private PacienteRepositorio pacienteRep;
    @Lazy
    @Autowired
    private CitaService citaService;
    private ModelMapper maper = new ModelMapper();

    private PacienteDTO convertDTO(Paciente p){
        PacienteDTO dto = maper.map(p, PacienteDTO.class);
        return dto;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PacienteDTO> listaPaciente() {
        List<Paciente> pacientes = pacienteRep.findAll();
        List<PacienteDTO> DTo= new LinkedList<PacienteDTO>();
        List<Cita> citas = new LinkedList<Cita>();
        for(Paciente p: pacientes){
            for (Cita c: citas){
                if (c.getPaciente().getId() == p.getId()){
                    p.getCitas().add(c);
                }
            }
            DTo.add(convertDTO(p));
        }
        return DTo;
    }

    @Override
    @Transactional(readOnly = true)
    public PacienteDTO paciendebyid(Long id) {
        Paciente p = pacienteRep.findById(id).orElse(null);
        if (p == null){
            throw new RuntimeException("Cita no encontrada");
        }else {
            return convertDTO(p);
        }

    }

    @Override
    public PacienteDTO savePaciente(Paciente newPaciente) {
        pacienteRep.save(newPaciente);
        return convertDTO(newPaciente);
    }

    @Override
    public PacienteDTO update(Paciente request, Long id) {
        Optional<Paciente> busqueda = pacienteRep.findById(id);
        if (busqueda != null) {
            Paciente pac = busqueda.get();
            pac.setNombre(request.getNombre());
            pac.setApellidos(request.getApellidos());
            pac.setUsuario(request.getUsuario());
            pac.setClave(request.getClave());
            pac.setNSS((request.getNSS()));
            pac.setTelefono(request.getTelefono());
            pac.setDireccion(request.getDireccion());
            if (!request.getCitas().isEmpty()) {
                List<Cita> citas = new ArrayList<Cita>();
                for (Cita p : request.getCitas()) {
                    citaService.guardarCita(p);
                    citas.add(p);
                }
                pac.setCitas(citas);
            }
            pacienteRep.save(pac);
            return convertDTO(pac);
        }else {
            throw new RuntimeException("el medico que busca no existe");
        }
    }

    @Override
    public void deletePaciente(Long id) {
        if (pacienteRep.existsById(id)) {
            pacienteRep.deleteById(id);
        }else{
            throw new RuntimeException("Cita no encontrada");
        }
    }
}
