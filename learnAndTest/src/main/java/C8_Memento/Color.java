package C8_Memento;

public enum Color {

    WHITE(1,"白"),
    BLACK(2,"黑");

    private Integer color;

    private String colorDesc;

    Color(Integer color, String colorDesc){
        this.color = color;
        this.colorDesc = colorDesc;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public String getColorDesc() {
        return colorDesc;
    }

    public void setColorDesc(String colorDesc) {
        this.colorDesc = colorDesc;
    }
}
