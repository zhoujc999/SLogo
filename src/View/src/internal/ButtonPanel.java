package internal;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Callback;

import java.util.Map;
import java.util.ResourceBundle;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ButtonPanel extends GridPane {
    String myLanguage;
    ResourceBundle myResources;
    Consumer<String> myParsingFunc;
    Consumer<String> mySetLangFunc;
    private CommandReference myCommandReference;

    public ButtonPanel(String language, ResourceBundle resources, Map<String, Consumer<String>> stringConsumerMap, Map<String, Supplier> supplierMap) {
        myLanguage = language;
        myResources = resources;
        myParsingFunc = stringConsumerMap.get("parsingFunc");
        mySetLangFunc = stringConsumerMap.get("setLangFunc");
        myCommandReference = new CommandReference(myLanguage);
        this.setLayoutX(gui.GUI.BUTTON_PANEL_LOCATION.getX());
        this.setLayoutY(gui.GUI.BUTTON_PANEL_LOCATION.getY());
        this.setPrefSize(gui.GUI.BUTTON_PANEL_SIZE.getWidth(), gui.GUI.BUTTON_PANEL_SIZE.getHeight());
        this.setHgap(gui.GUI.SPACING);
        this.setVgap(gui.GUI.SPACING);
        this.setPadding(new Insets(gui.GUI.SPACING));
        this.addColumn(0,
                new Text(myResources.getString("BackgroundPicker")),
//                new Text(myResources.getString("TurtlePicker")),
                new Text(myResources.getString("PenPicker")),
                new Text(myResources.getString("LanguagePicker")));
        this.addColumn(1,
                backgroundPicker(),
//                turtlePicker(),
                penPicker(),
                languagePicker(),
                colorComboBox(supplierMap.get("penPalette"), "SetPenColor"),
                colorComboBox(supplierMap.get("backgroundPalette"), "SetBackground")
        );
        this.add(referenceButton(), 0, this.getRowCount(), this.getColumnCount(), 1);
        for (Node node : this.getChildren()) {
            this.setHalignment(node, HPos.CENTER);
        }
    }

    ColorPicker backgroundPicker() {
        var picker = new ColorPicker(Color.WHITE);
        //implement background controls
        return picker;
    }

//    ComboBox turtlePicker() {
//        var picker = new ComboBox<String>();
//        var resource = ResourceBundle.getBundle(gui.GUI.DEFAULT_RESOURCES + "Turtles" + myLanguage);
//
//        var images = resource.getKeys();
//        while (images.hasMoreElements()) {
//            picker.getItems().add(images.nextElement());
//        }
//
//        picker.setOnAction(e -> {
//            String filename = gui.GUI.TURTLE_IMAGES + resource.getString(picker.getValue()) + ".png";
//            transformTurtles(new ImageView(this.getClass().getResource(filename).toExternalForm()));
//        });
//        return picker;
//
//    }
//
//    void transformTurtles(ImageView img) {
//    }

    ComboBox colorComboBox(Supplier<int[][]> getPalette, String colorObjectRef) {
        var picker = new ComboBox<Integer>();
        int[][] paletteAsRGB = getPalette.get();
        int numColors = paletteAsRGB.length;
        Color[] colorPalette = new Color[numColors];
        for (int i = 0; i < paletteAsRGB.length; i++) {
            int[] rgbArray = paletteAsRGB[i];
            colorPalette[i] = Color.rgb(rgbArray[0], rgbArray[1], rgbArray[2]);
            picker.getItems().add(i);
        }
//        picker.setValue(0);
        picker.setCellFactory(getColorPickerCellFactory(colorPalette));
        picker.setOnAction(e -> myParsingFunc.accept(colorObjectRef +picker.getValue()));
        return picker;
    }

    Callback<ListView<Integer>, ListCell<Integer>> getColorPickerCellFactory(Color[] colorPalette) {
        Callback cellFactory = new Callback<ListView<Integer>, ListCell<Integer>>() {
            @Override
            public ListCell<Integer> call(ListView<Integer> param) {
                return new ListCell<Integer>() {
                    {
                        super.setPrefWidth(100);
                    }

                    @Override
                    public void updateItem(Integer item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item + "");
                            setTextFill(colorPalette[item]);
                        } else {
                            setText(null);
                        }
                    }
                };
            }
        };
        return cellFactory;
    }

    ColorPicker penPicker() {
        var picker = new ColorPicker(Color.BLACK);
        picker.setStyle("-fx-color-label-visible: false ;");
//        picker.setOnAction(e -> myParsingFunc.accept("pc " +picker.getValue()));
        return picker;
    }

    ComboBox languagePicker() {
        var picker = new ComboBox<String>();
        picker.getItems().addAll(gui.GUI.RECOGNIZED_LANGUAGES);
        picker.setOnAction(e -> {mySetLangFunc.accept(picker.getValue()); myCommandReference.setLanguage(picker.getValue());});
        return picker;
    }

    Button referenceButton() {
        var button = new Button(myResources.getString("ReferenceButton"));
        button.setOnAction(e -> myCommandReference.show());
        return button;
    }
}