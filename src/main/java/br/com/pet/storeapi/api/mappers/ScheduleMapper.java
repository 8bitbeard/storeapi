package br.com.pet.storeapi.api.mappers;

import br.com.pet.storeapi.api.dtos.request.ScheduleRequestDTO;
import br.com.pet.storeapi.api.dtos.response.ScheduleResponseDTO;
import br.com.pet.storeapi.domain.entities.Schedule;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ScheduleMapper {

  private final ModelMapper modelMapper;

  public Schedule toEntity(ScheduleRequestDTO scheduleRequestDTO) {
    return modelMapper.map(scheduleRequestDTO, Schedule.class);
  }

  public ScheduleResponseDTO toDto(Schedule schedule) {
    return modelMapper.map(schedule, ScheduleResponseDTO.class);
  }
}
