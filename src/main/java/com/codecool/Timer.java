package com.codecool;

import java.util.concurrent.atomic.AtomicBoolean;

public class Timer implements Runnable {

    private static int count = 0;
    private int id = 0;

    private String timerName;

    private AtomicBoolean running = new AtomicBoolean(false);
    private AtomicBoolean stopped = new AtomicBoolean(false);

    private Thread thread;
    private long start;
    private long finish;
    private long timeElapsed;

    public Timer(String timerName) {
        this.start = System.currentTimeMillis();
        this.timerName = timerName;
        this.thread = new Thread(this,timerName);
        thread.start();
        id = count++;
    }

    public void interrupt() {
        running.set(false);
        thread.interrupt();
    }

    boolean isRunning() {
        return running.get();
    }

    boolean isStopped() {
        return stopped.get();
    }

    @Override
    public void run() {
        running.set(true);
        while (running.get()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            if (isStopped()) {
                break;
            }
            finish = System.currentTimeMillis();
            timeElapsed = finish - start;
        }
    }

    public String getTimerName() {
        return timerName;
    }

    @Override
    public String toString() {
        return id + " " + timerName + " " + timeElapsed/1000 + " s";
    }

    public void stop() {
        thread.interrupt();
        stopped.set(true);
    }
}
