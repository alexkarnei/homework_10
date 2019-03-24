package by.itstep.karnei.tasklist.service;

import by.itstep.karnei.tasklist.exception.TaskAlreadyExistException;
import by.itstep.karnei.tasklist.model.Task;

import java.io.IOException;
import java.util.ArrayList;

public interface TaskServiceInterface {

    void addTaskToFile(Task task) throws IOException, ClassNotFoundException, TaskAlreadyExistException;

    ArrayList<Task> readTasksFromFile() throws IOException, ClassNotFoundException;
}
