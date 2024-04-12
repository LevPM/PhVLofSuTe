package ru.riddle.model.util;

import java.util.List;

public enum FXMLs {
    MENU_SCREEN("/view/MenuScreenFXML.fxml"),
    SETTINGS_SCREEN("/view/SettingsScreenFXML.fxml"),
    AUTHORS_SCREEN("/view/AuthorsScreenFXML.fxml"),

    MENU_FORMULAS_SCREEN("/view/MenuFormulasScreenFXML.fxml"),

    THEORY_FIRST("/view/theory/TheoryFirstFXML.fxml", "First"),
    THEORY_SECOND("/view/theory/TheorySecondFXML.fxml", "Second"),
    THEORY_THIRD("/view/theory/TheoryThirdFXML.fxml", "Third"),
    THEORY_EXAMPLES_MENU("/view/theory/TheoryExamplesMenu.fxml", "ExamplesMenu"),

    THEORY_FIRST_EXAMPLE_1("/view/theory/examples/firstExample/TheoryFirstExample1.fxml", "FirstExample1"),
    THEORY_FIRST_EXAMPLE_2("/view/theory/examples/firstExample/TheoryFirstExample2.fxml", "FirstExample2"),
    THEORY_FIRST_EXAMPLE_3("/view/theory/examples/firstExample/TheoryFirstExample3.fxml", "FirstExample3"),
    THEORY_FIRST_EXAMPLE_4("/view/theory/examples/firstExample/TheoryFirstExample4.fxml", "FirstExample4"),

    THEORY_SECOND_EXAMPLE_1("/view/theory/examples/secondExample/TheorySecondExample1.fxml", "SecondExample1"),
    THEORY_SECOND_EXAMPLE_2("/view/theory/examples/secondExample/TheorySecondExample2.fxml", "SecondExample2"),
    THEORY_SECOND_EXAMPLE_3("/view/theory/examples/secondExample/TheorySecondExample3.fxml", "SecondExample3"),
    THEORY_SECOND_EXAMPLE_4("/view/theory/examples/secondExample/TheorySecondExample4.fxml", "SecondExample4"),

    THEORY_THIRD_EXAMPLE_1("/view/theory/examples/thirdExample/TheoryThirdExample1.fxml", "ThirdExample1"),
    THEORY_THIRD_EXAMPLE_2("/view/theory/examples/thirdExample/TheoryThirdExample2.fxml", "ThirdExample2"),
    THEORY_THIRD_EXAMPLE_3("/view/theory/examples/thirdExample/TheoryThirdExample3.fxml", "ThirdExample3"),
    THEORY_THIRD_EXAMPLE_4("/view/theory/examples/thirdExample/TheoryThirdExample4.fxml", "ThirdExample4"),

    THEORY_FOURTH_EXAMPLE_1("/view/theory/examples/fourthExample/TheoryFourthExample1.fxml", "FourthExample1"),
    THEORY_FOURTH_EXAMPLE_2("/view/theory/examples/fourthExample/TheoryFourthExample2.fxml", "FourthExample2"),
    THEORY_FOURTH_EXAMPLE_3("/view/theory/examples/fourthExample/TheoryFourthExample3.fxml", "FourthExample3"),
    THEORY_FOURTH_EXAMPLE_4("/view/theory/examples/fourthExample/TheoryFourthExample4.fxml", "FourthExample4"),
    ;

    public static final List<FXMLs> firstExample = List.of(
            THEORY_FIRST_EXAMPLE_1,
            THEORY_FIRST_EXAMPLE_2,
            THEORY_FIRST_EXAMPLE_3,
            THEORY_FIRST_EXAMPLE_4
    );

    public static final List<FXMLs> secondExample = List.of(
            THEORY_SECOND_EXAMPLE_1,
            THEORY_SECOND_EXAMPLE_2,
            THEORY_SECOND_EXAMPLE_3,
            THEORY_SECOND_EXAMPLE_4
    );

    public static final List<FXMLs> thirdExample = List.of(
            THEORY_THIRD_EXAMPLE_1,
            THEORY_THIRD_EXAMPLE_2,
            THEORY_THIRD_EXAMPLE_3,
            THEORY_THIRD_EXAMPLE_4
    );

    public static final List<FXMLs> fourthExample = List.of(
            THEORY_FOURTH_EXAMPLE_1,
            THEORY_FOURTH_EXAMPLE_2,
            THEORY_FOURTH_EXAMPLE_3,
            THEORY_FOURTH_EXAMPLE_4
    );

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
