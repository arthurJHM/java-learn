package com.arthur.useful;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Useful {
    public static void main(String[] args) {


        System.out.println("================================ConcurrentHashMap==========================================");
        ConcurrentHashMap<Integer, String> conHashMap = new ConcurrentHashMap<>();



        System.out.println("================================关于foreach遍历中数组修改的问题==========================================");
        List<String> list1213 = new ArrayList<>(Arrays.asList("1", "2", "3"));
        for (String s : list1213) {
            if("2".equals(s)) { //如果是1就报错了
                list1213.remove(s);
            }
        }
        System.out.println(list1213);

        list1213 = new ArrayList<>(Arrays.asList("1", "2", "3"));
        Iterator<String> iterator = list1213.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if(item.equals("1")) {
                iterator.remove();
            }
        }

        System.out.println(list1213);

        System.out.println("================================ReverseListAndAsListAndtoArray==========================================");
        String [] s123= new String[]{
                "dog", "lazy", "a", "over", "jumps", "fox", "brown", "quick", "A"
        };
        List<String> list123 = Arrays.asList(s123);
        Collections.reverse(list123);
        s123=list123.toArray(new String[0]);//没有指定类型的话会报错
        System.out.println(s123[0]);
        System.out.println(list123);
        Integer [] myArray12 = { 1, 2, 3 };
        List myList12 = Arrays.stream(myArray12).collect(Collectors.toList());
//基本类型也可以实现转换（依赖boxed的装箱操作）
        int [] myArray123 = { 1, 2, 3 };
        List myList123 = Arrays.stream(myArray123).boxed().collect(Collectors.toList());
        System.out.println(myList12);
        System.out.println(myList123);


        System.out.println("================================Character==========================================");
        System.out.println(Character.isLetter('a'));
        System.out.println(Character.isDigit('3'));

        System.out.println("================================Integer==========================================");
        Integer min = Integer.MIN_VALUE;
        Integer max = Integer.MAX_VALUE;
        Integer strint__ = Integer.parseInt("12");
        System.out.println(strint__);
        System.out.println(Math.max(min, max));
        System.out.println(min.equals(max));

        int min_ = Integer.MIN_VALUE;
        int max_ = Integer.MAX_VALUE;


        System.out.println("=====================================数组===========================================");
        //    Type[] names = new Type[capacity]
        int[] a = new int[10];
        String[] s = new String[3];

//    Type[] names = new Type[]{Type ...a}
        int[] b = new int[]{1, 2, 3, 4};
        char[] c = new char[]{'a', 'b'};
        String[] s2 = new String[]{"hello", "world"};

        int[][] d = new int[10][5];
        System.out.println(d.length);
        System.out.println(d[0].length);

        System.out.println("=====================================数组排序===========================================");
//        Arrays.sort从小到大排序
//        Arrays.sort(int[] arr)
//        Arrays.sort(int[] arr, int fromIndex, int toIndex) 数组类型只要实现了Comparable接口就行(基本数据类型int也可以)
//        Arrays.sort(int[] arr, int fromIndex, int toIndex, 比较器); //一定是需要泛型
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5};
        Arrays.sort(arr, Comparator.comparingInt(a_ -> a_)); //必须是对象数组，Integer
        int[] arrint = new int[]{1, 2, 3, 4, 5};
        Arrays.sort(arrint);
        for(int arr_ : arr){
            System.out.print(arr_);
        }
        System.out.println(Arrays.toString(arrint));

        Arrays.sort(arr, 0, 4, ((o1, o2) -> o2 - o1));
        System.out.println(Arrays.toString(arr));

        String[] months = {"January","February","March","April","May","June","July","August","September","October","December"};
        //按字符串长度排序
        //1.
        Arrays.sort(months, (aa, bb) -> Integer.signum(aa.length() - bb.length()));
        //2.
        Arrays.sort(months, Comparator.comparingInt(String::length));
        //3.
        Arrays.sort(months, (aa, bb) -> aa.length() - bb.length());
        //4.
        Arrays.sort(months,
                (String aa, String bb) -> { return Integer.signum(aa.length() - bb.length()); }
        );
        System.out.println(Arrays.toString(months));


        System.out.println("=====================================数组填充fill===========================================");
        int[] a_2 = new int[5];
        Arrays.fill(a_2, 1);
        System.out.println(Arrays.toString(a_2));
        int[] arrs = new int[5];
        Arrays.fill(arrs, 1, 3, 8);
