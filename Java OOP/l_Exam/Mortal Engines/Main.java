import core.Engine;
import core.MachineFactoryImpl;
import core.MachinesManagerImpl;

import core.PilotFactoryImpl;
import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.MachinesManager;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;


import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        PilotFactory pilotFactory = new PilotFactoryImpl();
        MachineFactory machineFactory = new MachineFactoryImpl();
        Map<String, Pilot> pilots = new LinkedHashMap<>();
        Map<String, Machine> machines = new LinkedHashMap<>();

        MachinesManager machinesManager = new MachinesManagerImpl(pilotFactory, machineFactory, pilots, machines);
        Engine engine = new Engine(machinesManager);
        engine.run();

    }
}
