package dtos;

import models.Operator;

public class CreateOperatorResponseDto extends ResponseDto{
    private Operator operator;

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
}