//         结果是：0 8 8 0 0
//    给第1位（0开始）到第3位（不包括）赋值8

        System.out.println("=====================================数组BinarySearch===========================================");
        int[] arr3 = {1, 2, 4};
        int[] arr4 = {1, 2, 4};
        System.out.println(arr3.equals(arr4));
        System.out.println(Arrays.equals(arr3, arr4));
        System.out.println(Arrays.binarySearch(arr3, 20));
        int[] arr5 = Arrays.copyOf(arr3, 3);
        int[] arr6 = Arrays.copyOfRange(arr3, 0, 5);
        System.out.println(arr5);


//        如果是arr1.equals(arr2),则返回false，因为equals比较的是两个对象的地址，不是里面的数，而Arrays.equals重写了equals，所以，这里能比较元素是否相等。

        System.out.println("=====================================数组copy clone===========================================");
        int[] a_3 = new int[]{12, 34, 44, 452, 234};
        int[] newA = Arrays.copyOf(a_3, 4);
        System.out.println("newA");
        System.out.println(Arrays.toString(newA));

        int[][] a_4 = {{1}, {2, 3}, {12, 134, 45}, {123, 234, 324}, {123, 1, 3, 4, 5}};
        int[][] a_5 = a_4.clone();
        System.out.println(Arrays.toString(a_5[4]));




        System.out.println("=====================================ArrayList===========================================");

        List<List<Integer>> listList = new ArrayList<List<Integer>>();

//        List<User> userList = Lists.newArrayList(new User("Jack", 11), new User("Jack", 10));
        List<User> userList1 = new ArrayList<>(Arrays.asList(new User("Jack", 11), new User("Jack", 10)));
//        通过nCopies方法创建拥有2个“orange”值的List，提供给list3进行初始化。
        List<String> list_1 = new ArrayList<>(Collections.nCopies(2, "pig"));


        System.out.println("=====================================ArrayList转为Interger[]===========================================");

        List<Integer> ls1 = new LinkedList<>(Arrays.asList(123, 23 ,547, 35 ,21));
        Integer[] ls2 = new Integer[ls1.size()];
        ls1.toArray(ls2);
        System.out.println(ls2.getClass());

        System.out.println("=====================================ArrayList  Sort===========================================");

        Collections.sort(userList1, (user1, user2) -> user1.getAge().compareTo(user2.getAge()));

        userList1.sort((user1, user2) -> user1.getAge().compareTo(user2.getAge()));

        //4. Java8,Lambda表达式，多条件排序
        userList1.sort((user1, user2) -> {
            if (user1.getName().equals(user2.getName())) {
                return user1.getAge().compareTo(user2.getAge());
            }
            else {
                return user1.getName().compareTo(user2.getName());
            }
        });

        userList1.sort(Comparator.comparing(User::getName).thenComparing(User::getAge));

        Collections.sort(userList1, Comparator.comparing(User::getName));

        //8. Java8,反转排序
        Comparator<User> comparator = (user1, user2) -> user1.getName().compareTo(user2.getName());
        userList1.sort(comparator.reversed());





//        List
//        instance方法（List接口方法）
//方法：get, size, add, remove, subList
        List<Integer> array = new ArrayList<>(); // 数组
        List<Integer> list = new LinkedList<>(); //链表
//        接受一个Stack、Set等容器为参数 - 以Set举例
        System.out.println("=====================================HashSet1===========================================");

        Set<Integer> seta = new HashSet<>();
        Set<Integer> setb = new HashSet<>(Arrays.asList(1, 3, 4));
        Set<Integer> setc = Stream.of(1, 3, 4, 21, 1).collect(Collectors.toSet()); //Java 8中会使用
//        在JDK 8中这确实返回a HashSet，但规范并不保证它，并且这可能在将来发生变化。如果您特别想要HashSet，请改为
        Set<Integer> setd = Stream.of(12, 34, 42, 123).collect(Collectors.toCollection(HashSet::new));

        setc.add(null);
        System.out.println("setc");
        System.out.println(setc);

        System.out.println("=====================================ArrayList2===========================================");

        List<Integer> lista = new ArrayList<>(setb);
        System.out.println(lista);

        System.out.println(lista.get(0));
        System.out.println(lista.size());
        lista.add(4); // 在尾部添加一个元素e --- O(1)
        lista.add(4,2);
        System.out.println(lista);
        lista.remove(1); //删除位于index的元素，并返回删除元素e
        lista.remove(lista.size() - 1);  //删除最后元素
        lista.subList(1, 3); // 相当于返回原数组的一个片段,但不要对其进行改动，改动会影响原数组 --- O(1)
        // List<Integer> list, 对原来的list和返回的list做的“非结构性修改”(non-structural changes)，
        //都会影响到彼此对方. 如果你在调用了sublist返回了子list之后，如果修改了原list的大小，那么之前产生的子list将会失效，变得不可使用
        lista.sort(((o1, o2) -> o1 - o2));
        Collections.sort(lista, (o1, o2) -> o1 - o2);
        System.out.println(lista);




        System.out.println("=====================================Stack===========================================");

