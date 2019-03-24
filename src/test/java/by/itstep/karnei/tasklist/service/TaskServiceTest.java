package by.itstep.karnei.tasklist.service;

import by.itstep.karnei.tasklist.exception.TaskAlreadyExistException;
import by.itstep.karnei.tasklist.model.Executor;
import by.itstep.karnei.tasklist.model.PerformanceMark;
import by.itstep.karnei.tasklist.model.Priority;
import by.itstep.karnei.tasklist.model.Task;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TaskServiceTest {

    TaskServiceInterface serviceInterface = new TaskService();
    @Test
    public void testPositiveAddTask() throws IOException, ClassNotFoundException {

        Task task = new Task("Налоги"
                , "Оплата налогов"
                , Priority.URGENT_AND_IMPORTANT
                , new Date(2019, 3, 20)
                , new Date(2019, 3, 22)
                , new Executor("Анна", "Иванова", "Главный бухгалтер")
                , PerformanceMark.SCHEDULED);

        try {
            serviceInterface.addTaskToFile(task);
        } catch (TaskAlreadyExistException e) {
        }
    }

    @Test(expected = TaskAlreadyExistException.class)
    public void testNegativeAddTask() throws TaskAlreadyExistException, IOException, ClassNotFoundException {

        TaskServiceInterface serviceInterface = new TaskService();

        Task task = new Task("Налоги"
                , "Оплата налогов"
                , Priority.URGENT_AND_IMPORTANT
                , new Date(2019,3,20)
                , new Date(2019, 3, 22)
                , new Executor("Анна", "Иванова", "Главный бухгалтер")
                , PerformanceMark.SCHEDULED);

        serviceInterface.addTaskToFile(task);
    }

    @Test
    public void testReadTask() throws IOException, ClassNotFoundException {
        ArrayList<Task> taskArrayList = serviceInterface.readTasksFromFile();
        Assert.assertEquals(1,taskArrayList.size());
        System.out.println(taskArrayList);
    }
}
