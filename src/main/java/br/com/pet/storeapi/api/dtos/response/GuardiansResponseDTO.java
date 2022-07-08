package br.com.pet.storeapi.api.dtos.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GuardiansResponseDTO {
    private List<GuardianResponseDTO> guardians = new ArrayList<>();

    public void addGuardian(GuardianResponseDTO guardian) {
        this.guardians.add(guardian);
    }
}
