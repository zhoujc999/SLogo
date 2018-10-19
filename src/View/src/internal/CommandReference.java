package internal;

public interface CommandReference {
    /**
     * CommandReference provides users with a list of all the commands initially recognized by the SLogo program. It is
     * displayed due to the click of a button and can be hidden again with another click of the button. It would need
     * access to the languages resources.
     *
     * @author Tahj Starr
     */

    /**
     * Shows command reference page in a another stage.
     */
    void show();

    /**
     * Hides the command reference page.
     */
    void hide();

    /**
     * Sets the language of the text in CommandReference.
     */
    void setLanguage(String language);

}
