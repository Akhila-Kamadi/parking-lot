package services;

import models.EntryGate;
import models.Operator;
import models.enums.GateStatus;
import models.enums.GateType;
import repositories.EntryGateRepository;
import repositories.OperatorRepository;

public class EntryGateService {

    private OperatorRepository operatorRepository;
    private EntryGateRepository entryGateRepository;

    public EntryGateService(OperatorRepository operatorRepository, EntryGateRepository entryGateRepository) {
        this.operatorRepository = operatorRepository;
        this.entryGateRepository = entryGateRepository;
    }

    public EntryGate createEntryGate(int gateNumber, Long operatorId) {
        /*
        Get Operator by its ID
        Create Entry Gate
        Save
        Return
         */
        Operator operator = operatorRepository.getById(operatorId);
        EntryGate entryGate = new EntryGate();
        entryGate.setGateNumber(gateNumber);
        entryGate.setGateStatus(GateStatus.OPEN);
        entryGate.setGateType(GateType.ENTRY);
        entryGate.setOperator(operator);
        EntryGate createdEntryGate = entryGateRepository.save(entryGate);
        return createdEntryGate;
    }
}
