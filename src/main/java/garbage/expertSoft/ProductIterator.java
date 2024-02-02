package garbage.expertSoft;

import java.util.*;

public class ProductIterator {

    String title;
    int size;

    public ProductIterator(String title, int size) {
        this.title = title;
        this.size = size;
    }

    @Override
    public String toString() {
        return "ProductIterator{" +
                "title='" + title + '\'' +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {

        Set products = new HashSet();
        products.add(1);     // из-за того что можно тип добавить, так делать нельзя, но раньше было в порядке вещей
        products.add(new ProductIterator("Hat", 3));
        products.add(new ProductIterator("Hat", 3));


        System.out.println("products = " + products);

//        ListIterator productIterator = (ListIterator) products.iterator();
//
//        while (productIterator.hasNext()) {
//            if (productIterator.next() instanceof Integer) {
//               productIterator.remove();
//            }
//            System.out.println(productIterator.next());
//        }
//
//        System.out.println(products + "    " + productIterator);

        List<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(12);
        list.add(20);

        ListIterator iterator = list.listIterator();
        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
            Integer number = (Integer) iterator.next();
            iterator.set(number + 15);
        }
        System.out.println(list + "    " + iterator.toString()) ;
    }
}
