public class Libraries {
    public static void main(String[] args) {

        //TODO: Stacks /Last In First Out (LIFO)/ and Queue /First In First Out (FIFO)/

        //todo: Stacks

        //Creating a Stack
        //ArrayDeque<Integer> stack = new ArrayDeque<>();
        //Adding elements at the top of the stack
        //stack.push(element);
        //Removing elements
        //Integer element = stack.pop();
        //Getting the value of the topmost element
        //Integer element = stack.peek();
        //Utility Methods:
        //int size = stack.size();
        //boolean isEmpty = stack.isEmpty();
        //boolean exists = stack.contains(2);

        //todo: Queue

        //Creating a Queue
        //ArrayDeque<Integer> queue = new ArrayDeque<>();
        //Adding elements at the end of the queue
        //queue.add(element);
        //queue.offer(element);
        //add() – throws exception if queue is full
        //offer() – returns false if queue is full
        //Removing elements
        //element = queue.remove();
        //element = queue.poll();
        //remove() - throws exception if queue is empty
        //poll() - returns null if queue is empty
        //Check first element
        //element = queue.peek();
        //Utility Methods:
        //Integer element = queue.peek();    peek() - checks the value of the first element
        //Integer size = queue.size();     size() - returns queue size
        //Integer[] arr = queue.toArray();    toArray() - converts the queue to an array
        //boolean exists = queue.contains(element);    contains() - checks if element is in the queue

        //TODO: Functional Programming

        //todo: Lambda Expressions
        //(parameters) -> {body}
        //Implicit lambda expression
        //(msg) -> { System.out.println(msg); }
        //Explicit lambda expression
        //String msg -> System.out.println(msg);

        //Integer::compareTo
        // public static int compare(int x, int y) { return (x < y) ? -1 : ((x == y) ? 0 : 1); }

        //todo: Function<T, R>
        //In Java Function<T,R> is an interface that accepts a parameter of type T
        // and returns variable of type R
        //int increment(int number) {
        //    return number + 1;
        //}
        //We use function with .apply()
        //Function<Integer, Integer> increment = number -> number + 1;
        //int a = increment.apply(5);
        //int b = increment.apply(a);

        //todo: Consumer<T>
        //In Java Consumer<T> is a void interface:
        //void print(String message) {
        //   System.out.println(message);
        //}
        //We use a Consumer with .accept():
        //Consumer<String> print = message -> System.out.print(message);
        //print.accept("Peter");

        //todo: Supplier<T>
        //In Java Supplier<T> takes no parameters:
        //int genRandomInt() {
        //  Random rnd = new Random();
        //  return rnd.nextInt(51);
        //}
        //We use a Supplier with .get():
        //Supplier<Integer> genRandomInt = () -> new Random().nextInt(51);
        //int rnd = genRandomInt.get();

        //todo: Predicate<T>
        //In Java Predicate<T> evaluates a condition:
        //boolean isEven(int number) {
        //    return number % 2 == 0;
        //}
        //We use the Predicate with .test():
        //Predicate<Integer> isEven = number -> number % 2 == 0;
        //System.out.println(isEven.test(6)); // true

        //todo: BiFunction <T, U, R>
        //BiFunction <Integer, Integer, String> sum = (x, y) -> "Sum is" + (x + y);
        //Analogically you can use:
        //BiConsumer <T, U>
        //BiPredicate <T, U>

        //todo: Passing Functions to Method
        //static int operation(int number, Function<Integer, Integer> function) {
        //    return function.apply(number);
        //}
        //int a = 5;
        //int b = operation(a, number -> number * 5);  // b = 25
        //int c = operation(a, number -> number - 3);  // c = 2
        //int d = operation(b, number -> number % 2);  // d = 1


    }
}
