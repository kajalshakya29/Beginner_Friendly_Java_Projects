package model;

public class MyEmployee {
    private int eid;
    private String ename;
    private String edept;

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEdept() {
        return edept;
    }

    public void setEdept(String edept) {
        this.edept = edept;
    }

    @Override
    public String toString() {
        return "MyEmployee{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", edept='" + edept + '\'' +
                '}';
    }
}
