package enums;

public enum COLORS {
    RED(0,"red"),
    BLUE(1,"blue"),
    GREEN(2, "green"),
    YELLOW(3, "yellow");
	
    private Integer indexColor;
    private String colorName;

    private COLORS(int indexColor, String colorName) {
        this.indexColor = indexColor;
        this.colorName = colorName;
    }

    public int getIndexColor() {
        return indexColor;
    }
    
    public String getColorName() {
        return colorName;
    }
}