//        Stack
//        instance方法
//方法：push, pop, peek, isEmpty, size
        Stack<Integer> stacka = new Stack<>();
        stacka.push(1);
        stacka.push(12);
        stacka.push(121);
        stacka.push(1241);
        stacka.push(1136);
        System.out.println(stacka);
        System.out.println(stacka.pop());
        System.out.println(stacka.peek());
        System.out.println(stacka.isEmpty());
        System.out.println(stacka.empty());
        System.out.println("============================STACK=====================================");
        System.out.println(stacka.size());
        System.out.println(stacka.search(12));
        System.out.println(stacka);






        System.out.println("=====================================QUEUE===========================================");

//        Queue
        Queue<Integer> q = new LinkedList<>();
//        instance方法 (Queue接口)
//方法：offer, poll, peek, isEmpty, size

//        把集合如Stack、Set、List等Collection作为参数
        Queue<Integer> qa = new LinkedList<>(stacka);
        Set<Integer> set_a = new HashSet<>(Arrays.asList(1, 4, 16, 57, 2));
        Queue<Integer> qb = new LinkedList<>(set_a);
        System.out.println(qa);
        System.out.println(qa.offer(2));// 队尾加入元素e。 若成功入队返回值true，否则返回false --- O(1)
        System.out.println(qa.poll());// 出队首，返回出队元素e --- O(1)
        System.out.println(qa.peek()); // 查看队首元素， 返回值队首元素e --- O(1)
        System.out.println(qa.isEmpty());
        System.out.println(qa.size());
        System.out.println(qa);






        System.out.println("=====================================PriorityQueue===========================================");

//        优先队列 PriorityQueue (Heap)
//          性质：底层是一颗数， 以小根堆为例。对于任意结点来说，该节点的值比其左右孩子的值都要小。 （就是最上面的结点最小）。 大根堆类似，最上面结点最大
        Queue<Integer> minH = new PriorityQueue<>();// 小根堆，默认大小为11 相当于  new PriorityQueue<>(11)
        Queue<Integer> minH2 = new PriorityQueue<>(100);  // 定义一个默认容量有100的小根堆。在当中增加元素会扩容，只是开始指定大小。不是size，是capacity

        Queue<Integer> maxH = new PriorityQueue<>((i1 , i2) -> i2 - i1); // 大根堆，默认大小为11 相当于  new PriorityQueue<>(11, (i1, i2) -> i2 - i1)
        Queue<Integer> maxH2 = new PriorityQueue<>(100, (i1, i2) -> i2 - i1);
//instance方法 (其实还是Queue接口方法)
//方法：offer, poll, peek, isEmpty, size
        minH.offer(123);
        minH.offer(1214);
        minH.offer(123223);
        System.out.println(minH);
        System.out.println(minH.offer(12312));  // 在堆中加入元素e，并调整堆。若成功入堆返回值true，否则返回false --- O(logN)
        System.out.println(minH.poll());  // 弹出堆顶元素，并重新调整堆，返回出队元素e --- O(logN)
        System.out.println(minH.peek()); // 查看堆顶元素， 返回值堆顶元素e --- O(1)
        System.out.println(minH.isEmpty());
        System.out.println(minH.size());
        System.out.println(minH);
        while (!minH.isEmpty()) {
            System.out.println(minH.poll());
        }





        System.out.println("=====================================HashSet2===========================================");

//        集合 Set - HashSet
//性质：Set中没有重复元素，重复添加的元素抛弃
        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>(Arrays.asList(12, 45, 57, 34));
//        把集合如Stack、Queue、List等Collection作为参数
        Set<Integer> set2 = new HashSet<>(lista);
//instance方法 (Set接口方法)
//方法：add, remove, contains, isEmpty, size
        System.out.println(set2);
        System.out.println(set2.add(13));
        System.out.println(set2.remove(12));
        System.out.println(set2.contains(13));
        System.out.println(set2.isEmpty());
        System.out.println(set2.size());
        System.out.println(set2);






        System.out.println("=====================================HashMap2===========================================");

//        这样的方式不被推荐，不要使用集合赋值方式来赋值，而是要使用静态代码块
        Map<Character, Character> map_1 = new HashMap<Character, Character>(){{
            put(')','(');
            put('}', '{');
        }};

//        这里在main中，所以以下代码不能用
//        private static Map<String, Integer> map = new HashMap<>();
//        static {
//            map.put("a", 1);
//            map.put("b", 2);
//        };
//
//        private static List<String> list = new ArrayList<>();
//        static {
//            list.add("a");
//            list.add("b");
//        };

