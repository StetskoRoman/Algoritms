package YandexAlgoritms5.lecture2LineanSearch;
/**
 * Крутится барабан влево вправо
 * Развлекательный телеканал транслирует шоу «Колесо Фортуны». В процессе игры участники шоу крутят большое колесо, разделенное на сектора. В каждом секторе этого колеса записано число. После того как колесо останавливается, специальная стрелка указывает на один из секторов. Число в этом секторе определяет выигрыш игрока.
 *
 * Юный участник шоу заметил, что колесо в процессе вращения замедляется из-за того, что стрелка задевает за выступы на колесе, находящиеся между секторами. Если колесо вращается с угловой скоростью v градусов в секунду, и стрелка, переходя из сектора X к следующему сектору, задевает за очередной выступ, то текущая угловая скорость движения колеса уменьшается на k градусов в секунду. При этом если v ≤ k, то колесо не может преодолеть препятствие и останавливается. Стрелка в этом случае будет указывать на сектор X.
 * Юный участник шоу собирается вращать колесо. Зная порядок секторов на колесе, он хочет заставить колесо вращаться с такой начальной скоростью, чтобы после остановки колеса стрелка указала на как можно большее число. Колесо можно вращать в любом направлении и придавать ему начальную угловую скорость от a до b градусов в секунду.
 *
 * Требуется написать программу, которая по заданному расположению чисел в секторах, минимальной и максимальной начальной угловой скорости вращения колеса и величине замедления колеса при переходе через границу секторов вычисляет максимальный выигрыш.
 * 5
 * 1 2 3 4 5
 * 3 5 2
 */

import java.util.*;

public class Task6Ruletka {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.close();

//        System.out.println(a +" "+ b + " " + k + "   " + Arrays.toString(array));
        int res = solution(array, a, b, k);
        System.out.println(res);
    }

    static int solution(int[] array, int a, int b, int k) {

        int n = array.length;
        int[] reversArray = new int[array.length];
        reversArray[0] = array[0];
        int count = 1;
        for (int i = array.length - 1; i >= 1; i--) {
            reversArray[count] = array[i];
            count++;
        }
//        System.out.println(Arrays.toString(reversArray));

        Set<Integer> dp = new LinkedHashSet<>();
        for (int i = a; i <= b; i++) {
//           очень надо, чтоб не накручивать лишние
            if (dp.size() > n) {
                break;
            }
            if (i % k == 0) {
                dp.add(i / k - 1);
            }
            if (i % k > 0) {
                dp.add(i / k);
// -1 надо чтоб учитывать ровно, в конце же i++ будет
                i += k - 1;
            }
        }

        int max = 0;
        for (Integer roll : dp) {
            if (array[(roll%n)] > max) {
                max = array[(roll%n)];
            }
            if (reversArray[(roll%n)] > max) {
                max = reversArray[(roll%n)];
            }
        }
//        System.out.println("dp = " + dp);
        return max;
    }
}
