package ru.riddle.model.util;

public enum FXMLs {
    MENU_SCREEN("/view/MenuScreenFXML.fxml"),
    SETTINGS_SCREEN("/view/SettingsScreenFXML.fxml"),
    AUTHORS_SCREEN("/view/AuthorsScreenFXML.fxml"),
    MENU_FORMULAS_SCREEN("/view/MenuFormulasScreenFXML.fxml"),
    THEORY_FIRST("/view/theory/TheoryFirstFXML.fxml", "First"),
    THEORY_SECOND("/view/theory/TheorySecondFXML.fxml", "Second"),
    THEORY_THIRD("/view/theory/TheoryThirdFXML.fxml", "Third"),
    THEORY_EXAMPLES_MENU("/view/theory/TheoryExamplesMenu.fxml", "ExamplesMenu"),

    THEORY_FIRST_EXAMPLE_1("/view/theory/examples/firstTask/TheoryFirstExample1.fxml", "FirstExample1"),
    THEORY_FIRST_EXAMPLE_2("/view/theory/examples/firstTask/TheoryFirstExample2.fxml", "FirstExample2"),
    THEORY_FIRST_EXAMPLE_3("/view/theory/examples/firstTask/TheoryFirstExample3.fxml", "FirstExample3"),
    THEORY_FIRST_EXAMPLE_4("/view/theory/examples/firstTask/TheoryFirstExample4.fxml", "FirstExample4")
    ;

    private final String path;
    private String id;

    FXMLs(String path) {
        this.path = path;
    }

    FXMLs(String path, String id) {
        this.path = path;
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public String getId() {
        return id;
    }
}
