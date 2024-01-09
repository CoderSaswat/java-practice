package com.java.practice.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.java.practice.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
@Component
public class AsynchronousProgramming {

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {

//        System.out.println("Thread : " + Thread.currentThread().getName());
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        Future<List<Integer>> future = executorService.submit(() -> {
//            System.out.println("Thread : " + Thread.currentThread().getName());
//            sleepSeconds(30);
//            return Arrays.asList(1, 2, 3, 4, 5);
//        });
//        List<Integer> integerList = future.get();
//        System.out.println(integerList);


//        Faker faker = new Faker();
//        Random random = new Random();
//        List<Employee> employees = new ArrayList<>();
//        for (int i = 0; i < 100000; i++) {
//            String name = faker.name().fullName();
//            String jobTitle = faker.job().title();
//            String phoneNumber = faker.phoneNumber().cellPhone();
//            String email = faker.internet().emailAddress();
//            Employee employee = new Employee(UUID.randomUUID(), name, jobTitle, phoneNumber, email, random.nextBoolean(), random.nextBoolean());
//            employees.add(employee);
//        }
//        Gson gson = new Gson();
//        String json = gson.toJson(employees);
//        log.info(Thread.currentThread().getName());
//        saveEmpAsyncInDB("F:/e-commerce-new/user-service/src/main/resources/static/emp1.json");
//        saveEmpRunAsyncInJson("F:/e-commerce-new/user-service/src/main/resources/static/emp10.json", employees);
//        List<Employee> employeeList = saveEmpSupplyAsyncInDB("F:/e-commerce-new/user-service/src/main/resources/static/emp10.json");

//        readFileFromJsonAndSaveInDB("F:/e-commerce-new/user-service/src/main/resources/static/emp10.json");

//        log.info(Thread.currentThread().getName());
//        log.info("count of employees saved in db :" + employeeList.size());
//        sleepSeconds(3);

//        sendTrainingReminderToEmployees("F:/e-commerce-new/user-service/src/main/resources/static/emp7.json");
//        System.out.println(employees.size());
//        log.info(Thread.currentThread().getName());

//        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
//            log.info("1st future");
//            return "result 1";
//        });
//        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
//            log.info("2nd future");
//            return "result 2";
//        });
//        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
//            log.info("3rd future");
//            return "result 3";
//        });
//
//        CompletableFuture<Void> allFuture = CompletableFuture.allOf(future1, future2, future3);
//        allFuture.thenRun(() -> {
//            String result1 = future1.join();
//            String result2 = future2.join();
//            String result3 = future3.join();
//            log.info(result1 + ", " + result2 + ", " + result3);
//        });
//        sleepSeconds(3);


//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
//            int result = 10 / 0; // Causes an ArithmeticException
//            return result;
//        });
//
//        future.exceptionally(ex -> {
//            System.out.println("Exception occurred: " + ex.getMessage());
//            return null; // Default value to return if there's an exception
//        }).thenAccept(result -> {
//            System.out.println("Result: " + result);
//        });

//        log.info("i am main");
//        CompletableFuture<Void> completableFuture = fetchUserIdAsync().thenCompose(id -> fetchUserDetailsAsync(id)).thenCompose(AsynchronousProgramming::transformUserName).thenAccept(s -> log.info("result :" + s));
//        completableFuture.join();
//        log.info("i am main");
//        sleepSeconds(5);

        CompletableFuture<String> fetchUserDetailsAsync = fetchUserDetailsAsync();
        CompletableFuture<String> fetchOrderDetailsAsync = fetchOrderDetailsAsync();
        fetchUserDetailsAsync.thenCombine(fetchOrderDetailsAsync, (s1, s2) -> "User :" + s1 + "Order :" + s2).thenAccept(s -> log.info("result :" + s));
        sleepSeconds(5);

    }

    public static CompletableFuture<Integer> fetchUserIdAsync() {
        return CompletableFuture.supplyAsync(() -> {
            // Simulate delay
            sleepSeconds(5);
            log.info("Fetched User ID: 101");
            return 101;
        });
    }

    // Simulate fetching user details asynchronously using user ID
    public static CompletableFuture<String> fetchUserDetailsAsync(int userId) {
        return CompletableFuture.supplyAsync(() -> {
            // Simulate delay
            sleepSeconds(3);
            log.info("Fetched User Details for ID: " + userId);
            return "JohnDoe";
        });
    }

    public static CompletableFuture<String> fetchUserDetailsAsync() {
        return CompletableFuture.supplyAsync(() -> "user details");
    }

    public static CompletableFuture<String> fetchOrderDetailsAsync() {
        return CompletableFuture.supplyAsync(() -> "order details");
    }


    // Simulate transforming user name
    public static CompletableFuture<String> transformUserName(String userName) {
        sleepSeconds(2);
        return CompletableFuture.supplyAsync(() -> "Transformed-" + userName);
    }

    private static void readFileFromJsonAndSaveInDB(String fileName) {
        log.info("reading the employee from json file");
        Reader reader = null;
        try {
            reader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Type type = new TypeToken<List<Employee>>() {
        }.getType();
        List<Employee> employeeList = new Gson().fromJson(reader, type);
        log.info("saving the employee list in db");
        log.info(Thread.currentThread().getName());
    }

    private static void sendTrainingReminderToEmployees(String fileName) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> {
            Reader reader;
            try {
                reader = new FileReader(fileName);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            Type type = new TypeToken<List<Employee>>() {
            }.getType();
            List<Employee> employeeList = new Gson().fromJson(reader, type);
            log.info("getting employees from json file");
            return employeeList;
        }, executorService).thenApplyAsync(employees -> {
            log.info("filtering all new joinee employees");
            return employees.stream().filter(employee -> employee.getIsNewJoinee().equals(Boolean.TRUE)).toList();
        }, executorService).thenApplyAsync(employees -> {
            log.info("filtering all training pending employess");
            return employees.stream().filter(employee -> employee.getIsTrainingPending().equals(Boolean.TRUE)).toList();
        }, executorService).thenApplyAsync(employees -> {
            log.info("getting emails of all employees which are new joinee and has not completed their training");
            return employees.stream().map(Employee::getEmail).toList();
        }, executorService).thenAcceptAsync(emails -> {
            log.info("sending emails");
            emails.stream().forEach(AsynchronousProgramming::sendEmail);
        }, executorService);
        completableFuture.get();
    }

    private static void sendEmail(String email) {
        log.info("sending emails to :" + email);
    }

    private static List<Employee> saveEmpSupplyAsyncInDB(String fileName) throws ExecutionException, InterruptedException {
        CompletableFuture<List<Employee>> completableFuture = CompletableFuture.supplyAsync(() -> {
            Reader reader = null;
            try {
                reader = new FileReader(fileName);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            Type type = new TypeToken<List<Employee>>() {
            }.getType();
            List<Employee> employeeList = new Gson().fromJson(reader, type);
            log.info("saving the employee list in db");
            log.info(Thread.currentThread().getName());
            return employeeList;
        });
        log.info(Thread.currentThread().getName());
        return completableFuture.get();
    }

    private static void saveEmpRunAsyncInJson(String filePath, List<Employee> employees) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            log.info(Thread.currentThread().getName());
            try (FileWriter fileWriter = new FileWriter(filePath)) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                log.info("Saving to file: {}", filePath);
                gson.toJson(employees, fileWriter);
                log.info("Successfully saved employees to file: {}", filePath);
            } catch (IOException e) {
                throw new RuntimeException("Error writing JSON to file", e);
            }
        });
        // Wait for the CompletableFuture to complete
        completableFuture.get();
    }


    static void sleepSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static void saveEmpAsyncInDB(String fileName) throws FileNotFoundException, ExecutionException, InterruptedException {
        Executor executor = Executors.newFixedThreadPool(10);
        Reader reader = new FileReader(fileName);
        Type type = new TypeToken<List<Employee>>() {
        }.getType();
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            List<Employee> employeeList = new Gson().fromJson(reader, type);
            log.info("saving the employee list in db");
            log.info(Thread.currentThread().getName());
            employeeList.stream().forEach(employee -> log.info(employee.getName() + " " + employee.getEmail() + " " + employee.getJobTitle() + " " + employee.getPhoneNumber()));
        }, executor);
        log.info(Thread.currentThread().getName());
//        completableFuture.toCompletableFuture();
        completableFuture.get();
        log.info(Thread.currentThread().getName());
    }


}
