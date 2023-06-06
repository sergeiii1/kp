package com.example.taskcontrol;

public class Computer {
    String title;
    int id;
    /**
     * @param computerBuilder builder for computer
     */
    public Computer(ComputerBuilder computerBuilder)
    {
        this.title = computerBuilder.title;
        this.id = computerBuilder.id;
    }

    public String toString()
    {
        return title;
    }
    public static class ComputerBuilder
    {
        String title;
        int id;
        public ComputerBuilder(String title)
        {
            this.title = title;
        }

        public ComputerBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public Computer build()
        {
            return new Computer(this);
        }
    }

}
