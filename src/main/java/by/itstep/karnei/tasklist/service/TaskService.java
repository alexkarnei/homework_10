package by.itstep.karnei.tasklist.service;

import by.itstep.karnei.tasklist.exception.TaskAlreadyExistException;
import by.itstep.karnei.tasklist.model.Task;

import java.io.*;
import java.util.ArrayList;

public class TaskService implements TaskServiceInterface {
    private static final String FILE_NAME = "tasklist.txt";
    private File file = new File(FILE_NAME);

    public void addTaskToFile(Task task) throws IOException, ClassNotFoundException, TaskAlreadyExistException {
        if (!file.exists()) {
            file.createNewFile();
            recordTask(task);
        } else if (file.length() != 0) {
            ArrayList<Task> taskArrayList = getTasks();
            for (Task e : taskArrayList) {
                if (e.equals(task)) {
                    throw new TaskAlreadyExistException();
                }
                recordTask(task);
            }
        } else recordTask(task);
    }

    private void recordTask(Task task) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(task);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    private ArrayList<Task> getTasks() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
        ArrayList<Task> taskList = new ArrayList<>();
        try {
            for (; ; ) {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                taskList.add((Task) objectInputStream.readObject());
            }
        } catch (EOFException e) {
        }
        return taskList;
    }

    public ArrayList<Task> readTasksFromFile() throws IOException, ClassNotFoundException {
        ArrayList<Task> taskArrayList = getTasks();
        return taskArrayList;
    }
}
