package personal.model;

public class User {
    private String id = "";
    private String header;
    private String text;
    private String note;

    public User(String header, String text, String note) {
        this.header = header;
        this.text = text;
        this.note = note;
    }

    public User(String id, String header, String text, String note) {
        this(header, text, note);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getText() {
        return text;
    }

            public void setText(String text) {
        this.text = text;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


    @Override
    public String toString() {
        return String.format("Идентафикатор: %s\nЗаголовок: %s,\nТекст: %s,\nПримечание: %s", id, header, text, note);
    }
}
