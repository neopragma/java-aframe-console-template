package com.neopragma.consoleapp.infrastructure;

import com.neopragma.consoleapp.OutputTracker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SystemRealTest {
    private OutputTracker<String> outputTracker;
    private System system;

    @BeforeEach
    public void initializeThings() {
        system = System.create();
        outputTracker = system.trackOutput();
    }
    @Test
    public void it_notifies_listeners_when_it_writes_to_stdout() {
        system.writeStdout("Real System");
        assertEquals("Real System", outputTracker.data().getFirst());
    }
}
