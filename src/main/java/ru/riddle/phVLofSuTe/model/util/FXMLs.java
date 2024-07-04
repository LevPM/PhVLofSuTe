package ru.riddle.phVLofSuTe.model.util;

import java.util.List;

public enum FXMLs {
    MENU_SCREEN("/view/MenuScreenFXML.fxml"),
    SETTINGS_SCREEN("/view/SettingsScreenFXML.fxml"),
    AUTHORS_SCREEN("/view/AuthorsScreenFXML.fxml"),

    MENU_TE_SELECTION("/view/MenuTheoryExperimentsSelection.fxml"),


    THEORY_SELECTION("/view/theory/TheorySelection.fxml"),

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

    THEORY_FIFTH_EXAMPLE_1("/view/theory/examples/fifthExample/TheoryFifthExample1.fxml", "FifthExample1"),
    THEORY_FIFTH_EXAMPLE_2("/view/theory/examples/fifthExample/TheoryFifthExample2.fxml", "FifthExample2"),
    THEORY_FIFTH_EXAMPLE_3("/view/theory/examples/fifthExample/TheoryFifthExample3.fxml", "FifthExample3"),
    THEORY_FIFTH_EXAMPLE_4("/view/theory/examples/fifthExample/TheoryFifthExample4.fxml", "FifthExample4"),
    THEORY_FIFTH_EXAMPLE_5("/view/theory/examples/fifthExample/TheoryFifthExample5.fxml", "FifthExample5"),
    THEORY_FIFTH_EXAMPLE_6("/view/theory/examples/fifthExample/TheoryFifthExample6.fxml", "FifthExample6"),

    THEORY_SIXTH_EXAMPLE_1("/view/theory/examples/sixthExample/TheorySixthExample1.fxml", "SixthExample1"),
    THEORY_SIXTH_EXAMPLE_2("/view/theory/examples/sixthExample/TheorySixthExample2.fxml", "SixthExample2"),
    THEORY_SIXTH_EXAMPLE_3("/view/theory/examples/sixthExample/TheorySixthExample3.fxml", "SixthExample3"),
    THEORY_SIXTH_EXAMPLE_4("/view/theory/examples/sixthExample/TheorySixthExample4.fxml", "SixthExample4"),
    THEORY_SIXTH_EXAMPLE_5("/view/theory/examples/sixthExample/TheorySixthExample5.fxml", "SixthExample5"),
    THEORY_SIXTH_EXAMPLE_6("/view/theory/examples/sixthExample/TheorySixthExample6.fxml", "SixthExample6"),


    EXPERIMENTS_MENU("/view/experiments/ExperimentsMenu.fxml"),

    EXPERIMENTS_FIRST_1("/view/experiments/firstExperiment/firstExperiment1.fxml", "FirstExperiment1"),
    EXPERIMENTS_FIRST_2("/view/experiments/firstExperiment/firstExperiment2.fxml", "FirstExperiment2"),
    EXPERIMENTS_FIRST_3("/view/experiments/firstExperiment/firstExperiment3.fxml", "FirstExperiment3"),
    EXPERIMENTS_FIRST_4("/view/experiments/firstExperiment/firstExperiment4.fxml", "FirstExperiment4"),

    EXPERIMENTS_SECOND_1("/view/experiments/secondExperiment/secondExperiment1.fxml"),

    EXPERIMENTS_THIRD("/view/experiments/thirdExperiment/thirdExperiment.fxml"),

    SYRINGE("/view/experiments/syringe/syringeFXML.fxml"),
    SYRINGE_BODY_SEGMENT("/view/experiments/syringe/syringeBodySegmentFXML.fxml"),
    SYRINGE_TIP("/view/experiments/syringe/syringeTipFXML.fxml"),
    SYRINGE_PISTON("/view/experiments/syringe/syringePistonFXML.fxml"),
    SYRINGE_PISTON_SEGMENT("/view/experiments/syringe/syringePistonRodSegmentFXML.fxml"),
    SYRINGE_PISTON_TIP("/view/experiments/syringe/syringePistonTipFXML.fxml"),
    SYRINGE_PISTON_CAP("/view/experiments/syringe/syringePistonCap.fxml"),

    LIQUID_SETTING("/view/experiments/thirdExperiment/settings/liquidSettingFXML.fxml"),
    ;

    public static final List<FXMLs> firstExperiment = List.of(
            EXPERIMENTS_FIRST_1,
            EXPERIMENTS_FIRST_2,
            EXPERIMENTS_FIRST_3,
            EXPERIMENTS_FIRST_4
    );

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

    public static final List<FXMLs> fifthExample = List.of(
            THEORY_FIFTH_EXAMPLE_1,
            THEORY_FIFTH_EXAMPLE_2,
            THEORY_FIFTH_EXAMPLE_3,
            THEORY_FIFTH_EXAMPLE_4,
            THEORY_FIFTH_EXAMPLE_5,
            THEORY_FIFTH_EXAMPLE_6
    );

    public static final List<FXMLs> sixthExample = List.of(
            THEORY_SIXTH_EXAMPLE_1,
            THEORY_SIXTH_EXAMPLE_2,
            THEORY_SIXTH_EXAMPLE_3,
            THEORY_SIXTH_EXAMPLE_4,
            THEORY_SIXTH_EXAMPLE_5,
            THEORY_SIXTH_EXAMPLE_6
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
