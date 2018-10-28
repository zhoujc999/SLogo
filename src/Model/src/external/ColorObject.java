package external;

import java.util.Map;

public interface ColorObject {


    /**
     * @return a Map of any variables representing the state of this ModelPen. The variables should be doubles.
     */
    Map<String, Double> getState(String keyPrefix);

    /**
     * @return a Map of any variables representing the state of this ModelPen. The variables should be doubles.
     */
    Map<String, Double> getState();

    /**
     * Sets the object color to the color in the palette at the specified int index, returns that int.
     *
     * @param colorIndex the index of the desired color in the palette
     * @return an int representing the color.
     */
    int setColor(int colorIndex);

    /**
     * Sets the color found at the specified index in the palette to a color with the specified rgb combination.
     *
     * @param r an int from 0 - 255
     * @param b an int from 0 - 255
     * @param g an int from 0 - 255
     * @param index the index of the palette at which the new color should be found
     * @return index
     */
    int setPalette(int r, int g, int b, int index);

    /**
     * @return an int representing the pen color.
     */
    int getColor();

    int[][] getPalette();
}
