package com.neopragma.consoleapp;

import com.neopragma.consoleapp.infrastructure.System;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    @Test
    public void it_writes_default_message_to_stdout() {
        System system = System.createNull();
        OutputTracker outputTracker = system.trackOutput();
        App app = new App(system);
        app.run();
        assertEquals("Greetings from the Incredible App!",
                outputTracker.data().getFirst());
    }
}
