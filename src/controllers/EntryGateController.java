package controllers;

import dtos.CreateEntryGateRequestDto;
import dtos.CreateEntryGateResponseDto;
import dtos.ResponseStatusDto;
import models.EntryGate;
import services.EntryGateService;

public class EntryGateController {

    private EntryGateService entryGateService;

    public EntryGateController(EntryGateService entryGateService) {
        this.entryGateService = entryGateService;
    }

    public CreateEntryGateResponseDto createEntryGate(CreateEntryGateRequestDto request){
        EntryGate createdEntryGate = entryGateService.createEntryGate(request.getGateNumber(), request.getOperatorId());
        CreateEntryGateResponseDto response = new CreateEntryGateResponseDto();
        response.setEntryGate(createdEntryGate);
        response.setResponseStatus(ResponseStatusDto.SUCCESS);
        return response;
    }
}
