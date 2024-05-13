package com.neopragma.consoleapp.infrastructure;

import java.util.EventObject;

public class SystemOutputEvent extends EventObject {
    private String stdoutMessage;
    public SystemOutputEvent(Object source, String stdoutMessage) {
        super(source);
        this.stdoutMessage = stdoutMessage;
    }
    public String getStdoutMessage() {
        return stdoutMessage;
    }
}
