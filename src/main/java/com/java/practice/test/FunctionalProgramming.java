package com.java.practice.test;



import com.java.practice.model.InstanceJob;
import com.java.practice.model.People;
import com.java.practice.model.Person;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionalProgramming {
    public static void main(final String[] args) {

        final List<Integer> integerList = List.of(1, 3, 6, 2, 6, 3, 8, 1, 4, 9, 12, 67, 26, 92, 35, 67, 45, 7, 6);

        /**
         * Consumer - forEach
         */
        //integerList.forEach( System.out::println );
        //integerList.forEach( e -> print( e ) );
        //integerList.forEach( Test::print );
        //final Consumer<Integer> consumer = Test::print;
        //final Consumer<Integer> consumer = new Consumer<>() {
        //  @Override
        //  public void accept( final Integer integer ) {
        //    System.out.println( integer );
        //    //print( integer );
        //  }
        //};
        //final Consumer<Integer> consumer = x -> print( x );
        //final Consumer<Integer> consumer = Test::print;
        //final Consumer<Integer> consumer = integer -> {
        //  print( integer );
        //};
        //integerList.forEach( consumer );

        /**
         * BinaryOperator, BiFunction - reduce
         */
        //final Integer reduce = integerList.stream().reduce( 5, new BinaryOperator<Integer>() {
        //  @Override
        //  public Integer apply( final Integer integer, final Integer integer2 ) {
        //    return integer + integer2;
        //  }
        //} );
        //BinaryOperator<Integer> binaryOperator = ( integer, integer2 ) -> integer + integer2;
        //final BinaryOperator<Integer> binaryOperator = ( x, y ) -> x + y;
        //final BinaryOperator<Integer> binaryOperator = ( x, y ) -> x * y;

        //final BinaryOperator<Integer> binaryOperator = new BinaryOperator<Integer>() {
        //  @Override
        //  public Integer apply( final Integer integer, final Integer integer2 ) {
        //    return integer + integer2;
        //  }
        //};

        //final BinaryOperator<Integer> binaryOperator = ( integer, integer2 ) -> integer + integer2;
        //final BinaryOperator<Integer> binaryOperator = Integer::sum;

        //final Integer reduce = integerList.stream().reduce( 1, binaryOperator );
        //final Integer reduce = integerList.stream().reduce( 0, Integer::sum );

        //final Integer reduce = integerList.stream().reduce( 0, Test::add );
        //final Integer reduce = integerList.stream().reduce( 0, ( x, y ) -> x );
        //final Integer reduce = integerList.stream().reduce( 0, ( x, y ) -> y );
        //final Integer reduce = integerList.stream().reduce( 0, ( x, y ) -> x > y ? x : y );
        //final Integer reduce = integerList.stream().reduce( 0, ( x, y ) -> x > y ? x : y );
        //System.out.println( reduce );

        /**
         * Comparator - distinct, sorted
         */

        //final List<Integer> list = integerList.stream().distinct().toList();
        //final List<Integer> list = integerList.stream().sorted().toList();
        //System.out.println( list );

        final InstanceJob instanceJob = new InstanceJob();
        instanceJob.setJobId("1");
        instanceJob.setNumberOfCPUs(2);
        instanceJob.setInstanceId(UUID.randomUUID());

        final InstanceJob instanceJob2 = new InstanceJob();
        instanceJob2.setInstanceId(UUID.randomUUID());
        instanceJob2.setNumberOfCPUs(4);
        instanceJob2.setJobId("22");
        final List<InstanceJob> instanceJobList = List.of(instanceJob, instanceJob2);

        //final List<InstanceJob> instanceJobListSorted = instanceJobList.stream().sorted( new Comparator<InstanceJob>() {
        //  @Override
        //  public int compare( final InstanceJob job1, final InstanceJob job2 ) {
        //    return job1.getJobId().compareTo( job2.getJobId() );
        //  }
        //} ).toList();

        //final Comparator<InstanceJob> comparator = new Comparator<>() {
        //  @Override
        //  public int compare( final InstanceJob o1, final InstanceJob o2 ) {
        //    return o1.getJobId().compareTo( o2.getJobId() );
        //  }
        //};

        //final List<InstanceJob> instanceJobListSorted = instanceJobList.stream().sorted( comparator ).toList();

        //final List<InstanceJob> instanceJobListSorted = instanceJobList.stream()
        //    .sorted( ( job1, job2 ) -> job1.getJobId().compareTo( job2.getJobId() ) ).toList();

        //final List<InstanceJob> instanceJobListSorted = instanceJobList.stream()
        //    .sorted( Comparator.comparing( x -> x.getJobId() ) ).toList();

        //final List<InstanceJob> instanceJobListSorted = instanceJobList.stream()
        //    .sorted( Comparator.comparing( InstanceJob::getInstanceId ) ).toList();

        //final List<InstanceJob> instanceJobListSorted = instanceJobList.stream()
        //    .sorted( Comparator.comparing( InstanceJob::getInstanceId ) ).toList();

        //final List<InstanceJob> instanceJobListSorted = instanceJobList.stream()
        //    .sorted( Comparator.comparing( InstanceJob::getNumberOfCPUs ).reversed() ).toList();

        //final List<InstanceJob> instanceJobListSorted = instanceJobList.stream()
        //    .sorted( Comparator.comparingInt( job -> job.getJobId().length() ) ).collect( Collectors.toList() );
        //

        //final List<InstanceJob> instanceJobListSorted = instanceJobList.stream()
        //    .sorted( Comparator.comparing( instanceJob1 -> instanceJob1.getJobId().length() ) ).toList();
        //System.out.println( instanceJobListSorted );

        /**
         * Predicate, Function, Consumer, BinaryOperator, Supplier
         */

        final Predicate<Integer> integerPredicate = x -> x % 2 == 0;
        final Function<Integer, Integer> integerFunction = x -> x * 2;
        final Consumer<Integer> integerConsumer = System.out::println;
        final BinaryOperator<Integer> integerBinaryOperator = Integer::sum;

        final Function<Integer, Integer> integerFunction1 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(final Integer arg) {
                return arg * 2;
            }
        };
        final Function<Integer, Integer> integerFunction2 = x -> x * 2;

        final Predicate<Integer> integerPredicate1 = new Predicate<Integer>() {
            @Override
            public boolean test(final Integer arg) {
                return arg % 2 == 0;
            }
        };
        final Predicate<Integer> integerPredicate2 = x -> x % 2 == 0;
        final Predicate<Integer> integerPredicate3 = x -> x % 3 == 0;
        final Predicate<Integer> integerPredicate4 = x -> x > 10;

        final Consumer<Integer> integerConsumer1 = new Consumer<Integer>() {
            @Override
            public void accept(final Integer arg) {
                System.out.println(arg);
            }
        };
        final Consumer<Integer> integerConsumer2 = x -> System.out.println(x);
        final Consumer<Integer> integerConsumer3 = System.out::println;

        //integerList.stream().filter( integerPredicate2 ).map( integerFunction2 ).forEach( integerConsumer3 );
        final Integer reduce = integerList.stream().filter(integerPredicate).map(integerFunction)
                .reduce(0, integerBinaryOperator);
        //System.out.println( reduce );

        //we are passing the logic as argument
        passPredicatAsArgument(integerList, integerPredicate3);

        //final BinaryOperator<String> concatenate = ( s1, s2 ) -> s1 + s2;
        //final String result = concatenate.apply( "Hello, ", "World!" );
        //System.out.println( result );

        final Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                final Random random = new Random();
                return random.nextInt(100);
            }
        };
        final Supplier<Integer> supplier1 = () -> {
            final Random random = new Random();
            return random.nextInt(10);
        };
        //System.out.println( supplier1.get() );

        final UnaryOperator<Integer> unaryOperator = x -> x * x;
        //System.out.println( unaryOperator.apply( 10 ) );

        /**
         * BiCConsumer, BiFunction, BiPredicate
         */

        final BiFunction<Integer, Integer, Integer> biFunction = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(final Integer integer, final Integer integer2) {
                return null;
            }
        };

        final BiFunction<Integer, Integer, String> biFunction2 = (integer, integer2) -> String.format("result is : %s",
                integer + integer2);
        //System.out.println( biFunction2.apply( 10, 30 ) );

        final BiPredicate<Integer, Integer> biPredicate = (integer, integer2) -> integer > 10 && integer2 < 20;
        //System.out.println( biPredicate.test( 11, 21 ) );

        final BiConsumer<Integer, Integer> consumer = (integer, integer2) -> {
            System.out.println(integer);
            System.out.println(integer2);
        };
        //consumer.accept( 11, 22 );

        final ToIntFunction<Integer> toIntFunction = value -> 20;
        //System.out.println( toIntFunction.applyAsInt( 10 ) );

        final BinaryOperator<Integer> binaryOperator = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(final Integer integer, final Integer integer2) {
                return null;
            }
        };

        /**
         * Comparator
         */

        final Comparator<InstanceJob> comparator = (o1, o2) -> o1.getJobId().compareTo(o2.getJobId());
        //final Comparator<InstanceJob> comparator1 = Comparator.comparing( InstanceJob::getJobId ).reversed();

        final Comparator<InstanceJob> comparator1 = Comparator.comparing(instanceJob1 -> instanceJob1.getJobId().length(),
                Comparator.reverseOrder());
        final Comparator<InstanceJob> comparator2 = Comparator.comparing(
                instanceJob1 -> instanceJob1.getJobId().length());

        //final List<InstanceJob> instanceJobListSorted = instanceJobList.stream().sorted( comparator2 ).toList();
        //System.out.println( instanceJobListSorted );

        final List<People> people = Arrays.asList(new People("Alice", "Smith", "New York"),
                new People("Bob", "Jones", "London"), new People("Charlie", "Brown", "New York"),
                new People("David", "Williams", "London"), new People("Eve", "Johnson", "Paris"));

        // Grouping people by city and collecting first names into a set
        //final Map<String, Set<String>> namesByCity = people.stream().collect(
        //    Collectors.groupingBy( Person::getCity, Collectors.mapping( Person::getFirstName, Collectors.toSet() ) ) );

