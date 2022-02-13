package ru.enai.tasktrackerweb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class SubTask extends Task {

    @ManyToOne
    private EpicTask epicTask;

    @Override
    public String toString() {
        return "Id: " + super.getId() +
                "\n" + "SubTask name: " + super.getName() +
                "\n" + "description: " + super.getDescriptions() +
                "\n" + "status: " + super.getStatus() +
                "\n" + "epicTask: " + epicTask.getName();
    }
}
