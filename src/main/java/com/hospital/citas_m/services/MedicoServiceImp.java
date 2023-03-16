package com.hospital.citas_m.services;

import com.hospital.citas_m.DTO.CitaDTO;
import com.hospital.citas_m.DTO.MedicoDTO;
import com.hospital.citas_m.entities.Cita;
import com.hospital.citas_m.entities.Medico;
import com.hospital.citas_m.entities.Paciente;
import com.hospital.citas_m.repositories.MedicoRepositorio;
import com.hospital.citas_m.repositories.PacienteRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class MedicoServiceImp implements MedicoService {
    @Autowired
    private MedicoRepositorio medicorep;
    @Lazy
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private CitaService citaService;
    private ModelMapper maper = new ModelMapper();

    private MedicoDTO convertDTO(Medico c){
        MedicoDTO dto = maper.map(c, MedicoDTO.class);
        return dto;
    }

    @Override
    public List<MedicoDTO> listaMedico() {
        List<Medico> medicos = medicorep.findAll();
        List<MedicoDTO> DTo= new LinkedList<MedicoDTO>();
        for(Medico m: medicos){
            DTo.add(convertDTO(m));
        }
        return DTo;
    }

    @Override
    public MedicoDTO medicobyId(long id) {
        Medico m = medicorep.findById(id).orElse(null);
        if (m == null){
            throw new RuntimeException("Cita no encontrada");
        }else {
            return convertDTO(m);
        }

    }

    @Override
    public MedicoDTO saveMedico(Medico newMedico) {
        medicorep.save(newMedico);
        return convertDTO(newMedico);
    }

    @Override
    public MedicoDTO update(Medico request, Long id) {
        Optional<Medico> busqueda = medicorep.findById(id);
        if (busqueda !=null){
            Medico med= busqueda.get();
            med.setNumColegiado(request.getNumColegiado());
            if (!request.getPaciente().isEmpty()){
                List<Paciente> paciente = new ArrayList<Paciente>();
                for (Paciente p: request.getPaciente()){
                    pacienteService.savePaciente(p);
                    paciente.add(p);
                    if (p.getCitas() != null){
                        List<Cita> citas = new ArrayList<Cita>();
                        for(Cita c: p.getCitas()){
                            citaService.guardarCita(c);
                            citas.add(c);
                            med.setCita(citas);
                        }
                    }


                }
                med.setPaciente(paciente);
            }
            medicorep.save(med);
            return convertDTO(med);
        }else {
            throw new RuntimeException("el medico que busca no existe");
        }

    }

    @Override
    public void delete(long id) {
        if (medicorep.existsById(id)) {
            medicorep.deleteById(id);
        }else{
            throw new RuntimeException("Cita no encontrada");
        }
    }
}
