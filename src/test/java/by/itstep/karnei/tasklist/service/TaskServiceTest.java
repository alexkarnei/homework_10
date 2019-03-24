package by.itstep.karnei.tasklist.service;

import by.itstep.karnei.tasklist.exception.TaskAlreadyExistException;
import by.itstep.karnei.tasklist.model.Executor;
import by.itstep.karnei.tasklist.model.PerformanceMark;
import by.itstep.karnei.tasklist.model.Priority;
import by.itstep.karnei.tasklist.model.Task;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class TaskServiceTest {

   private TaskServiceInterface serviceInterface = new TaskService();

    @Test
    public void testPositiveAddTask() throws IOException, ClassNotFoundException {

        Task task = new Task("Налоги"
                , "Оплата налогов"
                , Priority.NOT_URGENT_BUT_IMPORTANT
                , new Date(2019, 3, 20)
                , new Date(2019, 3, 22)
                , new Executor("Анна", "Иванова", "Главный бухгалтер")
                , PerformanceMark.SCHEDULED);

        Task task1 = new Task("Зарплата"
                , "Выплата зарплаты"
                , Priority.URGENT_AND_IMPORTANT
                , new Date(2019, 2, 15)
                , new Date(2019, 2, 15)
                , new Executor("Инна", "Афнасьева", "Бухгалтер")
                , PerformanceMark.DONE);

        try {
            serviceInterface.addTaskToFile(task);
            serviceInterface.addTaskToFile(task1);
        } catch (TaskAlreadyExistException e) {
        }
    }

    @Test(expected = TaskAlreadyExistException.class)
    public void testNegativeAddTask() throws TaskAlreadyExistException, IOException, ClassNotFoundException {

        Task task = new Task("Налоги"
                , "Оплата налогов"
                , Priority.NOT_URGENT_BUT_IMPORTANT
                , new Date(2019, 3, 20)
                , new Date(2019, 3, 22)
                , new Executor("Анна", "Иванова", "Главный бухгалтер")
                , PerformanceMark.SCHEDULED);

        serviceInterface.addTaskToFile(task);
    }

    @Test
    public void testReadTask() throws IOException, ClassNotFoundException {
        ArrayList<Task> taskArrayList = serviceInterface.readTasksFromFile();
        Assert.assertEquals(2, taskArrayList.size());
        System.out.println(taskArrayList);
    }
}
