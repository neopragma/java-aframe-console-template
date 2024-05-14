package com.neopragma.consoleapp.infrastructure;

import java.util.ArrayList;
import java.util.List;

public class System {
    private SystemWrapper systemOut;
    private List<SystemOutputListener> outputListeners = new ArrayList<>();
    public static System create() {
        return new System(new RealSystem());
    }
    public static System createNull() {
        return new System(new StubbedSystem());
    }
    public System(SystemWrapper systemOut) {
        this.systemOut = systemOut;
    }
    public void writeStdout(String message) {
        systemOut.writeStdout(message);
        notifyListeners(message);
    }
    public void exit(int statusCode) {
        systemOut.exit(statusCode);
        notifyListeners("Exiting with status " + statusCode);
    }
    private void notifyListeners(String message) {
        outputListeners.forEach(listener -> {
            listener.stdoutWritten(new SystemOutputEvent(this, message));
        });
    }
    public void trackOutput(OutputTracker outputListener) {
        this.outputListeners.add(outputListener);
    }
    private interface SystemWrapper {
        void writeStdout(String message);
        void exit(int statusCode);
    }
    private static class RealSystem implements SystemWrapper {
        @Override
        public void writeStdout(String message) {
            java.lang.System.out.println(message);
        }
        @Override
        public void exit(int statusCode) {
            java.lang.System.exit(statusCode);
        }
    }
    private static class StubbedSystem implements SystemWrapper {
        private List<String> stdout = new ArrayList<>();
        @Override
        public void writeStdout(String message) {
        }
        @Override
        public void exit(int statusCode) {
        }
    }
}
