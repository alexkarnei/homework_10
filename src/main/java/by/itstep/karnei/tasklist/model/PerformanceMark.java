package by.itstep.karnei.tasklist.model;

public enum PerformanceMark {
    SCHEDULED("Выполнить по времени"),
    DONE("Выполнено"),
    PERFORMED("Выполняется"),
    NOT_PERFORMED("Не выполнено");
    private String string;

    PerformanceMark() {
    }

    PerformanceMark(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

}
