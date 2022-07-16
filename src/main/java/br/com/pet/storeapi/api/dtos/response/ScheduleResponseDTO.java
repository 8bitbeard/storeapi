package br.com.pet.storeapi.api.dtos.response;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class ScheduleResponseDTO {

//    private String guardianName;
//    private String petName;
//    private String serviceName;
    private GuardianResponseDTO guardian;
    private PetResponseDTO pet;
    private ServiceResponseDTO service;
    private OffsetDateTime scheduleTime;
}
