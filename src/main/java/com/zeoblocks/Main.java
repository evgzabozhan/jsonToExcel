package com.zeoblocks;

import java.io.IOException;
import java.util.Scanner;

import static com.zeoblocks.JsonFile.jsonMap;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите путь до JSON файла: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        JsonFile obj = new JsonFile();
        while (true) {
            try {
                obj.parseData(obj.getDataFromJson(name));
                break;
            } catch (Exception e) {
                System.out.println("Файл не найден " + e + "\nПовторите ввод");
                name = scanner.nextLine();
            }
        }
        System.out.println("Введите путь для итогового excel файла:");
        String excelName = scanner.next();
        ExcelFile file = new ExcelFile();
        file.createFile(jsonMap, excelName);
        System.out.println("Нажмите Enter для выхода");
        Scanner exit = new Scanner(System.in);
        exit.nextLine();
        System.out.println("Пока!");
    }
}