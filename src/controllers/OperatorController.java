package controllers;

import dtos.CreateOperatorRequestDto;
import dtos.CreateOperatorResponseDto;
import dtos.ResponseStatusDto;
import models.Operator;
import services.OperatorService;

public class OperatorController {
    private OperatorService operatorservice;

    public OperatorController(OperatorService operatorservice) {
        this.operatorservice = operatorservice;
    }

    public CreateOperatorResponseDto createOperator(CreateOperatorRequestDto request){
        Operator createdOperator = operatorservice.createOperator(request.getOperatorName());
        CreateOperatorResponseDto response = new CreateOperatorResponseDto();
        response.setOperator(createdOperator);
        response.setResponseStatus(ResponseStatusDto.SUCCESS);
        return response;
    }
}
