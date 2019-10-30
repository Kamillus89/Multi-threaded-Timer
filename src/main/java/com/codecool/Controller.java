package com.codecool;

import java.util.HashMap;
import java.util.Map;

public class Controller {

    private View view;
    private Timer timer;
    private Map<String, Timer> timers;

    public Controller() {
        this.view = new View();
        this.timers = new HashMap<>();
    }

    void run() throws InterruptedException {
        String option;
        String[] userInputs;
        String timerName = "Empty name, something went wrong!";
        boolean isRunning = true;

        while (isRunning) {
            userInputs = view.askUserForInput();
            option = userInputs[0];
            if (userProvided2Inputs(userInputs)) {
                timerName = userInputs[1];
            }
            switch (option) {
                case "start":
                    startNewTimer(timerName);
                    break;
                case "stop":
                    stopTimerByName(timerName);
                    break;
                case "check":
                    checkTimerByName(timerName);
                    break;
                case "checkAll":
                    checkAllTimers();
                    break;
                case "exit":
                    isRunning = false;
                    break;
                default:
                    view.displayWrongUserInputMessage();
            }
        }
    }

    private void checkAllTimers() {
        for (Timer timer : timers.values()) {
            System.out.println(timer.toString());
        }
    }

    private void checkTimerByName(String timerName) {
        System.out.println(timers.get(timerName).toString());
    }

    private void stopTimerByName(String timerName) throws InterruptedException {
        timers.get(timerName).stop();
    }

    private boolean userProvided2Inputs(String[] userInputs) {
        return userInputs.length > 1;
    }

    private void startNewTimer(String timerName) {
        timer = new Timer(timerName);
        timers.put(timerName, timer);
    }

}
