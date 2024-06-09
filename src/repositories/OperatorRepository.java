package repositories;

import models.Operator;

import java.util.HashMap;
import java.util.Map;

public class OperatorRepository {
    Map<Long, Operator> operators = new HashMap<>();
    Long lastCount = 0L;

    public Operator save(Operator operator){
        lastCount += 1;
        operator.setId(lastCount);
        operators.put(lastCount, operator);
        return operator;
    }

    public Operator getById(Long operatorId){
        if (operators.containsKey(operatorId)){
            return operators.get(operatorId);
        }
        return null;
    }
}
