package ru.riddle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printMenu();

        switch (scanner.nextInt()){
            case 1 -> startFormulaE(scanner);
            case 2 -> startFormulaCoe(scanner);
            case 3 -> startFormulaF(scanner);
            default -> {
                System.out.println("Неверно набран номер");
                printMenu();
            }
        }


    }

    private static void printDashes(){
        System.out.println("-".repeat(15));
    }

    private static void printFormulaEofSuTe(){
        System.out.println("W = σS");
        System.out.println("W — поверхностная энергия жидкости [Дж]");
        System.out.println("S — площадь свободной поверхности [м2]");
        System.out.println("σ — коэффициент поверхностного натяжения [Н/м]");
        printDashes();
    }

    private static void printFormulaCoeOfSuTe(){
        System.out.println("σ = W/S");
        System.out.println("W — поверхностная энергия жидкости [Дж]");
        System.out.println("S — площадь свободной поверхности [м2]");
        System.out.println("σ — коэффициент поверхностного натяжения [Н/м]");
        printDashes();
    }
    private static void printFormulaFofSuTe(){
        System.out.println("F = σl");
        System.out.println("F — сила поверхностного натяжения [Н]");
        System.out.println("l — длина контура, ограничивающего поверхность жидкости [м]");
        System.out.println("σ — коэффициент поверхностного натяжения [Н/м]");
        printDashes();
    }

    private static void startFormulaE(Scanner scanner){
        double S;
        double σ;
        System.out.println("Введите следующие значения:");
        System.out.print("S [м2] = ");
        S = scanner.nextDouble();
        System.out.print("σ [Н/м] = ");
        σ = scanner.nextDouble();
        System.out.println();
        System.out.println("W = " + S * σ);
        printDashes();
        askForContinue(scanner);
    }

    private static void startFormulaCoe(Scanner scanner){
        double W;
        double S;
        System.out.println("Введите следующие значения:");
        System.out.print("W [Дж] = ");
        W = scanner.nextDouble();
        System.out.print("S [м2] = ");
        S = scanner.nextDouble();
        System.out.println();
        System.out.println("σ = " + W * S);
        printDashes();
        askForContinue(scanner);
    }

    private static void startFormulaF(Scanner scanner){
        double l;
        double σ;
        System.out.println("Введите следующие значения:");
        System.out.print("l [м] = ");
        l = scanner.nextDouble();
        System.out.print("σ [Н/м] = ");
        σ = scanner.nextDouble();
        System.out.println();
        System.out.println("σ = " + l * σ);
        printDashes();
        askForContinue(scanner);
    }

    private static void printMenu(){
        System.out.println("Основные формулы темы \"Поверхностное натяжение\":");
        printDashes();
        System.out.println("1. W = σS");
        System.out.println("2. σ = W/S");
        System.out.println("3. F = σl");
        printDashes();
        System.out.println("Какой формулой необходимо воспользоваться?(Введите номер)");
    }

    private static void askForContinue(Scanner scanner){
        System.out.println("Продолжить?");
        if(scanner.hasNext()){
            printMenu();
        }
    }
}