package repositories;

import models.EntryGate;

import java.util.HashMap;
import java.util.Map;

public class EntryGateRepository {
    Map<Long, EntryGate> entryGates = new HashMap<>();
    Long lastCount = 0L;

    public EntryGate save(EntryGate entryGate) {
        lastCount += 1;
        entryGate.setId(lastCount);
        entryGates.put(lastCount, entryGate);
        return entryGate;
    }
}
