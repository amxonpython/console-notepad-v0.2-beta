import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import clases.comands;

public class Main {
    public static void main(String[] args) {

        //настраиваем библиотеки
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        System.out.println("console notepad v0.2 beta");
        int id_text = -1;

        boolean working = true;
        while (working){
            System.out.println("выберите команду: ");
            String commande = scanner.nextLine();

            switch (commande){
                case "help":
                    comands.help();
                    break;
                case "exit":
                    working = false;
                    break;
                case "saved":
                    System.out.println("введите текст для сохранения: ");
                    String text = scanner.nextLine();
                    if (text.isEmpty()){
                        System.out.println("вы нечего не ввели");
                    }else {
                        id_text++;

                        list.add(text);
                        System.out.println("id сохранённого текста: " + id_text);
                    }
                    break;
                case "take out":
                    if (id_text >= 0){
                        System.out.println("введите id объекта который хотите вывести, максимальный id:" + id_text);

                        int zapros_id = scanner.nextInt();
                        scanner.nextLine();
                        if (zapros_id > id_text){
                            comands.Too_big_id();
                        }else {
                            System.out.println(list.get(zapros_id));
                        }
                    }else {
                        System.out.println("лист пуст");
                    }
                    break;
                case "take out all":
                    System.out.println(list);
                    break;
                case "clear":
                    System.out.println("вы уверены? (y/n): ");
                    String clear = scanner.nextLine();
                    if (clear.equals("y")){
                        list.clear();
                        id_text = -1;
                        comands.clear_list();
                    }else {
                        System.out.println("действие отменено");
                    }
                    break;
                default:
                    comands.error_not_command();
            }
        }
    }
}
