package by.itstep.karnei.tasklist.model;

public enum Priority {
    URGENT_AND_IMPORTANT("Срочно и важно"),
    NOT_URGENT_BUT_IMPORTANT("Не срочно но выжно"),
    URGENT_BUT_NOT_IMPORTANT("Срочно не не важно"),
    NOT_URGENT_AND_NOT_IMPORTANT("Не срочно и не важно");
    private String string;

    Priority() {
    }

    Priority(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

}
