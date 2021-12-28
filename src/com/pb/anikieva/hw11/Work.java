package com.pb.anikieva.hw11;

public enum Work {
    ADD("добавление элемента"),
    DELETE("удаление элемента"),
    SEARCH("поиск элементов"),
    OUTPUT("вывод всех записей с сортировкой по указанному полю (имя)"),
    OUTPUT2("вывод всех записей с сортировкой по указанному полю (адрес)"),
    EDITING("редактирование элемента"),
    WRITING("запись в файл всех данных"),
    LOADING("загрузка из файла всех данных"),
    EXIT("выход");

    private String message;

    Work(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    public static Work WorkintoMenu(int num){
        Work[] values = values();
        return values[num -1];
    }

    @Override
    public String toString() {
        return (ordinal() + 1) + ". " + message;
    }
}