//        散列表 HashMap
//性质：使用健值对的方式存储数据 <Key,Value>
//        instance方法 (Map接口方法)
//方法：put, get, getOrDefault, containsKey, containsValue, keySet, values, isEmpty, size
        Map<Character, Integer> map = new HashMap<>();
        System.out.println(map);
        System.out.println(map.put('2', 2));// 在Map中加入键值对<key, value>。如果没有key返回null值。如果Map中有key，返回旧的value,然后替换旧的value --- O(1)
        System.out.println(map.put('1', 1));
        System.out.println(map.put('1', 11));
        System.out.println(map.put(null, 1));
        System.out.println(map.get('1'));
        System.out.println(map.getOrDefault("3", 1222));
        map.put('3', map.getOrDefault('3', 0) + 1);
        System.out.println(map.containsKey('3'));
        System.out.println(map.containsValue(11));
        for(Character key : map.keySet())
            System.out.println(key);
        for(Integer value : map.values())
            System.out.println(value);
        System.out.println("==================================ENTRYSET=====================================");
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry);
        }
        System.out.println(map.isEmpty());
        map.clear();
        System.out.println(map.size());
        System.out.println(map);
        Map<Character, Integer> map1 = new HashMap<>();
        map.putAll(map1);
        System.out.println(map.equals(map1));
        System.out.println("=====+===============================================++++++++++++++++++");





        System.out.println("=====================================String===========================================");
//        String
//        instance方法
//方法: charAt, length, substring, equals, indexOf, lastIndexOf, replace, toCharArray, trim, split, toLowerCase, toUpperCase
        String s1 = "abc";
        char[] c2 = "asdada".toCharArray();
        char[] c1 = s1.toCharArray();
        String s22 = new String(c1);
        String s222 = new String("a21e1e");
        String sssss = new String("asdasdasd".toCharArray());
        // 可以偏移
// public String(char value[], int offset, int count)
        String sss4 = new String(c1, 1, 2);
        String sssss7 = String.valueOf(c2);
        System.out.println(sss4);
        System.out.println(s1.charAt(2));
        System.out.println(s1.length());
        System.out.println(s1.substring(0, 1));
        System.out.println(s1.substring(1));
        System.out.println(s1.indexOf("bc"));
        System.out.println(s1.indexOf("bc", 1)); //从fromIndex开始找
        System.out.println(s1.lastIndexOf("bc"));
        System.out.println(s1.lastIndexOf("bc", 2));//从fromIndex开始从后往前找 [0 <- fromIndex] --- O(m * n)
        System.out.println(s1.replace("a", "b"));
        System.out.println(s1.toCharArray());
        System.out.println(s1.trim()); // 返回去除前后空格的新字符串 --- O(n)
        for (String ss : " asdasd, dasd, asda , asd ".split("//s|,"))
            System.out.println(ss);// 返回 String[]，以regex(正则表达式)分隔好的字符换数组。 ---- O(n)
        System.out.println(s1.toLowerCase());
        System.out.println(s1.toUpperCase());






        System.out.println("=====================================StringBuilder===========================================");
//        StringBuilder
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder(10);
        StringBuilder sb2 = new StringBuilder("sadadadasdad");
//        instance方法
//方法: append, charAt, length, setCharAt, insert, deleteCharAt, delete, reverse, toString
        System.out.println(sb2.charAt(0));
        System.out.println(sb2.length());
        sb2.setCharAt(2, '2');
        sb2.insert(3, '1');
        sb2.deleteCharAt(5);
        sb2.deleteCharAt(sb2.length() - 1);
        sb2.delete(0, 2);
        sb2.reverse();  // 反转缓存字符串 --- O(n)
        System.out.println(sb2.toString());



        System.out.println("=====================================HashMapSort===========================================");

        Map<Character, Integer> map222 = new HashMap<>();
        map222.put('1', 1);
        map222.put('2', 1231);
        map222.put('3', 1123);
        map222.put('4', 1124);

        System.out.println(map222);

        ArrayList<Map.Entry<Character, Integer>> list222 = new ArrayList<>(map222.entrySet());
        Collections.sort(list222 , (o1, o2) -> {
            return o1.getValue().compareTo(o2.getValue());//升序，前边加负号变为降序
        });
//        Collections.sort(list222 , (o1, o2) -> {
//            return o1.getKey().compareTo(o2.getKey());//升序，前边加负号变为降序
//        });

        for(Map.Entry<Character, Integer> m : list222){
            System.out.println(m.getKey()+"="+m.getValue());
        }

        System.out.println("=====================================HashMapSort===========================================");


        System.out.println("=====================================Collections===========================================");
        System.out.println(lista);
        Collections.reverse(lista);
        System.out.println(lista);

    }
}
