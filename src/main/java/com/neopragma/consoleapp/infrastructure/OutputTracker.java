package com.neopragma.consoleapp.infrastructure;

import java.util.ArrayList;
import java.util.List;

public class OutputTracker implements SystemOutputListener {
    List<String> trackedOutput;
    public OutputTracker() {
        trackedOutput = new ArrayList<>();
    }
    public static OutputTracker create() {
        return new OutputTracker();
    }
    @Override
    public void stdoutWritten(SystemOutputEvent event) {
        trackedOutput.add(event.getStdoutMessage());
    }
    public String get(int index) {
        return trackedOutput.get(index);
    }
    public String getFirst() {
        return trackedOutput.getFirst();
    }
    public String getLast() {
        return trackedOutput.getLast();
    }
    public int size() {
        return trackedOutput.size();
    }
    public boolean isEmpty() {
        return trackedOutput.isEmpty();
    }
    public void reset() {
        trackedOutput.clear();
    }
}
