import animals.Animal;
import animals.packAnimals.Camel;
import animals.packAnimals.Donkey;
import animals.packAnimals.Horse;
import animals.pets.Cat;
import animals.pets.Dog;
import animals.pets.Hamster;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static animals.Animal.addToCountOfAnimals;

public class AnimalsRegister {

    private List<Animal> animalList;

    public void run() throws Exception {
        animalList = new ArrayList<>();

        while (true) {
            showAnimalsRegisterMenu();
            Scanner scanner = new Scanner(System.in);
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    addNewAnimal();
                    break;
                case 2:
                    showAllAnimals(animalList);
                    System.out.println("Введите номер животного, чтобы перейтки к его меню, или 0 для выхода обратно в меню");
                    int result = Integer.parseInt(scanner.nextLine());
                    if (result == 0) {
                        continue;
                    } else {
                        Animal curAnimal = animalList.get(result);
                        showAnimalMenu(curAnimal);
                        int secondOptionMenu = Integer.parseInt(scanner.nextLine());

                        switch (secondOptionMenu) {
                            case 1:
                                System.out.println(curAnimal);
                                System.out.println("Доступные способности::");
                                System.out.println("говорить");
                                if(curAnimal.isRunMethodImplemented()) System.out.println("бежать");
                                if(curAnimal.isStayMethodImplemented()) System.out.println("ждать");
                                break;
                            case 2:
                                if (!curAnimal.isRunMethodImplemented()) {
                                    curAnimal.setRunMethodImplemented(true);
                                }
                                break;
                            case 3:
                                if (!curAnimal.isStayMethodImplemented()) {
                                    curAnimal.setStayMethodImplemented(true);
                                }
                                break;
                            case 0:
                                System.out.println(curAnimal);
                                break;
                            default:
                                throw new Exception("Была указана неправильная цифра");
                        }
                    }
                    break;
                case 3:
                    showAllAnimalsTypes();
                    break;
                default:
                    throw new Exception("Введено неправильное число");
            }
        }

    }

    private void showAnimalsRegisterMenu() {
        System.out.println("1. Завести новое животное");
        System.out.println("2. Список животных");
        System.out.println("3. Показать доступные типы животных");
    }

    private void addNewAnimal() throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите вид животного из доступных \n" +
                "Собака, Кошка, Хомяк, Лошадь, Верблюд, Ослы");
        Animal newAnimal = getNewAnimalFromType(scanner.nextLine());

        System.out.println("Введите имя животного ::");
        newAnimal.setName(scanner.nextLine());

        System.out.println("Введите возраст животного ::");
        newAnimal.setAge(Integer.parseInt(scanner.nextLine()));

        animalList.add(newAnimal);
        addToCountOfAnimals();
        System.out.println("Новое животное было добавлено::" + newAnimal);
    }

    private void showAllAnimals(List<Animal> animalList) {
        for (Animal curAnimal : animalList) {
            System.out.println("--------");
            System.out.println(curAnimal);
            System.out.println("--------");
        }
    }

    private void showAllAnimalsTypes() {
        System.out.println("Домание животные::");
        System.out.println("----Собака");
        System.out.println("----Кошка");
        System.out.println("----Хомяк");
        System.out.println("Вьючные животные::");
        System.out.println("----Лошадь");
        System.out.println("----Верблюд");
        System.out.println("----Ослы");
    }

    private Animal getNewAnimalFromType(String type) throws Exception {
        return switch (type) {
            case "Собака" -> new Dog();
            case "Кошка" -> new Cat();
            case "Хомяк" -> new Hamster();
            case "Лошадь" -> new Horse();
            case "Верблюд" -> new Camel();
            case "Ослы" -> new Donkey();
            default -> throw new Exception("Неправильно указан тип животного");
        };
    }

    private void showAnimalMenu(Animal animal) {
        System.out.println("1. Посмотреть описание");
        if (!animal.isRunMethodImplemented()) {
            System.out.println("2. Добавить бег");
        }
        if (!animal.isStayMethodImplemented()) {
            System.out.println("3. Добавить прыжок");
        }
        System.out.println("0. ничего не делать");
    }


}
