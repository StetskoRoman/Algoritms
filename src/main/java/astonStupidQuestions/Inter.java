package astonStupidQuestions;

@FunctionalInterface
public interface Inter<T, E> {
//чет конвертировать
    T convert(T t, E e);

//    статических скок угодно
     static <T> boolean isNotNull(T t){
        return t != null;
    }

//    Default методов тоже скок угодно может быть, и их можно переопределять если надо
    default void writeToConsole(T t) {
        System.out.println("Текущий объект - " + t.toString());
    }

}
