package com.neopragma.consoleapp.infrastructure;

public interface SystemOutputListener {
    void stdoutWritten(SystemOutputEvent event);
}
