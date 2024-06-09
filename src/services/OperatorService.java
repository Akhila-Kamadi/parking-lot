package services;

import models.Operator;
import repositories.OperatorRepository;

public class OperatorService {

    private OperatorRepository operatorRepository;

    public OperatorService(OperatorRepository operatorRepository) {
        this.operatorRepository = operatorRepository;
    }

    public Operator createOperator(String name) {
        Operator operator = new Operator();
        operator.setName(name);
        return operatorRepository.save(operator);
    }
}
