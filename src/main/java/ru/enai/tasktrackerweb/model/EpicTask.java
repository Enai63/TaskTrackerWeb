package ru.enai.tasktrackerweb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class EpicTask extends Task {

    @OneToMany
    @Column(name = "list_sub_task")
    private List<SubTask> subTask;

    @Override
    public String toString() {
        return "Id: " + super.getId() +
                "\n" + "EpicTask name: " + super.getName() +
                "\n" + "Description: " + super.getDescriptions() +
                "\n" + "Status: " + subTask +
                "\n" + "List sub task " + subTask;
    }
}
