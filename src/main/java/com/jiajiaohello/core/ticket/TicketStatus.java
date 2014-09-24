package com.jiajiaohello.core.ticket;

/**
 * User: bohan
 * Date: 9/24/14
 * Time: 11:10 PM
 */
public enum TicketStatus {
    open(0, "打开"),
    editorConfirm(1, "编辑确认");
    private Integer id;
    private String name;

    TicketStatus(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "TicketStatus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
