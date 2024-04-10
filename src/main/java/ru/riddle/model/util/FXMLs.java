package ru.riddle.model.util;

public enum FXMLs {
    MENU_SCREEN("/view/MenuScreenFXML.fxml"),
    SETTINGS_SCREEN("/view/SettingsScreenFXML.fxml"),
    AUTHORS_SCREEN("/view/AuthorsScreenFXML.fxml"),
    MENU_FORMULAS_SCREEN("/view/MenuFormulasScreenFXML.fxml"),
    THEORY_FIRST("/view/theory/TheoryFirstFXML.fxml", "First"),
    THEORY_SECOND("/view/theory/TheorySecondFXML.fxml", "Second"),
    THEORY_THIRD("/view/theory/TheoryThirdFXML.fxml", "Third"),
    THEORY_FOURTH("/view/theory/examples/firstTask/TheoryFirstExample1.fxml", "Fourth"),
    THEORY_FIFTH("/view/theory/examples/firstTask/TheoryFirstExample2.fxml", "Fifth"),
    THEORY_SIXTH("/view/theory/examples/firstTask/TheoryFirstExample3.fxml", "Sixth"),
    THEORY_SEVENTH("/view/theory/examples/firstTask/TheoryFirstExample4.fxml", "Seventh")
    ;

    private final String path;
    private String id;

    FXMLs(String path) {
        this.path = path;
    }
    FXMLs(String path, String id) {
        this.path = path; this.id = id;
    }

    public String getPath() {
        return path;
    }

    public String getId() {
        return id;
    }
}
