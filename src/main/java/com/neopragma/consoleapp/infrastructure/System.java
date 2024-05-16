package com.neopragma.consoleapp.infrastructure;

import com.neopragma.consoleapp.OutputListener;
import com.neopragma.consoleapp.OutputTracker;

import java.util.ArrayList;
import java.util.List;

public class System {
    private SystemWrapper systemOut;
    private final OutputListener<String> outputListener = new OutputListener<>();
    public static System create() {
        return new System(new RealSystem());
    }
    public static System createNull() {
        return new System(new StubbedSystem());
    }
    public System(SystemWrapper systemOut) {
        this.systemOut = systemOut;
    }
    public OutputTracker<String> trackOutput() {
        return outputListener.createTracker();
    }
    public void writeStdout(String message) {
        outputListener.track(message);
        systemOut.writeStdout(message);
    }
    public void exit(int statusCode) {
        outputListener.track("Exiting with status " + statusCode);
        systemOut.exit(statusCode);
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
