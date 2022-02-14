package ru.enai.tasktrackerweb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "simple_tasks")
@Inheritance(strategy = InheritanceType.JOINED)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "description", length = 250)
    private String descriptions;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(name, task.name)
                && Objects.equals(descriptions, task.descriptions) && status == task.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, descriptions, status);
    }

    @Override
    public String toString() {
        return "id: " + id + " Task name: " + name +
                "\n" + "descriptions: " + descriptions +
                "\n" + "status: " + status;
    }
}


