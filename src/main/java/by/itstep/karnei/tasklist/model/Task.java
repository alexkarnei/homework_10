package by.itstep.karnei.tasklist.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Task implements Serializable {
    private String headline;
    private String description;
    private Priority priority;
    private Date dateOfCreation;
    private Date dateOfEnd;
    private Executor executor;
    private PerformanceMark performanceMark;

    public  Task()  {
    }

    public Task(String headline
            , String description
            , Priority priority
            , Date dateOfCreation
            , Date dateOfEnd
            , Executor executor
            , PerformanceMark performanceMark) {

        this.headline = headline;
        this.description = description;
        this.priority = priority;
        this.dateOfCreation = dateOfCreation;
        this.dateOfEnd = dateOfEnd;
        this.executor = executor;
        this.performanceMark = performanceMark;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public Date getDateOfEnd() {
        return dateOfEnd;
    }

    public void setDateOfEnd(Date dateOfEnd) {
        this.dateOfEnd = dateOfEnd;
    }

    public Executor getExecutor() {
        return executor;
    }

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    public PerformanceMark getPerformanceMark() {
        return performanceMark;
    }

    public void setPerformanceMark(PerformanceMark performanceMark) {
        this.performanceMark = performanceMark;
    }

    @Override
    public String toString() {
        return "Task{" +
                "headline='" + headline + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", dateOfCreation=" + new SimpleDateFormat("dd.MM.yy").format(dateOfCreation) +
                ", dateOfEnd=" + new SimpleDateFormat("dd.MM.yy").format(dateOfEnd) +
                ", executor=" + executor +
                ", performanceMark=" + performanceMark +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return getHeadline().equals(task.getHeadline()) &&
                getDescription().equals(task.getDescription()) &&
                getPriority() == task.getPriority() &&
                getDateOfCreation().equals(task.getDateOfCreation()) &&
                getDateOfEnd().equals(task.getDateOfEnd()) &&
                getExecutor().equals(task.getExecutor()) &&
                getPerformanceMark() == task.getPerformanceMark();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHeadline()
                , getDescription()
                , getPriority()
                , getDateOfCreation()
                , getDateOfEnd()
                , getExecutor()
                , getPerformanceMark());
    }
}
