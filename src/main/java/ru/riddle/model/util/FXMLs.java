package ru.riddle.model.util;

public enum FXMLs {
    MENU_SCREEN("/view/MenuScreenFXML.fxml"),
    SETTINGS_SCREEN("/view/SettingsScreenFXML.fxml"),
    AUTHORS_SCREEN("/view/AuthorsScreenFXML.fxml"),
    MENU_FORMULAS_SCREEN("/view/MenuFormulasScreenFXML.fxml"),
    THEORY_FIRST("/view/theory/TheoryFirstFXML.fxml"),
    THEORY_SECOND("/view/theory/TheorySecondFXML.fxml"),
    ;

    private final String path;

    FXMLs(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
