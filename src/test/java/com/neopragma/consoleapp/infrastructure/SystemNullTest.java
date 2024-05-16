package com.neopragma.consoleapp.infrastructure;

import com.neopragma.consoleapp.OutputTracker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SystemNullTest {
    private OutputTracker<String> outputTracker;
    private System system;

    @BeforeEach
    public void initializeThings() {
        system = System.createNull();
        outputTracker = system.trackOutput();
    }
    @Test
    public void it_notifies_listeners_when_it_writes_to_stdout() {
        system.writeStdout("Stubbed System");
        assertEquals("Stubbed System",
                outputTracker.data().getFirst());
    }
    @Test
    public void it_notifies_listeners_when_it_exits() {
        system.exit(5);
        assertEquals("Exiting with status 5",
                outputTracker.data().getFirst());
    }
}
