package ru.enai.tasktrackerweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.enai.tasktrackerweb.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