//        final Map<String, List<People>> r = people.stream().collect(Collectors.groupingBy(People::getCity));
        //
        //final Map<String, String> collect1 = people.stream()
        //    .collect( Collectors.toMap( Person::getCity, x -> x.getLastName() ) );
        //
        //final Map<String, Long> countByCity = people.stream()
        //    .collect( Collectors.groupingBy( Person::getCity, Collectors.counting() ) );

        //final Map<String, Person> collect2 = people.stream()
        //    .collect( Collectors.toMap( Person::getCity, person -> person ) );

        //System.out.println( collect2 );

        practiceQuestions();

    }

    private static void practiceQuestions() {
        final List<Person> personList = getAllPersons();
        /**
         * Question: Print the names of all people in the list.
         */

        final List<String> r1 = personList.stream()
                .map(Person::getName)
                .collect(Collectors.toList());

        /**
         * Question: Find and print the average age of all people.
         */

        OptionalDouble r2 = personList.stream()
                .mapToInt(Person::getAge)
                .average();

        /**
         * Question: Count and print the number of females in the list.
         */

        long r3 = personList.stream()
                .filter(person -> person.getGender().equals("Female"))
                .count();

        /**
         * Question: Print the names of people who are older than 30.
         */

        List<String> r4 = personList.stream()
                .filter(person -> person.getAge() > 30)
                .map(person -> person.getName())
                .collect(Collectors.toList());

        /**
         * Question: Check if there is any person with the occupation "Doctor."
         */

        boolean r5 = personList.stream()
                .anyMatch(person -> person.getOccupation().equals("Doctor"));

        /**
         * Question: Create a list of people sorted by age in ascending order.
         */

        List<Person> r6 = personList.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .collect(Collectors.toList());

        /**
         * Question: Group people by city and print the groups.
         */

        Map<String, List<Person>> r7 = personList.stream()
                .collect(Collectors.groupingBy(Person::getCity));

        /**
         * Question: Find the oldest person in the list.
         */

        Optional<Person> r8 = personList.stream()
                .max(Comparator.comparing(Person::getAge));

        /**
         * Question: Find and print the names of people in uppercase.
         */

        List<String> r9 = personList.stream()
                .map(Person::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        /**
         * Question: Count and print the number of people with a salary greater than 100,000.
         */

        long r10 = personList.stream()
                .filter(person -> person.getSalary() > 100000)
                .count();

        /**
         * Question: Find and print the names of people who are younger than 25.
         */

        List<String> r11 = personList.stream()
                .filter(person -> person.getAge() < 25)
                .map(Person::getName)
                .toList();

        /**
         * Question: Check if all people in the list are adults (age 18 and above).
         */

        boolean r12 = personList.stream()
                .allMatch(person -> person.getAge() >= 18);

        /**
         * Question: Create a list of people's names sorted alphabetically.
         */

        List<String> r13 = personList.stream()
                .map(Person::getName)
                .sorted()
                .collect(Collectors.toList());

        /**
         * Question: Calculate and print the total salary of all people in the list.
         */
        double r14 = personList.stream()
                .mapToDouble(Person::getSalary)
                .sum();

        /**
         * Question: Find and print the occupation of the person with the highest salary.
         */

        Optional<String> r15 = personList.stream()
                .max(Comparator.comparing(Person::getSalary))
                .map(Person::getOccupation);

        /**
         * Question: Check if there is any person with a salary less than 60000.
         */
        boolean r16 = personList.stream()
                .anyMatch(person -> person.getSalary() < 6000);

        /**
         * Question: Create a map where the key is the occupation, and the value is the average salary for that occupation.
         */

        Map<String, Double> r17 = personList.stream()
                .collect(Collectors.groupingBy(Person::getOccupation, Collectors.averagingDouble(Person::getSalary)));

        /**
         * count of persons of having same occupations
         */
        Map<String, Long> r18 = personList.stream()
                .collect(Collectors.groupingBy(Person::getOccupation, Collectors.counting()));

        /**
         * key - occupation
         * value - max salaried person
         */
        Map<String, Optional<Person>> r19 = personList.stream()
                .collect(Collectors.groupingBy(Person::getOccupation, Collectors.maxBy(Comparator.comparing(Person::getSalary))));

        /**
         * Question: Count and print the number of males in the list.
         */

        long r20 = personList.stream()
                .filter(person -> person.getGender().equals("Male"))
                .count();

        /**
         * Question: Find and print the names of people who live in cities starting with the letter "S."
         */
        List<String> r21 = personList.stream()
                .filter(person -> person.getCity().startsWith("S"))
                .map(person -> person.getName())
                .toList();

        /**
         * Question: Create a new list containing people with ages between 30 and 40 (inclusive).
         */
        List<Person> r22 = personList.stream()
                .filter(person -> person.getAge() >= 30 && person.getAge() <= 50)
                .toList();
        /**
         * Question: Create a list of people who are engineers.
         */

        List<Person> r23 = personList.stream().filter(person -> person.getOccupation().equals("Engineer")).toList();

        /**
         * Question: Create a map where the key is the gender, and the value is a list of people of that gender.
         */

        Map<String, List<Person>> r24 = personList.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        /**
         * Question: Calculate and print the average salary of people.
         */
        OptionalDouble r25 = personList.stream()
                .mapToDouble(Person::getSalary).average();

        /**
         * Question: Create a list of people who live in cities other than "New York."
         */
        List<Person> r26 = personList.stream()
                .filter(person -> !person.getCity().equals("New York")).toList();

        /**
         * Question: Check if all people have a salary greater than 50000.
         */
        boolean r27 = personList.stream()
                .allMatch(person -> person.getSalary() > 50000);

        /**
         * Question: Find and print the name of the youngest person.
         */
        Optional<Person> r28 = personList.stream().collect(Collectors.minBy(Comparator.comparing(person -> person.getAge())));
        Optional<Person> r29 = personList.stream()
                .min(Comparator.comparing(Person::getAge));

//        r = Optional.empty();
//        r.ifPresentOrElse(person -> System.out.println(person.getName()), () -> {
//            throw new RuntimeException("person is empty");
//        });
//        boolean r = personList.stream()
//                .anyMatch(person -> person.getCity() == null);

        /**
         * Question: Create a map where the key is the age, and the value is a list of people of that age.
         */
        Map<Integer, List<Person>> r30 = personList.stream()
                .collect(Collectors.groupingBy(Person::getAge));

        /**
         * Question: Find and print the names of people who have a salary less than or equal to 70000.
         */
        List<String> r31 = personList.stream()
                .filter(person -> person.getSalary() <= 7000)
                .map(Person::getName)
                .toList();
        /**
         * Question: Calculate and print the total number of people in the list.
         */
        long r32 = personList.stream().count();

        /**
         * Question: Create a map where the key is the city, and the value is the count of people in that city.
         */
        Map<String, Long> r33 = personList.stream()
                .collect(Collectors.groupingBy(Person::getCity, Collectors.counting()));

        /**
         * i want to print the city as key and name of the person who has less salary in the city
         */
        Map<String, Optional<Person>> r34 = personList.stream()
                .collect(Collectors.groupingBy(
                        Person::getCity,
                        Collectors.minBy(Comparator.comparingDouble(Person::getSalary))
                ));

        /**
         * Question: Create a Set containing all unique cities from the list of people.
         */

        Set<String> r35 = personList.stream()
                .map(Person::getCity)
                .collect(Collectors.toSet());

        /**
         * Question: Find the person with the highest salary and the person with the lowest salary.
         */

        Optional<Person> r36 = personList.stream().min(Comparator.comparingDouble(Person::getSalary));
        Map<String, Optional<Person>> r52 = personList.stream()
                .collect(Collectors.groupingBy(
                        Person::getName, Collectors.minBy(Comparator.comparingDouble(Person::getSalary))
                ));

        /**
         * Question: Group people by the first letter of their names.
         */

        Map<Character, List<Person>> r37 = personList.stream().collect(Collectors.groupingBy(person -> person.getName().charAt(0)));
        /**
         * Question: Check if there is any person with an age greater than 50.
         */

        boolean r38 = personList.stream().anyMatch(person -> person.getAge() > 50);
        /**
         * Question: Create a Map where the key is the occupation, and the value is the sum of the ages of people in that occupation.
         */

        Map<String, Double> r39 = personList.stream()
                .collect(Collectors.groupingBy(
                        Person::getOccupation, Collectors.summingDouble(Person::getAge)
                ));
        /**
         * Question: Sort the list of people by salary in descending order.
         */
        List<Person> r40 = personList.stream()
                .sorted(Comparator.comparingDouble(Person::getSalary).reversed()).toList();
        /**
         * Question: Create a Map where the key is the first letter of the occupation, and the value is a list of people with that first letter as the occupation.
         */

        Map<Character, List<Person>> r41 = personList.stream()
                .collect(Collectors.groupingBy(person -> person.getOccupation().charAt(0)));
        /**
         * Question: Check if there is any person with a null city.
         */

        boolean r42 = personList.stream().anyMatch(person -> person.getCity() == null);
        /**
         * Question: Create a Map where the key is the gender, and the value is a list of names of people of that gender.
         */

        Map<String, List<String>> r43 = personList.stream()
                .collect(Collectors.groupingBy(
                        Person::getGender, Collectors.mapping(
                                Person::getName, Collectors.toList()
                        )
                ));

        /**
         * Question: Create a Map where the key is the city, and the value is the list of people in that city sorted by age in descending order.
         */

        Map<String, List<Person>> r44 = personList.stream()
                .collect(Collectors.groupingBy(
                                Person::getCity,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        people -> people.stream().sorted(Comparator.comparingInt(Person::getAge).reversed()).toList()
                                )
                        )
                );

//         Question: Sort the list of people by the first letter of their cities, and for each city, sort the people by age.

        List<Person> r45 = personList.stream()
                .sorted(Comparator.comparing(person -> person.getCity().charAt(0)))
                .sorted(Comparator.comparingInt(Person::getAge))
                .collect(Collectors.toList());

        /**
         * Question: Calculate the average salary of male and female individuals separately.
         */
        Map<String, Double> r46 = personList.stream()
                .collect(Collectors.groupingBy(Person::getGender, Collectors.averagingDouble(Person::getSalary)));

        /**
         * Question: Calculate the total number of characters in all names in the list.
         */

        int r47 = personList.stream().mapToInt(person -> person.getName().length()).sum();

        /**
         *  Question: Create a list of people who live in cities other than "New York."
         **/

        List<Person> r48 = personList.stream().filter(person -> !person.getCity().equals("New York")).collect(Collectors.toList());

        /**
         * Question: Sort the list of people by name in alphabetical order.
         **/

        List<Person> r49 = personList.stream().sorted(Comparator.comparing(Person::getName)).collect(Collectors.toList());

        /**
         * Question: Create a map where the key is the age, and the value is a list of people of that age.
         **/

        Map<Integer, List<Person>> r50 = personList.stream().collect(Collectors.groupingBy(Person::getAge));
        /**
         *  Question: Sort the list of people by age in descending order.
         **/

        List<Person> r51 = personList.stream()
                .sorted(Comparator.comparingInt(Person::getAge).reversed())
                .collect(Collectors.toList());

        /**
         * Question: Create a list of unique occupations from the list of people.
         */
        List<String> r53 = personList.stream()
                .map(person -> person.getOccupation())
                .distinct().toList();

        /**
         *  Find the person with the second-highest salary.
         */
        Optional<Person> r54 = personList.stream()
                .sorted(Comparator.comparingDouble(Person::getSalary).reversed())
                .skip(1)
                .findFirst();

        /**
         * Question: Group people by occupation, and for each occupation, calculate the average age.
         */
        Map<String, Double> r55 = personList.stream()
                .collect(Collectors.groupingBy(Person::getOccupation, Collectors.averagingDouble(Person::getSalary)));
        /**
         * Question: Create a list of people with their names in uppercase.
         */
        List<String> r56 = personList.stream().map(person -> person.getName().toUpperCase()).toList();

        /**
         * Question: Find and print the name of the oldest person in each city.
         */
        Optional<String> r57 = personList.stream()
                .sorted(Comparator.comparingDouble(Person::getAge).reversed())
                .toList()
                .stream()
                .findFirst()
                .map(Person::getName);

        /**
         * Question: Create a list of people sorted by city and then by age in descending order.
         */
        List<Person> r58 = personList.stream()
                .sorted(Comparator.comparing(Person::getCity).thenComparingInt(Person::getAge).reversed())
                .toList();
        /**
         * Question: Calculate the total salary of people grouped by gender.
         */
        Map<String, Double> r59 = personList.stream()
                .collect(Collectors.groupingBy(
                        Person::getGender, Collectors.summingDouble(Person::getSalary))
                );
        /**
         * Question: Find and print the names of people who have a name length greater than the average name length.
         */
        double r60 = personList.stream()
                .mapToInt(person -> person.getName().length())
                .average()
                .orElse(0.0);

        List<String> r61 = personList.stream()
                .filter(person -> person.getName().length() > r60)
                .map(Person::getName)
                .toList();

        /**
         * Question: Partition people into two groups: those with even ages and those with odd ages.
         */

        Map<Boolean, List<Person>> r62 = personList.stream()
                .collect(Collectors.partitioningBy(person -> person.getAge() % 2 == 0));

        Map<Boolean, List<Person>> r63 = personList.stream()
                .collect(Collectors.partitioningBy(person -> person.getSalary() >= 100000));

        Map<Boolean, List<String>> r64 = personList.stream()
                .collect(Collectors.partitioningBy(
                        person -> person.getSalary() >= 100000, Collectors.mapping(
                                Person::getName, Collectors.toList()
                        )
                ));

        /**
         * Question: Create a list of people with their occupations in uppercase, sorted alphabetically.
         */
//        List<Person> r65 = personList.stream()
//                .map(person -> {
//                    person.setOccupation(person.getOccupation().toUpperCase());
//                    return person;
//                })
//                .sorted(Comparator.comparing(Person::getOccupation)).toList();

        /**
         * Group people by age range (e.g., 0-20, 21-40, 41-60, 61+).
         */
        Map<String, List<Person>> r66 = personList.stream()
                .collect(Collectors.groupingBy(person -> {
                    Integer age = person.getAge();
                    if (age <= 20) return "0-20";
                    else if (age <= 40) return "21-40";
                    else if (age <= 60) return "41-60";
                    else return "61+";
                }));

        Map<String, List<String>> r67 = personList.stream()
                .collect(Collectors.groupingBy(person -> {
                    Integer age = person.getAge();
                    if (age <= 20) return "0-20";
                    else if (age <= 40) return "21-40";
                    else if (age <= 60) return "41-60";
                    else return "61+";
                }, Collectors.mapping(Person::getName, Collectors.toList())));

        /**
         * Question: Calculate the total number of people for each gender.
         */
        Map<String, Long> r68 = personList.stream()
                .collect(Collectors.groupingBy(
                        Person::getGender, Collectors.counting()
                ));
        /**
         * Question: Find and print the name of the person with the longest name.
         */
        Optional<String> r69 = personList.stream()
                .max(Comparator.comparing(person -> person.getName().length()))
                .map(person -> person.getName());

        /**
         * Question: Find the average salary of people who live in cities starting with the letter "M."
         */
        OptionalDouble r70 = personList.stream()
                .filter(person -> person.getCity().startsWith("M"))
                .mapToDouble(Person::getSalary)
                .average();
        /**
         * Question: Find the person with the highest salary in each occupation.
         */
        Map<String, Optional<Person>> r71 = personList.stream()
                .collect(Collectors.groupingBy(
                        Person::getOccupation, Collectors.maxBy(Comparator.comparingDouble(Person::getSalary))
                ));
//        Question: Create a list of people with their ages squared.
        List<Integer> r72 = personList.stream()
                .map(person -> person.getAge() * person.getAge())
                .toList();

        /**
         * Question: Check if there is any person with an age greater than the average age.
         */
        Double r73 = personList.stream().mapToInt(Person::getAge).average().orElse(0.0);
        boolean r74 = personList.stream().anyMatch(person -> person.getSalary() > r73);

        /**
         * Question: Create a map where the key is the city, and the value is the list of people with salaries greater than 90000.
         */
        Map<String, List<Person>> r75 = personList.stream()
                .filter(person -> person.getSalary() > 90000)
                .collect(Collectors.groupingBy(Person::getCity));

        /**
         * Question: Find the person with the lowest salary in each city.
         */

        Map<String, Optional<Person>> r76 = personList.stream()
                .collect(Collectors.groupingBy(
                        Person::getCity, Collectors.minBy(Comparator.comparingDouble(Person::getSalary))
                ));
        /**
         * Question: Create a Map where the key is the city, and the value is the list of people in that city sorted by age in descending order.
         */

        Map<String, Stream<Person>> r77 = personList.stream()
                .collect(Collectors.groupingBy(
                        Person::getCity, Collectors.collectingAndThen(Collectors.toList(), people -> people.stream().sorted(Comparator.comparing(Person::getAge).reversed())))
                );

        /**
         * Question: Create a list of unique names by concatenating the name and city.
         */

        List<String> r78 = personList.stream()
                .map(person -> person.getName() + " " + person.getCity())
                .distinct()
                .toList();

        /**
         * Question: Find the sum of ages for people with a salary greater than 80000.
         */
        double r79 = personList.stream()
                .filter(person -> person.getSalary() > 80000)
                .mapToInt(Person::getAge)
                .sum();

        /**
         * Question: Create a map where the key is the age, and the value is the list of people with that age, sorted by name.
         */
        Map<Integer, List<Person>> r80 = personList.stream()
                .collect(Collectors.groupingBy(
                        Person::getAge, Collectors.collectingAndThen(
                                Collectors.toList(), people -> people.stream().sorted(Comparator.comparing(Person::getName)).toList()
                        )
                ));


        System.out.println(r80);

    }


    public static List<Person> getAllPersons() {
        return Arrays.asList(
                new Person("Alice", 25, "Female", "New York", "Engineer", 76000.0),
                new Person("Bob", 30, "Male", "Denver", "Scientist", 76000.0),
                new Person("Charlie", 34, "Male", "Cleveland", "Artist", 50000.0),
                new Person("Diana", 28, "Female", "San Francisco", "Doctor", 100000.0),
                new Person("Eva", 35, "Female", "Miami", "Programmer", 50000.0),
                new Person("Frank", 29, "Male", "Cleveland", "Architect", 120000.0),
                new Person("Grace", 32, "Female", "Houston", "Scientist", 110000.0),
                new Person("Harry", 42, "Male", "Denver", "Marketing", 130000.0),
                new Person("Ivy", 26, "Female", "Austin", "Engineer", 62000.0),
                new Person("Jack", 33, "Male", "Baltimore", "Artist", 100000.0),
                new Person("Kate", 29, "Female", "Atlanta", "Marketing", 98000.0),
                new Person("Leo", 29, "Male", "Baltimore", "Architect", 98000.0),
                new Person("Mia", 31, "Female", "Houston", "Designer", 70000.0),
                new Person("Nathan", 27, "Male", "Philadelphia", "Writer", 50000.0),
                new Person("Olivia", 34, "Female", "Denver", "Data Scientist", 105000.0),
                new Person("Peter", 42, "Male", "Houston", "Consultant", 110000.0),
                new Person("Quinn", 24, "Male", "Houston", "Software Engineer", 90000.0),
                new Person("Rachel", 29, "Female", "Detroit", "Professor", 80000.0),
                new Person("Sam", 42, "Male", "Las Vegas", "Chef", 70000.0),
                new Person("Tina", 28, "Female", "Raleigh", "Physician", 105000.0),
                // Add more people as needed
                new Person("Ulysses", 39, "Male", "Baltimore", "Consultant", 150000.0),
                new Person("Violet", 42, "Female", "Baltimore", "Biologist", 62000.0),
                new Person("Walter", 37, "Male", "Cleveland", "FChef", 62000.0),
                new Person("Xena", 30, "Female", "Baltimore", "Biologist", 98000.0),
                new Person("Yasmine", 29, "Female", "Orlando", "WChef", 76000.0),
                new Person("Zane", 29, "Male", "St. Minneapolis", "Product Manager", 115000.0),
                new Person("Zane malik", 28, "Male", "St. Minneapolis", "Product Manager", 115000.0)
                // Add more people as needed
        );
    }

    private static Integer getLength(final String getInstanceId) {
        return getInstanceId.length();
    }

    private static void passPredicatAsArgument(final List<Integer> integerList, final Predicate<Integer> predicate) {
        //integerList.stream().filter( predicate ).sorted( new Comparator<Integer>() {
        //  @Override
        //  public int compare( final Integer o1, final Integer o2 ) {
        //    return o2.compareTo( o1 );
        //  }
        //} ).forEach( System.out::println );
        //integerList.stream().filter( predicate ).sorted( ( x, y ) -> x.compareTo( y ) ).forEach( System.out::println );
        //integerList.stream().filter( predicate ).sorted( Integer::compareTo ).forEach( System.out::println );
        //integerList.stream().filter( predicate ).sorted( Comparator.comparing( Integer::intValue ).reversed() )
        //    .forEach( System.out::println );

    }

    private static void print(final Integer x) {
        System.out.println("printing : " + x);
    }

    private static Integer add(final Integer currentSum, final Integer currentNumber) {
        System.out.println(currentSum + " " + currentNumber);
        final int newSum = currentSum + currentNumber;
        return newSum;
    }

}
