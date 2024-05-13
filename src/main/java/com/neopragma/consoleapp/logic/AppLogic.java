package com.neopragma.consoleapp.logic;

import com.neopragma.consoleapp.infrastructure.System;
public class AppLogic {
    System system;
    public AppLogic() {
        this(System.create());
    }
    public AppLogic(System system) {
        this.system = system;
    }

    public void incredibleFunctionality() {
        system.writeStdout("Greetings from the Incredible App!");
    }
}
