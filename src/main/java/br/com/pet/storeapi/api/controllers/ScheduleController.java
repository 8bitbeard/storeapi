package br.com.pet.storeapi.api.controllers;

import br.com.pet.storeapi.api.dtos.request.ScheduleRequestDTO;
import br.com.pet.storeapi.api.dtos.response.ScheduleResponseDTO;
import br.com.pet.storeapi.api.mappers.ScheduleMapper;
import br.com.pet.storeapi.domain.entities.Schedule;
import br.com.pet.storeapi.domain.services.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.OffsetDateTime;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/schedules")
public class ScheduleController {

    private final ScheduleMapper scheduleMapper;
    private final ScheduleService scheduleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ScheduleResponseDTO createSchedule(@RequestBody @Valid ScheduleRequestDTO scheduleRequestDTO) {
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();

        OffsetDateTime scheduleTime = scheduleRequestDTO.getScheduleTime();
        UUID petId = scheduleRequestDTO.getPetId();
        UUID procedureId = scheduleRequestDTO.getProcedureId();

        return scheduleMapper.toDto(scheduleService.createSchedule(userEmail, scheduleTime, petId, procedureId));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Page<ScheduleResponseDTO> listSchedules(
            @PageableDefault(sort = "scheduleTime", direction = Sort.Direction.ASC) Pageable pageable) {
        return scheduleService.listSchedulesByPage(pageable).map(scheduleMapper::toDto);
    }
}
