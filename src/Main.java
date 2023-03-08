import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.println("Введите размер списка:");
        int listSize = scr.nextInt();
        System.out.println("Введите верхнюю границу для значений:");
        int maxValue = scr.nextInt();
        logger.log("Создаём и наполняем список");
        List<Integer> list = completeList(listSize, maxValue);
        System.out.println();
        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.println("Введите порог для фильтра:");
        int treshold = scr.nextInt();
        logger.log("Запускаем фильтрацию");
        Filter fil = new Filter(treshold);
        List<Integer> resultFilter = fil.filterOut(list);
        logger.log("Прошло фильтр " + resultFilter.size() + " элемента из " + list.size());
        logger.log("Выводим результат на экран");
        System.out.println("Отфильтрованный список: " + printList(resultFilter));
        logger.log("Завершаем программу");
    }

    public static List<Integer> completeList(int a, int b) {
        List<Integer> completeList = new ArrayList<>(a);
        Random random = new Random();
        for (int i = 0; i < a; i++) {
            completeList.add(i, random.nextInt(b));
        }
        System.out.print("Вот случайный список: " + printList(completeList));
        return completeList;
    }

    public static String printList(List<Integer> list) {
        StringBuilder s = new StringBuilder();
        for (int i : list) {
            s.append(i).append(" ");
        }
        return s.toString();
    }
}

