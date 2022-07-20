package br.com.pet.storeapi.api.dtos.request;

import java.time.OffsetDateTime;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ScheduleRequestDTO {

  @NotNull private UUID petId;

  @NotNull private UUID serviceId;

  @NotNull private OffsetDateTime scheduleTime;
}
