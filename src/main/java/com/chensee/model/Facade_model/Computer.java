package com.chensee.model.Facade_model;

public class Computer implements Common{
    private CPU cpu;
    private Disk disk;

    public Computer() {
        cpu = new CPU();
        disk = new Disk();
    }

    @Override
    public void start() {
        cpu.start();
        disk.start();
    }

    @Override
    public void close() {
        cpu.close();
        disk.close();
    }
}
