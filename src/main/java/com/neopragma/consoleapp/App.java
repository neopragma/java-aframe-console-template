package com.neopragma.consoleapp;

import com.neopragma.consoleapp.infrastructure.System;

public class App {
    private System system;

    public App() {
        this(System.create());
    }

    public App(System system) {
        this.system = system;
    }

    void run() {
        AppLogic appLogic = new AppLogic(system);
        appLogic.incredibleFunctionality();
        system.exit(0);
    }

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}
