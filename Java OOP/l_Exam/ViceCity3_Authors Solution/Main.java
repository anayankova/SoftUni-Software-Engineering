package viceCity;

import viceCity.core.ControllerImpl;
import viceCity.core.interfaces.Controller;
import viceCity.core.interfaces.Engine;
import viceCity.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
