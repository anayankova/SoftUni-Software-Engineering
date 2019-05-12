import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Libraries {
    public static void main(String[] args) {

        //TODO:Buttons

        //Ctrl + Alt + L  -> sort code in a regular line
        //Shift + Fn +F6 -> rename variable
        //Fn + F8 -> Debugger next line
        //Fn + F7 -> Inside the method
        //Ctrl + Click -> Open Libraries
        //Alt + Insert -> Open Generate and make methods

        //TODO:BicDecimal

        //BigDecimal bd = new BigDecimal("123.2265653");
        //BigDecimal bd2 = BigDecimal.ONE; //new BigDecimal("1")
        //BigDecimal bd3 = bd.add(bd);

        //BigDecimal number = new BigDecimal(0);
        //number = number.add(BigDecimal.valueOf(2.5));
        //System.out.println(number);
        //number = number.subtract(BigDecimal.valueOf(1.5));
        //System.out.println(number);
        //number = number.multiply(BigDecimal.valueOf(2));
        //System.out.println(number);
        //number = number.divide(BigDecimal.valueOf(2));
        //System.out.println(number);

        //TODO:Arrays

        //int[] numbers = new int[10];

        //String[] days = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };

        //int n = Integer.parseInt(sc.nextLine());
        //int[] arr = new int[n];
        //for (int i = 0; i < n; i++) {
            //arr[i] = Integer.parseInt(sc.nextLine());}

        //String values = sc.nextLine();
        //String[] items = values.split(" ");
        //int[] arr = new int[items.length];
        //for (int i = 0; i < items.length; i++)
            //arr[i] = Integer.parseInt(items[i]);}

        //String inputLine = sc.nextLine();
        //String[] items = inputLine.split(" ");
        //String[] input = scanner.nextLine().split(" ");
        //int[] arr = Arrays.stream(items).mapToInt(e -> Integer.parseInt(e)).toArray();

        //TODO: stream()
        //String[] data = Arrays.stream(scanner.nextLine().split("!+"))
        //                    .filter(e -> !e.equals(""))
        //                    .toArray(String[]::new);

        //TODO: int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        //TODO: String.join Print String Array
        //String[] strings = { "one", "two" };
        //System.out.println(String.join(" ", strings));
        //for (int i = 0; i < strings.length; i++)
        //            System.out.println(strings[i]);

        //TODO: Print Integer Array
        //for (int i = 0; i < n; i++) {
            //System.out.print(arr[i] + " ");}

        //TODO: Foreach
        //for (int number : numbers) {
            //System.out.print(number + " ");}

        //TODO: String[] strNumbers = scanner.nextLine().split(" ");

        //TODO: String.format
        //System.out.println(String.format("Best DNA sample %d with sum: %d.",
        //                bestSequenceIndexRowOutput,bestSequenceSum));

        //TODO: int num = command.equals("even") ? 0 : 1;

        //TODO: IndexOf -> return index or -1

        //TODO: Arrays.toString()  -> Print on the Console -> [a, b]
        //String[] input = scanner.nextLine().split("\\s+");
        //int[] numbers = new int[input.length];
        //for (int i = 0; i < input.length ; i++) {
            //numbers[i] = Integer.parseInt(input[i]);}
        //System.out.println(Arrays.toString(numbers));
        //System.out.println(Arrays.toString(input));

        //TODO: DecimalFormat
        //double number = Double.parseDouble(scanner.nextLine());
        //int power = Integer.parseInt(scanner.nextLine());
        //DecimalFormat format = new DecimalFormat("#.##########");
        //System.out.println(format.format(number));
        //System.out.println(format.format(power));

        //TODO: String.valueOf(n); .toString().replaceAll();  String.join();

        //TODO: compareTo
        //Integer x = 5;
        //System.out.println(x.compareTo(3));  return 1
        //System.out.println(x.compareTo(5));  return 0
        //System.out.println(x.compareTo(9));  return -1

        //TODO: toLowerCase(), toIgnoreCase()

        //TODO: Lists

        //TODO: Operations
       // List<String> names = new ArrayList<>();
        // List<Integer> nums = new ArrayList<>();
        //names.add(index: , element: "");
        //names.add(element: "");
        //nums.add(index, element);
        //nums.add(element);
        //names.remove(index);
        //names.remove(element: "");
        //nums.remove(index);
        //nums.remove(Integer.valueOf(element));
        //names.set(index, element);
        //names.contains(element);
        //Collections.sort(names);
        //Collections.reverse(names);
        //names.substring(start index, end index);
        //names.sublist(start index, end index);


        //List<Integer> nums = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50, 60));
        //for (int i = 0; i < nums.size(); i++)
            //System.out.print(nums.get(i) + " ");
        //nums.remove(Integer.valueOf(10));
        //nums.add(index: 0, element: -5);
        //for (int i = 0; i < numbers.size() / 2; i++)
        //numbers.set(i, numbers.get(i) + numbers.get(numbers.size() - 1));

        //TODO: Reading And Print Integer

        //int n = Integer.parseInt(sc.nextLine());
        //List<Integer> list = new ArrayList<>();
        //for (int i = 0; i < n; i++) {
            //int number = Integer.parseInt(sc.nextLine());
            //list.add(number);}
        //for (Integer aList : list) {
            //System.out.println(aList);} -> Print values on new line

        //TODO: Reading String
        //List<String> elements = Arrays.stream(scanner.nextLine().split(" "))
                //.collect(Collectors.toList());

        //TODO: Reading Integer
        //List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
               // .map(Integer::parseInt).collect(Collectors.toList());

        //TODO: Different Printing
        //String values = scanner.nextLine();
        //List<String> items = Arrays.stream(values.split(" "))
                //.collect(Collectors.toList());
        //List<Integer> nums = new ArrayList<>();
        //for (int i = 0; i < items.size(); i++) {
            //nums.add(Integer.parseInt(items.get(i)));
            //System.out.println(nums);  -> Like Arrays with [] in for cycle
            //System.out.println(nums.get(i));}   -> Just value in for cycle
        //System.out.println(nums);  -> Like Arrays with []
        //for (Integer aNums : nums) {
            //System.out.print(aNums + " ");} -> Just values with delimiter " "
        //System.out.println(String.join(" ", items)); -> Just Strings with delimiter " "

        //TODO: Printing with toString().replaceAll()
        //System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));

        //TODO: Printing with stream()
        //System.out.println(elements.stream()
               // .mapToInt(Integer::parseInt).sum());

        //TODO: stream() and filter()
        //elements = elements.stream().filter(e -> !e.equals(""))
        //.collect(Collectors.toList());

        //String concatElements =  elements.subList(startIndex,endIndex)
        //.stream().filter(e -> !e.equals(""))
        //.collect(Collectors.joining(""));

        //String concatElements = elements.subList(startIndex,endIndex).stream()
        //.collect(Collectors.joining(""));

        //System.out.println(Arrays.stream(new BufferedReader(
                //new InputStreamReader(System.in)).readLine().split("\\|+"))
                //.filter(e1 -> !e1.matches("\\s+"))
                //.map(e -> Arrays.stream(e.split("\\s+"))
                        //.filter(e1 -> !e1.equals(""))
                       // .collect(Collectors.toList()))
                //.collect(Collectors.collectingAndThen(Collectors.toList(),
                        //strings -> {Collections.reverse(strings);
                            //return strings;}))
                //.toString().replaceAll("[\\[\\],]", ""));

        //elements = elements.stream().filter(e -> !e.equals(data[1])).collect(Collectors.toList());

        //TODO: Classes and Objects

        //Constructor
        //public Dice() {
            //System.out.println("My constructor");
            //this.sides = 4;
            //this.type = "A";
        //}

        //MyIntList list = new MyIntList(); in Main -> instance of

        //public void doSomething() {System.out.println("Do something");} -> Main main = new Main();
        //        // main.doSomething(); -> with creating instance

        //public static void doSomething2() {System.out.println("static");} -> Main.doSomething2();
        // -> without instance

        //TODO: Sorted() Compare()
        //.sorted.((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()))  -> Integer
        // p1.compareTo(p2), p2.compareTo(p1)   -> String
        //.sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))  -> String

        //people =     -> reference
        // people.stream().filter(person -> person.getAge() > 30)  -> check for person > 30
                //.sorted((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()))  -> sort
                //.collect(Collectors.toList());  -> save as collections

        //TODO:  stream()
        //String finalModel = model;
        //vehicles.stream()
                //.filter(v -> v.getModel().equals(finalModel))
                //.forEach(System.out::println);

        //this.getType().toUpperCase().charAt(0) +
                //this.getType().substring(1)   -> cars   -> Cars

        //TODO: var
        //var var = new ArrayList<>();  -> var get if it is int or String

        //TODO: Map

        // HashMap not sorted
        // TreeMap sorted by key
        // LinkedHashMap sorted in order of addition

        // Before .get() -> if(e.contains(Key){}
        //Map<String, Integer>   Map.get(String) -> return Value Integer
        //Map<String, Map<String, List<String>>> -> Map.get(String).get(String) -> return List<String>
        // => Map.get(String).get(String).add(element)
        //Map<String, Map<String, List<Class>>> -> Class Student
        // -> Map.get(String).get(String).foreach(el -> el.getName())

        //TODO: Map Operation

        //Overwrite the value:
        //counts.put(num, 0);
        //  counts.put(num, counts.get(num) + 1);
        //words.putIfAbsent(word, new ArrayList<>());
        //  words.get(word).add(synonym);
        //for (var entry : fruits.entrySet())

        //TODO: Lambda Expression

        //(a -> a > 5)
        //x -> x / 2
        //static int func(int x) { return x / 2; }
        //x -> x != 0
        //static boolean func(int x) { return x != 0; }
        //() -> 42
        //static int func() { return 42; }

        //TODO: Stream API

        //int min = Arrays.stream(new int[]{15, 25, 35}).min().getAsInt();
        //int min = Arrays.stream(new int[]{15, 25, 35}).min().orElse(2);
        //int min = Arrays.stream(new int[]{}).min().orElse(2); // 2
        //int sum = Arrays.stream(new int[]{15, 25, 35}).sum();
        //double avg = Arrays.stream(new int[]{15, 25, 35}).average().getAsDouble();
        //int min = nums.stream().mapToInt(Integer::intValue).min().getAsInt();
        //int min = nums.stream().min(Integer::compareTo).get();
        //int sum = nums.stream().mapToInt(Integer::intValue).sum();
        //int[] nums = Arrays.stream(sc.nextLine().split(" "))
        //          .mapToInt(e -> Integer.parseInt(e))
        //          .toArray();
        //String[] words = {"abc", "def", "geh", "yyy"};
        //words = Arrays.stream(words)
        //              .map(w -> w + "yyy")
        //              .toArray(String[]::new);
        //List<Integer> nums = Arrays.stream(sc.nextLine().split(" "))
        //                        .map(e -> Integer.parseInt(e))
        //                        .collect(Collectors.toList());
        //int[] nums = Arrays.stream(sc.nextLine().split(" "))
        //                 .mapToInt(e -> Integer.parseInt(e))
        //                 .filter(n -> n > 0)
        //                 .toArray();
        //nums = nums.stream()
        //           .sorted((n1, n2) -> n1.compareTo(n2))
        //           .collect(Collectors.toList());
        //Map<Integer, String> products = new HashMap<>();
        //products.entrySet()
        //     .stream()
        //     .sorted((e1, e2) -> {
        //        int res = e2.getValue().compareTo(e1.getValue());
        //        if (res == 0)
        //          res = e1.getKey().compareTo(e2.getKey());
        //        return res; })
        //     .forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));
        //Map<String, ArrayList<Integer>> arr = new HashMap<>();
        //arr.entrySet().stream()
        //   .sorted((a, b) -> {
        //     if (a.getKey().compareTo(b.getKey()) == 0) {
        //       int sumFirst = a.getValue().stream().mapToInt(x -> x).sum();
        //       int sumSecond = b.getValue().stream().mapToInt(x -> x).sum();
        //       return sumFirst - sumSecond;
        //     }
        //     return b.getKey().compareTo(a.getKey());
        //   })
        //   .forEach(pair -> {
        //       System.out.println("Key: " + pair.getKey());
        //       System.out.print("Value: ");
        //       pair.getValue().sort((a, b) -> a.compareTo(b));
        //       for (int num : pair.getValue()) {
        //         System.out.printf("%d ", num);
        //       }
        //       System.out.println();
        //     });

        //  todo: entrySet()

        //.entrySet().foreach(e -> ...)  foreach((key, value) -> ...))

        //list.map(e -> e+=5)   -> change elements in list

        //TODO: StringBuilder

        //append(…) – appends the string representation of the argument
        //length(…) – holds the length of the string in the buffer
        //setLength(0) – removes all characters
        //char At(int index) – return char on current index
        //insert(int index, String str) – inserts a stringat the specified character position
        //replace(int startIndex, int endIndex, String str)
        //replaces the characters in a substring
        //toString() - converts the value of this instance to a String


        //TODO: REGEX

        //[0-9]+ matches non-empty sequence of digits
        //[A-Z][a-z]* matches a capital + small letters

        //[nvj] matches any character that is either n, v or j
        //[^abc] – matches any character that is not a, b or c
        //[0-9] – character range: matches any digit from 0 to 9

        //\w – matches any word character (a-z, A-Z, 0-9, _)
        //\W – matches any non-word character (the opposite of \w)
        //\s – matches any white-space character
        //\S – matches any non-white-space  character (opposite of \s)
        //\d – matches any decimal digit (0-9)
        //\D – matches any non-decimal character (the opposite of \d)

        //TODO: Quantifiers

        //  + -> min 1
        //  * -> 0 or 1
        //  ? -> may have 1, may not
        //  {3} -> 3 elements
        //  {3,4} -> min 3, max 4
        //  {3,}  -> min3, max infinity

        //* – matches the previous element zero or more times
        //    \+\d*    ->    [+359885976002] a[+]b    -> 2 matches
        //    \+\d+    ->    [+359885976002] a+b      -> 1 match
        //    \+\d?    ->    [+3]59885976002 a[+]b    -> 2 matches
        //    \+\d{3}  ->    [+359]885976002 a+b      -> 1 match

        //(subexpression) – captures the matched subexpression as numbered group
        //   \d{2}-(\w{3})-\d{4}  ->   22-Jan-2015
        //(?:subexpression) – defines a non-capturing group
        //    ^(?:Hi|hello),\s*(\w+)$  -> Hi, Peter
        //(?<name>subexpression) – defines a named capturing group
        //  (?<day>\d{2})-(?<month>\w{3})-(?<year>\d{4})  ->   22-Jan-2015

        //TODO:  example

        // (?<name>[a-zA-Z]+ [a-zA-Z]+)@(?<city>[a-zA-Z]+)@(?<age>\d{0,2})
        //  ->  Ivan Ivanov@Sliven@30

        //todo: email
        // ^[a-zA-Z0-9]+@[a-z]+.[a-z]+$   -> ^....$ -> all subexpression  -> ^ -> start  $ -> end

        //todo: point
        // . -> match all symbols

        // *?  <lazy> quantifier

        //TODO:  Lookahead

        //positive
        // Find expression A where expression B follows
        // A(?=B)   -> A, AB  -> match only A in expression AB
        //[a-z]+(?=\d+)
        //negative
        // Find expression A where expression B does not follow
        // A(?!B)   -> A, AB  -> match only A in expression A
        //[a-z]+(?!\d+)

        //TODO: Lookbehind

        //positive
        //Find expression A where expression B precedes
        //(?<=B)A
        //(?<=\d)[a-z]+
        //negative
        //Find expression A where expression B does not precede
        //(?<!B)A
        //(?<!\d)[a-z]+

        //TODO: BACK REFERENCES

        //\number – matches the value of a numbered capture group
        //  <(h1)>\w+<\/\1>  -> <h1>Hello</h1>  (h1) -> first group -> \1  -> repeat first group h1
        //  <(h1|div|span)>\w+<\/\1>  -> <h1>Hello</h1>,<div>Hello</div>,<span>Hello</span>

        //<(\w+)[^>]*>.*?<\/\1>

        //<b>Regular Expressions</b> are cool!
        //<p>I am a paragraph</p> … some text after
        //Hello, <div>I am a<code>DIV</code></div>!
        //<span>Hello, I am Span</span>
        //<a href="https://softuni.bg/">SoftUni</a>

        //TODO: Regex in Java library

        //Pattern pattern = Pattern.compile("a*b");
        //Matcher matcher = pattern.matcher("aaaab");

        //boolean match = matcher.find();
        //String matchText = matcher.group();

        // . -> match all symbols
        // \. -> match only points
        // [.] -> put into class and also match only points

        // (^| ) -> start or space   -> \s
        // (?:\\.[A-Z....)  -> non capturing group


    }
}
