import java.util.*;

public class Main {

    public static void main(String[] args) {

       basicSet();
       unionIntersectionSet();
       removeElement();
       hashsetFromAnotherCollection();
       setOfBooks();
    }

    static void removeElement() {
        HashSet<String> set = new HashSet<>();
        set.add("Saigon");
        set.add("Hanoi");
        set.add("Danang");
        set.add("SocTrang");
        System.out.println("An initial list of elements: " + set);

        set.remove("Saigon");
        System.out.println("After invoking remove object: " + set);
        HashSet<String> set1 = new HashSet<>();
        set1.add("Halong");
        set1.add("VungTau");
        set.addAll(set1);
        System.out.println("Updated List: " + set);

        // removing all the elment from Hashset
        set.removeAll(set1);
        System.out.println("After removing all set1: " + set);

        // Removing elments base on conditions
        set.removeIf(str -> str.contains("Halong"));
        System.out.println("After removeIf method: " + set);
        // Removing all the elemnents in the set
        set.clear();
        System.out.println("After invoking clear method: " + set);
    }

    static void firstLastElement() {
        int count[] = {34, 22,10,60,30,22};
        Set<Integer> set = new HashSet<Integer>();

            for(int i = 0; i < 5; i++) {
                set.add(count[i]);
            }
            System.out.println(set);

            TreeSet sortedSet = new TreeSet<Integer>(set);
            System.out.println("The sorted list is:");
            System.out.println(sortedSet);

            System.out.println("The First element of the set is: "+ (Integer)sortedSet.first());
            System.out.println("The last element of the set is: "+ (Integer)sortedSet.last());

    }

    static void hashsetFromAnotherCollection() {
        List<String> list = Arrays.asList("Saigon", "Hanoi", "Danang");

        HashSet<String> set = new HashSet<>(list);
        set.add("Soctrang");
        Iterator<String> i = set.iterator();

        while(i.hasNext()) {
            System.out.println(i.next());
        }
    }

    static void basicSet() {
        Set<String> hash_set = new HashSet<>();
        hash_set.add("Geeks");
        hash_set.add("For");
        hash_set.add("Geeks");
        hash_set.add("Example");
        hash_set.add("Set");
        System.out.println("Set output without the duplicates");

        System.out.println(hash_set);

        // Treeset sorted set
        System.out.println("Sorted Set after passing into treeset");
        Set<String> tree_set = new TreeSet<>(hash_set);
        System.out.println(tree_set);
    }

    static void unionIntersectionSet() {

        Set<Integer> a = new HashSet<>();
        a.addAll(Arrays.asList(new Integer[]{1, 3, 2, 4, 8, 9, 0}));
        Set<Integer> b = new HashSet<>();
        b.addAll(Arrays.asList(new Integer[] {1, 3, 7, 5, 4, 0, 7, 5}));

        // Union
        Set<Integer> union = new HashSet<>(a);
        union.addAll(b);
        System.out.println("Union of the two Set");
        System.out.println(union);

        // Intersection
        Set<Integer> intersection = new HashSet<>(a);
        intersection.retainAll(b);
        System.out.println("Intersection of the two set");
        System.out.println(intersection);

        // Symmetric difference
        Set<Integer> difference = new HashSet<>(a);
        difference.removeAll(b);
        System.out.println("Difference of the two set");
        System.out.println(difference);
    }

    private static class Book {
        int id;
        String name,author,publisher;
        int quantity;
        public Book(int id, String name, String author, String publisher, int quantity) {
            this.id = id;
            this.name = name;
            this.author = author;
            this.publisher = publisher;
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", author='" + author + '\'' +
                    ", publisher='" + publisher + '\'' +
                    ", quantity=" + quantity +
                    '}';
        }
    }

    static void setOfBooks() {
        HashSet<Book> set = new HashSet<>();
        //Creating Books
        Book b1 = new Book(101, "Let us C", "Yashwant Kanetkar", "BPB", 8);
        Book b2 = new Book(102, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
        Book b3 = new Book(103, "Operating System", "Galvin", "Wiley", 6);
        //Adding Books to HashSet
        set.add(b1);
        set.add(b2);
        set.add(b3);
        //Traversing HashSet
        for (Book b : set) {
            System.out.println(b.id + " " + b.name + " " + b.author + " " + b.publisher + " " + b.quantity);
        }

        Book result = set.stream().findFirst().orElse(null);
        Book resutl2 = set.stream().filter(b -> b.id >=103).findFirst().orElse(null);
        System.out.println(result);
        System.out.println(resutl2);
    }
}
