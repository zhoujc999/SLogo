package internal;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.util.ResourceBundle;

public class CommandReference extends Stage {
    /**
     * CommandReference provides users with a list of all the commands initially recognized by the SLogo program. It is
     * displayed due to the click of a button and can be hidden again with another click of the button. It would need
     * access to the languages resources.
     *
     * @author Tahj Starr
     */

    private static final Font COMMAND_CATEGORIES_FONT = new Font("Agency FB", 30);
    private static final Font DESCRIPTIONS_FONT = new Font(10);

    private String DEFAULT_RESOURCES = "Reference";
    private ResourceBundle myCommandCategories;
    private String myLanguage;

    public CommandReference(String language) {
        myLanguage = language;
        myCommandCategories = ResourceBundle.getBundle(DEFAULT_RESOURCES + language + "/CommandCategories");
        setScene(new Scene(writePage(), 600, 800));
    }

    private Parent writePage() {
        var page = new VBox();
        var commandCategories = myCommandCategories.getKeys();
        while (commandCategories.hasMoreElements()) {
            String category = commandCategories.nextElement();

            var categoryText = new Text(category);
            categoryText.setFont(COMMAND_CATEGORIES_FONT);
            page.getChildren().add(categoryText);

            var descriptionResources = ResourceBundle.getBundle(DEFAULT_RESOURCES + myLanguage + "/" + category);
            var descriptions = descriptionResources.getKeys();
            while (descriptions.hasMoreElements()) {
                String description = descriptions.nextElement();

                var descriptionText = new Text(description + " : " + descriptionResources.getString(description));
                descriptionText.setFont(DESCRIPTIONS_FONT);
                page.getChildren().add(descriptionText);
            }
        }
        return new ScrollPane(page);
    }

//    /**
//     * Shows command reference page in a another stage.
//     */
//    void show();
//
//    /**
//     * Hides the command reference page.
//     */
//    void hide();

    /**
     * Sets the language of the text in CommandReference.
     */
    void setLanguage(String language) {
        myLanguage = language;
    }

}
