package br.com.pet.storeapi.api.dtos.response;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class ScheduleResponseDTO {

//    private String guardianName;
//    private String petName;
//    private String procedureName;
    private GuardianResponseDTO guardian;
    private PetResponseDTO pet;
    private ProcedureResponseDTO procedure;
    private OffsetDateTime scheduleTime;
}
