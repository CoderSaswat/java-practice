package com.java.practice.test;

import com.github.javafaker.Faker;
import com.java.practice.model.Person;
import com.mongodb.internal.CheckedSupplier;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SynchronousSink;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class ReactiveProgramming {

    public static void main(String[] args) throws Exception {
//        Mono<Integer> mono = Mono.just("virat")
//                .map(String::length)
//                .map(integer -> integer / 0);

        //should be in one stream not different line
//        mono.map(String::length)
//                .map(i -> i / 0);

//        mono.subscribe(System.out::println);

//        mono.subscribe(
//                System.out::println,
//                throwable -> System.out.println(throwable.getMessage()),
//                () -> System.out.println("completed")
//        );

//        getUserDetails(3)
//                .subscribe(System.out::println,
//                        throwable -> System.out.println(throwable.getMessage()),
//                        () -> System.out.println("completed"));

//        getUserDetails(1);

//        Mono<String> mono2 = Mono.just(getName());

//        Supplier<String> stringSupplier = () -> getName();
//        Mono<String> mono1 = Mono.fromSupplier(stringSupplier);
//        mono1.subscribe(System.out::println);
//        Callable<String> stringCallable = () -> getName();
//        Mono<String> mono2 = Mono.fromCallable(stringCallable);
//        mono2.subscribe(System.out::println);

//        getNameAfterWaiting();
//        getNameAfterWaiting();
//        String block = getNameAfterWaiting()
//                .subscribeOn(Schedulers.boundedElastic())
//                .subscribe(System.out::println);
//                .block();
//        getNameAfterWaiting();
//        System.out.println(block);


//        CompletableFuture<String> nameAsync = getNameAsync();
//        Mono.fromFuture(nameAsync).subscribe(System.out::println);
//        Thread.sleep(1000);


//        Flux<Integer> flux = Flux.just(1, 2, 3, 4);

//        flux.log().subscribe(System.out::println);

//        List<Integer> integerList = List.of(1, 2, 3, 4, 5);
//        Stream<Integer> integerStream = integerList.stream();
//
//        Flux<Integer> integerFlux = Flux.fromStream(() -> integerList.stream());
//        integerFlux.subscribe(System.out::println);
//        integerFlux.subscribe(System.out::println);

//        AtomicReference<Subscription> atomicReference = new AtomicReference<>();
//
//        flux.subscribeWith(new Subscriber<Integer>() {
//            @Override
//            public void onSubscribe(Subscription subscription) {
//                atomicReference.set(subscription);
//            }
//
//            @Override
//            public void onNext(Integer integer) {
//                System.out.println("received " + integer);
//            }
//
//            @Override
//            public void onError(Throwable throwable) {
//                System.out.println("error :" + throwable.getMessage());
//            }
//
//            @Override
//            public void onComplete() {
//                System.out.println("completed");
//            }
//        });
//
//        Thread.sleep(2000);
//        atomicReference.get().request(2);


//        AtomicInteger atomicInteger = new AtomicInteger(100);
//
//        Flux<Integer> flux1 = Flux.interval(Duration.ofSeconds(1))
//                .map(p -> atomicInteger.getAndAccumulate(
//                        getRandomNo(), (left, right) -> left + right)
//                );
//
//        CountDownLatch countDownLatch = new CountDownLatch(1);
//        flux1.subscribeWith(new Subscriber<Integer>() {
//            private Subscription subscription;
//
//
//            @Override
//            public void onSubscribe(Subscription subscription) {
//                this.subscription = subscription;
//                subscription.request(Long.MAX_VALUE);
//            }
//
//            @Override
//            public void onNext(Integer integer) {
//                System.out.println("onNext " + integer);
//                if (integer < 90 || integer > 110) {
//                    subscription.cancel();
//                    countDownLatch.countDown();
//                }
//
//            }
//
//            @Override
//            public void onError(Throwable throwable) {
//                countDownLatch.countDown();
//            }
//
//            @Override
//            public void onComplete() {
//                System.out.println("completed");
//                countDownLatch.countDown();
//            }
//        });

//        sleep(10000);
//        countDownLatch.await();

//        Flux.create(fluxSink -> {
//            sleep(5000);
//            System.out.println("generating random country");
//            String country = "";
//            do {
//                country = Faker.instance().country().name();
//                fluxSink.next(country);
//            } while (!country.equalsIgnoreCase("canada"));
//            fluxSink.complete();
//        }).subscribe(System.out::println, throwable -> System.out.println(throwable.getMessage()), () -> System.out.println("completedd"));

//        generateCharacters().subscribe(System.out::println);


//        Flux.create(sink -> {
//                    sink.next("Hello from " + Thread.currentThread().getName());
//                    sink.complete();
//                })
//                .subscribeOn(Schedulers.parallel())
//                .subscribe(System.out::println);

//        Path path = Paths.get("src/main/resources/static/file1.txt");
//        Flux<String> flux = Flux.generate(
//                readFile(path),
//                read(),
//                closeReader()
//        );

//        Flux<Object> flux = Flux.generate(
//                () -> Files.newBufferedReader(path),
//                (bufferedReader, synchronousSink) -> {
//                    try {
//                        String line = bufferedReader.readLine();
//                        if (Objects.isNull(line)) {
//                            synchronousSink.complete();
//                        } else {
//                            synchronousSink.next(line);
//                        }
//                    } catch (IOException e) {
//                        synchronousSink.error(e);
//                    }
//                    return bufferedReader;
//                },
//                bufferedReader -> {
//                    try {
//                        bufferedReader.close();
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//        );


//        flux
//                .map(o -> {
//                    if (o.toString().length() > 5) {
//                        throw new RuntimeException("can't be grater than 5");
//                    }
//                    return o;
//                })
//                .take(10)
//                .subscribe(
//                        System.out::println,
//                        throwable -> System.out.println(throwable.getMessage()),
//                        () -> System.out.println("completed")
//                );

//        Flux.generate(synchronousSink -> {
//            String country = Faker.instance().country().name();
//            synchronousSink.next(country);
//        }).handle((o, synchronousSink) -> {
//            synchronousSink.next(o);
//            if (o.toString().equalsIgnoreCase("canada")) {
//                synchronousSink.complete();
//            }
//        }).subscribe(System.out::println);

//        sleep(5);

//        Flux.range(1, 10)
//                .doOnComplete(() -> System.out.println("doOnComplete()"))
//                .subscribe(System.out::println);

//        Flux.range(1, 10)
//                .map(i -> 10 / (5 - i))
//                .onErrorReturn(10)
//                .onErrorResume(e -> Mono.fromSupplier(
//                        () -> Faker.instance().number().randomDigit())
//                )
//                .subscribe(System.out::println);

        CheckedSupplier<List<Person>, Exception> getAllPersons = FunctionalProgramming::getAllPersons;
        List<Person> personList = getAllPersons.get();
        Flux<Person> flux = Flux.fromIterable(personList);


//        flux
//                .filter(person -> person.getAge() > 30)  // Filter persons with age > 30
//                .map(person -> {  // Transform the name to uppercase
//                    person.setName(person.getName().toUpperCase());
//                    return person;
//                })
//                .subscribe(System.out::println);

//        flux
//                .log()
//                .transform(personFlux -> {
//                    personFlux
//                            .filter(person -> person.getAge() > 30)
//                            .map(person -> {
//                                // Transform the name to uppercase
//                                person.setName(person.getName().toUpperCase());
//                                return person;
//                            });
//                    return personFlux;
//                })
//                .subscribe(System.out::println);

//        Flux<Integer> range = Flux.range(1, 10);
//        range.map(i -> i * 10);
//        range.subscribe(System.out::println);

        // Create a Flux that emits the names of all Person objects and print each name.

//        getAllPersons()
//                .map(Person::getName)
//                .subscribe(System.out::println);

        // Filter out and print names of all Person objects who are engineers.
//        getAllPersons()
//                .filter(person -> person.getOccupation().equalsIgnoreCase("engineer"))
//                .map(Person::getName)
//                .subscribe(System.out::println);

        // Map each Person to a string in the format "Name - Age" and print.
//        getAllPersons()
//                .map(person -> "Name :" + person.getName() + " " + "Age :" + person.getAge())
//                .subscribe(System.out::println);

//        getAllPersons()
//                .transform(personFlux -> {
//                    Flux<String> newFlux = personFlux.map(person -> "Name :" + person.getName() + " " + "Age :" + person.getAge());
//                    return newFlux;
//                })
//                .subscribe(System.out::println);

        // Convert the Flux<Person> to a Flux<String> that emits only the cities where these persons are located.
//        getAllPersons()
//                .map(Person::getCity)
//                .subscribe(System.out::println);

        // Find the total salary of all Person objects and print.
//        getAllPersons()
//                .map(Person::getSalary)
//                .reduce(0.0, Double::sum)
//                .subscribe(System.out::println);

        // Group Person objects by gender and count them. Print the count for each gender.
//        getAllPersons()
//                .collect(Collectors.groupingBy(Person::getGender, Collectors.counting()))
//                .groupBy(Person::getGender)
//                .flatMap(group -> group.count().map(count -> group.key() + ": " + count))
//                .subscribe(System.out::println);

        Flux<Integer> fallback = Flux.just(7, 8, 9);

        Flux<Integer> flux1 = Flux.concat(
                
                Flux.just(4, 5, 6),
                Flux.just(1, 2, 3).map(i -> {
                    if (i == 2) throw new RuntimeException("Error in flux1");
                    return i;
                })
        ).onErrorResume(
                error -> fallback  // Switch to fallback Flux when error occurs
        );

        flux1.subscribe(
                System.out::println,
                error -> System.out.println("Error encountered: " + error.getMessage())
        );


//        Flux<Integer> flux1 = Flux.concatDelayError(
//                Flux.just(1, 2, 3).map(i -> {
//                    if (i == 2) throw new RuntimeException("Error in flux1 for the element : " + i);
//                    return i;
//                }),
//                Flux.just(4, 5, 6)
//        );
//
//        flux1.subscribe(
//                System.out::println,
//                error -> System.out.println("Error encountered: " + error.getMessage())
//        );


    }


    private static Flux<Person> getAllPersons() {
        List<Person> personList = Arrays.asList(
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
        return Flux.fromIterable(personList);
    }

    private static Consumer<BufferedReader> closeReader() {
        return bufferedReader -> {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    private static Callable<BufferedReader> readFile(Path path) {
        return () -> Files.newBufferedReader(path);
    }

    private static BiFunction<BufferedReader, SynchronousSink<String>, BufferedReader> read() {
        return (bufferedReader, stringSynchronousSink) -> {
            try {
                String line = bufferedReader.readLine();
                if (Objects.isNull(line)) {
                    stringSynchronousSink.complete();
                } else {
                    stringSynchronousSink.next(line);
                }
            } catch (IOException e) {
                stringSynchronousSink.error(e);
            }
            return bufferedReader;
        };
    }


    private static Flux<Character> generateCharacters() {
        return Flux.generate(() -> 97, (state, sink) -> {
            char value = (char) state.intValue();
            sink.next(value);
            if (value == 'z') {
                sink.complete();
            }
            return state + 1;
        });
    }

    private static void sleep(int i) {

        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static Integer getRandomNo() {
        Random random = new Random();
        int randomNumber = random.nextInt(11) - 5;
        return randomNumber;
    }

    private static CompletableFuture<String> getNameAsync() {
        return CompletableFuture.supplyAsync(() -> Faker.instance().name().fullName());
    }

    private static Mono<String> getNameAfterWaiting() {
        System.out.println("generating name");
        return Mono.fromSupplier(() -> {
                            System.out.println("generating name and uppercasingg it");
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            return Faker.instance().name().fullName();
                        }
                )
                .map(String::toUpperCase);
    }

    private static String getName() {
        System.out.println("generating name");
        return Faker.instance().name().fullName();
    }

    private static Faker getFaker() {
        return Faker.instance();
    }


    public static Mono<String> getUserDetails(Integer integer) {
        System.out.println("generating");
        if (integer == 1) {
            return Mono.just(getFaker().name().fullName());
        } else if (integer == 2) {
            return Mono.empty();
        } else {
            return Mono.error(() -> new RuntimeException("please provide valid range"));
        }
    }


}
