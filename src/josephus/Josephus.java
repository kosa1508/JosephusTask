package josephus;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Josephus {
    // Добавляем мемоизацию для быстрого доступа к захешированному дереву ответов
    private static final Map<Integer, int[]> memo = new HashMap<>();
    public static int[] Josephus(int n) {

        // Проверяем наличие ответа для конкретного значения в дереве ответов
        if (memo.containsKey(n)) {
            System.out.println("Достаём результат из кеша для n=" + n);
            return memo.get(n).clone();
        }

        // Используем двунаправленную очередь для создания модели данной задачи
        // Создадим очередь
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
        }

        // Удалим каждый третий элемент, оставив ровно два
        while (deque.size() > 2) {
            deque.addLast(deque.removeFirst());
            deque.addLast(deque.removeFirst());
            deque.removeFirst(); // Удаляем третьего
        }

        // Достанем их из очереди
        int first = deque.getFirst();
        int second = deque.getLast();

        // Отфильтруем результаты по возрастанию
        int[] result = new int[]{Math.min(first, second), Math.max(first, second)};

        // Добавим полученный результат в дерево решений
        memo.put(n, result.clone());
        return result;

        // Таким образом, скорость работы функции:
        // В худшем случае(при первом нахождении решения для конкретного n) - O(n)
        // При каждом n, которое уже было посчитано - O(1)
        // Значит, жертвуя памятью(deque и memo использует ее в большом количестве),
        // получаем скорость программы O(1) в определенных случаях
    }
}