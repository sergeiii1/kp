package com.example.taskcontrol;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ErrorTask extends Text {
    String error;
    TypeError type;
    LocalDateTime dateTime;
    int computerID;
    boolean fixed;
    int id;
    public ErrorTask(String error, LocalDateTime dateTime, boolean fixed, int computerID,TypeError type, int id)
    {
        super();
        this.computerID=computerID;
        this.type = type;
        this.error=error;
        this.id=id;
        this.fixed=fixed;
        this.dateTime=dateTime;
        switch (type)
        {
            case ERROR -> this.setFill(Color.YELLOW);
            case CRITICAL -> this.setFill(Color.RED);
            case WARNING -> this.setFill(Color.GREEN);
        }
        this.setText(this.toString());
    }

    @Override
    public String toString() {
        String fixedStr="";
        if(fixed) fixedStr = "(исправлено)";
        return error+"("+dateTime.format(DateTimeFormatter.ofPattern("yy.MM.dd HH:mm:ss"))+") "+fixedStr;
    }
}
