package com.neopragma.consoleapp.infrastructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OutputTrackerTest {

    @Test
    public void something() {
        OutputTracker tracker = new OutputTracker();
        tracker.stdoutWritten(new SystemOutputEvent(this, "one"));
        tracker.stdoutWritten(new SystemOutputEvent(this, "two"));
        tracker.stdoutWritten(new SystemOutputEvent(this, "three"));
        assertEquals(3, tracker.size());
        assertEquals("one", tracker.getFirst());
        assertEquals("two", tracker.get(1));
        assertEquals("three", tracker.getLast());
        tracker.reset();
        assertTrue(tracker.isEmpty());
    }
}
