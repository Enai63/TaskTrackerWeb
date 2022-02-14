package ru.enai.tasktrackerweb.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.enai.tasktrackerweb.model.Status;
import ru.enai.tasktrackerweb.model.Task;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@ExtendWith(SpringExtension.class)
class TaskRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void testAddInRepository() {
        Task task = new Task();
        task.setName("new");
        task.setDescriptions("new task");
        task.setStatus(Status.NEW);

        testEntityManager.persist(task);
        testEntityManager.flush();

        Task task1 = taskRepository.findById(1L).orElseThrow();

        assertThat(task1).isEqualTo(task);
    }

}