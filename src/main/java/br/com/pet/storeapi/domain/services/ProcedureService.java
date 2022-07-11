package br.com.pet.storeapi.domain.services;

import br.com.pet.storeapi.api.exceptions.ProcedureAlreadyExistsException;
import br.com.pet.storeapi.domain.entities.Procedure;
import br.com.pet.storeapi.infra.database.repositories.ProcedureRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class ProcedureService {

    private final ProcedureRepository procedureRepository;

    @Transactional
    public Procedure createProcedure(Procedure procedure) {
        boolean nameInUse = procedureRepository.findByDescription(procedure.getDescription())
                .stream()
                .anyMatch(existingProcedure -> !existingProcedure.equals(procedure));
        if(nameInUse) {
            throw new ProcedureAlreadyExistsException();
        }
        return procedureRepository.save(procedure);
    }

    public Page<Procedure> listProceduresByPage(Pageable pageable) {
        return procedureRepository.findAll(pageable);
    }
}
