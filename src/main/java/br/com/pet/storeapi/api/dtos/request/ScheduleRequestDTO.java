package br.com.pet.storeapi.api.dtos.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
public class ScheduleRequestDTO {

    @NotNull
    private UUID petId;

    @NotNull
    private UUID procedureId;

    @NotNull
    private OffsetDateTime scheduleTime;
}