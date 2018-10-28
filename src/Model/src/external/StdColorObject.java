package external;

import java.util.Map;

public class StdColorObject implements ColorObject{

    public static final String COLOR_INDEX_KEY = "ColorIndex";
    public static final String COLOR_R_KEY = "ColorRVal";
    public static final String COLOR_G_KEY = "ColorGVal";
    public static final String COLOR_B_KEY = "ColorBVal";
    private int[][] colorPalette = {
            {0, 0, 0}, {0 , 0, 255}, {0, 255, 0}, {0, 255, 255},
            {255, 0, 0}, {255 , 0, 255}, {255, 255, 0}, {255, 255, 255},
            {127, 0, 0}, {0, 127, 0}, {0, 0, 127}, {0, 127, 255},
            {255, 127, 127}, {127 , 0, 255}, {255, 127, 0}, {127, 127, 127}
    };
    private static final int rIndex = 0;
    private static final int gIndex = 1;
    private static final int bIndex = 2;
    private double returnVal;
    private int colorIndex;

    @Override
    public Map<String, Double> getState(String prefix) {
        return Map.ofEntries(
                Map.entry(prefix + COLOR_INDEX_KEY, (double) this.colorIndex),
                Map.entry(prefix + COLOR_R_KEY, (double) colorPalette[this.colorIndex][rIndex]),
                Map.entry(prefix + COLOR_G_KEY, (double) colorPalette[this.colorIndex][gIndex]),
                Map.entry(prefix + COLOR_B_KEY, (double) colorPalette[this.colorIndex][bIndex])
        );
    }

    @Override
    public Map<String, Double> getState() {
        return getState("");
    }

    /**
     * Sets the color found at the specified index in the palette to a color with the specified rgb combination.
     *
     * @param r     an int from 0 - 255
     * @param g     an int from 0 - 255
     * @param b     an int from 0 - 255
     * @param index the index of the palette at which the new color should be found
     * @return index
     */
    @Override
    public int setPalette(int r, int g, int b, int index) {
        colorPalette[index][rIndex] = r;
        colorPalette[index][gIndex] = g;
        colorPalette[index][bIndex] = b;
        returnVal = index;
        return index;
    }

    /**
     * Set the pen color based on the specified int, returns that int.
     *
     * @param colorIndex
     * @return an int representing the pen color.
     */
    @Override
    public int setColor(int colorIndex) {
        this.colorIndex = colorIndex;
        returnVal = colorIndex;
        return this.colorIndex;

    }

    /**
     * @return an int representing the pen color.
     */
    @Override
    public int getColor() {
        returnVal = this.colorIndex;
        return this.colorIndex;
    }

    public int[][] getPalette() {
        return colorPalette;
    }


}
