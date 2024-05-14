package com.neopragma.consoleapp.infrastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SystemNullTest {
    private OutputTracker outputTracker;
    private System system;

    @BeforeEach
    public void initializeThings() {
        outputTracker = new OutputTracker();
        system = System.createNull();
        system.trackOutput(outputTracker);
    }
    @Test
    public void it_notifies_listeners_when_it_writes_to_stdout() {
        system.writeStdout("Stubbed System");
        assertEquals("Stubbed System", outputTracker.getFirst());
    }
    @Test
    public void it_notifies_listeners_when_it_exits() {
        system.exit(5);
        assertEquals("Exiting with status 5", outputTracker.getFirst());
    }
}
