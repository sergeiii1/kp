package com.example.taskcontrol;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Computers {
    ObservableList<Computer> observableList = FXCollections.observableArrayList();

    /**
     * @param title name for computer in local net
     */
    public void add(String title)
    {
        observableList.add(DatabaseAdapter.getComputer(DatabaseAdapter.addComputer(new Computer.ComputerBuilder(title).build())));

    }
    /**
     * @param computer for removing
     */
    public void remove(Computer computer)
    {
        DatabaseAdapter.deletePC(computer.id);
        observableList.remove(computer);
    }
}
