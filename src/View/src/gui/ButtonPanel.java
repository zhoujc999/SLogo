package gui;public class ButtonPanel{private final gui.GUI GUI;	public ButtonPanel(gui.GUI GUI)	{		this.GUI = GUI;	}private javafx.scene.layout.GridPane buttonPanel() {
        var buttonPanel = new javafx.scene.layout.GridPane();
        buttonPanel.setLayoutX(gui.GUI.BUTTON_PANEL_LOCATION.getX());
        buttonPanel.setLayoutY(gui.GUI.BUTTON_PANEL_LOCATION.getY());
        buttonPanel.setPrefSize(gui.GUI.BUTTON_PANEL_SIZE.getWidth(), gui.GUI.BUTTON_PANEL_SIZE.getHeight());
        buttonPanel.setHgap(gui.GUI.SPACING);
        buttonPanel.setVgap(gui.GUI.SPACING);
        buttonPanel.setPadding(new javafx.geometry.Insets(gui.GUI.SPACING));

        buttonPanel.addColumn(0,
                new javafx.scene.text.Text(GUI.getMyResources().getString("BackgroundPicker")),
                new javafx.scene.text.Text(GUI.getMyResources().getString("TurtlePicker")),
                new javafx.scene.text.Text(GUI.getMyResources().getString("PenPicker")),
                new javafx.scene.text.Text(GUI.getMyResources().getString("LanguagePicker")));

        buttonPanel.addColumn(1,
                backgroundPicker(),
                turtlePicker(),
                penPicker(),
                languagePicker(),
                colorComboBox(GUI.getPenPaletteSupplier()),
                colorComboBox(GUI.getBackgroundPaletteSupplier())
        );

        buttonPanel.add(referenceButton(), 0, buttonPanel.getRowCount(), buttonPanel.getColumnCount(), 1);
        for (javafx.scene.Node node: buttonPanel.getChildren()) {
            buttonPanel.setHalignment(node, javafx.geometry.HPos.CENTER);
        }

        return buttonPanel;
    }private javafx.scene.control.ColorPicker backgroundPicker() {
        var picker = new javafx.scene.control.ColorPicker(javafx.scene.paint.Color.WHITE);
        picker.setStyle("-fx-color-label-visible: false");
        picker.setOnAction(e -> GUI.getMyGraphicsWindow().setBackground(picker.getValue()));
        return picker;
    }private javafx.scene.control.ComboBox turtlePicker() {
        var picker = new javafx.scene.control.ComboBox<java.lang.String>();
        var resource = java.util.ResourceBundle.getBundle(gui.GUI.DEFAULT_RESOURCES + "Turtles" + GUI.getMyLanguage());

        var images = resource.getKeys();
        while (images.hasMoreElements()) {
            picker.getItems().add(images.nextElement());
        }

        picker.setOnAction(e -> {
            java.lang.String filename = gui.GUI.TURTLE_IMAGES + resource.getString(picker.getValue()) + ".png";
            transformTurtles(new javafx.scene.image.ImageView(GUI.getClass().getResource(filename).toExternalForm()));
        });
        return picker;

    }private void transformTurtles(javafx.scene.image.ImageView img) {
        for (gui.TurtleView turtle: GUI.getMyGraphicsWindow().getTurtles()) {
            turtle.setImage(img.getImage());
        }
    }private javafx.scene.control.ComboBox colorComboBox(java.util.function.Supplier<int[][]> getPalette) {
        var picker = new javafx.scene.control.ComboBox<java.lang.Integer>();
        int[][] paletteAsRGB = getPalette.get();
        int numColors = paletteAsRGB.length;
        javafx.scene.paint.Color[] colorPalette = new javafx.scene.paint.Color[numColors];
        for (int i = 0; i<paletteAsRGB.length; i++) {
            int[] rgbArray = paletteAsRGB[i];
            colorPalette[i] = javafx.scene.paint.Color.rgb(rgbArray[0], rgbArray[1], rgbArray[2]);
            picker.getItems().add(i);
        }
//        picker.setValue(0);
        picker.setCellFactory(getColorPickerCellFactory(colorPalette));
        return picker;
    }private javafx.util.Callback<javafx.scene.control.ListView<java.lang.Integer>,javafx.scene.control.ListCell<java.lang.Integer>> getColorPickerCellFactory(javafx.scene.paint.Color[] colorPalette) {
        javafx.util.Callback cellFactory = new javafx.util.Callback<javafx.scene.control.ListView<java.lang.Integer>,javafx.scene.control.ListCell<java.lang.Integer>>() {
            @java.lang.Override
            public javafx.scene.control.ListCell<java.lang.Integer> call(javafx.scene.control.ListView<java.lang.Integer> param) {
                return new javafx.scene.control.ListCell<java.lang.Integer>() {
                    { super.setPrefWidth(100); }
                    @java.lang.Override
                    public void updateItem(java.lang.Integer item,
                                           boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            GUI.setText(item + "");
                            GUI.setTextFill(colorPalette[item]);
                        } else {
                            GUI.setText(null);
                        }
                    }
                };
            }
        };
        return cellFactory;
    }private javafx.scene.control.ColorPicker penPicker() {
        var picker = new javafx.scene.control.ColorPicker(javafx.scene.paint.Color.BLACK);
        picker.setStyle("-fx-color-label-visible: false ;");
        picker.setOnAction(e -> setTurtlePens(picker.getValue()));
        return picker;
    }private void setTurtlePens(javafx.scene.paint.Color color) {
        for (gui.TurtleView turtle: GUI.getMyGraphicsWindow().getTurtles()) {
            turtle.setPenColor(color);
        }
    }private javafx.scene.control.ComboBox languagePicker() {
        var picker = new javafx.scene.control.ComboBox<java.lang.String>();
        picker.getItems().addAll(gui.GUI.RECOGNIZED_LANGUAGES);
        picker.setOnAction(e -> GUI.setLanguage(picker.getValue()));
        return picker;
    }private javafx.scene.control.Button referenceButton() {
        var button = new javafx.scene.control.Button(GUI.getMyResources().getString("ReferenceButton"));
        button.setOnAction(e -> GUI.getMyCommandReference().show());
        return button;
    }}