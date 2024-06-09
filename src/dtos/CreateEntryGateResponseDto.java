package dtos;

import models.EntryGate;

public class CreateEntryGateResponseDto extends ResponseDto{
    private EntryGate entryGate;

    public EntryGate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(EntryGate entryGate) {
        this.entryGate = entryGate;
    }
}
