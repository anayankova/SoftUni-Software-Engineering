import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

public class Engine implements Runnable {

    private final EntityManager entityManager;
    private final BufferedReader reader;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {

        //Ex 2
        //this.removeObjectsEx();
        
        //Ex 3
//        try {
//            this.containsEmployeeEx();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //Ex 4
        //this.employeeWithSalaryOver50000();

        //Ex 5
        //this.employeesFromDepartmentEx();

        //Ex 6
//        try {
//            this.addingNewAddressAndUpdatingEmployee();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //Ex 7
        //this.addressesWithEmployeeCount();

        //Ex 8
//        try {
//            this.getEmployeeWithProject();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //Ex 9
        //this.findLatest10Projects();

        //Ex 10
        //this.increaseSalariesEx();

        //Ex 11
//        try {
//            this.removeTownsEx();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //Ex 12
//        try {
//            this.findEmployeesByFirstName();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //Ex 13
        //this.employeesMaximumSalaries();

    }

    private void employeesMaximumSalaries() {
        Map<String, BigDecimal> departmentsWithMaxSalaries = new HashMap<>();
        List<Department> departments = this.entityManager.createQuery("SELECT d FROM Department AS d ",
                Department.class).getResultList();
        List<Employee> employees = this.entityManager.createQuery("SELECT e FROM Employee AS e ",
                Employee.class).getResultList();
        employees.forEach(e -> {
            departments.forEach(d -> {
                if (e.getDepartment().getName().equals(d.getName())) {
                    if (departmentsWithMaxSalaries.containsKey(d.getName())) {
                        if (e.getSalary().compareTo(departmentsWithMaxSalaries.get(d.getName())) > 0) {
                            departmentsWithMaxSalaries.put(d.getName(), e.getSalary());
                        }
                    } else {
                        departmentsWithMaxSalaries.put(d.getName(), e.getSalary());
                    }
                }
            });
        });
        departmentsWithMaxSalaries.forEach((k, v) -> {
            if (v.compareTo(BigDecimal.valueOf(30000)) < 0 || v.compareTo(BigDecimal.valueOf(70000)) > 0) {
                System.out.printf("%s %.2f%n", k, v);
            }
        });
    }

    private void findEmployeesByFirstName() throws IOException {
        System.out.println("Enter a pattern:");
        String pattern = reader.readLine();
        List<Employee> employees = this.entityManager.createQuery("SELECT e FROM Employee AS e ",
                Employee.class).getResultList();
        employees.forEach(e -> {
            String firstName = e.getFirstName().substring(0,2).toUpperCase();
            if (pattern.equals(firstName)) {
                System.out.printf("%s %s - %s - ($%.2f)%n", e.getFirstName(), e.getLastName(),
                        e.getJobTitle(), e.getSalary());
            }
        });
    }

    private void removeTownsEx() throws IOException {
        System.out.println("Enter town name:");
        String townName = this.reader.readLine();
        Town town = this.entityManager.createQuery("SELECT t FROM Town AS t " +
                "WHERE t.name = :name", Town.class)
                .setParameter("name", townName).getSingleResult();
        List<Address> addresses = this.entityManager.createQuery("SELECT a FROM Address AS a " +
                "WHERE a.town.id = :townId", Address.class)
                .setParameter("townId", town.getId()).getResultList();
        List<Employee> employees = this.entityManager.createQuery("SELECT e FROM Employee AS e " +
                "WHERE e.address.town.name = :name", Employee.class)
                .setParameter("name", townName).getResultList();
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(town);
        addresses.forEach(this.entityManager::remove);
        employees.forEach(this.entityManager::detach);
        employees.forEach(e -> e.setAddress(null));
        employees.forEach(this.entityManager::merge);
        this.entityManager.flush();
        this.entityManager.getTransaction().commit();
        if (addresses.size() > 1) {
            System.out.printf("%d addresses in %s deleted%n", addresses.size(), townName);
        } else if (addresses.size() == 1) {
            System.out.printf("1 address in %s deleted%n", townName);
        } else {
            System.out.println("No such town found.");
        }
    }

    private void increaseSalariesEx() {
        List<Employee> employees = this.entityManager.createQuery("SELECT e FROM Employee AS e " +
                        "WHERE e.department.name IN('Engineering', 'Tool Design', 'Marketing', 'Information Services')",
                Employee.class).getResultList();
//        BigDecimal b = BigDecimal.valueOf(0.12);
//        this.entityManager.getTransaction().begin();
//        employees.forEach(e -> e.setSalary(e.getSalary().add(b.multiply(e.getSalary()))));
//        this.entityManager.flush();
//        this.entityManager.getTransaction().commit();
        employees.forEach(e -> System.out.printf("%s %s ($%.2f)%n", e.getFirstName(), e.getLastName(), e.getSalary()));
    }

    private void findLatest10Projects() {
        List<Project> projects = this.entityManager
                .createQuery("SELECT p FROM Project AS p " +
                        "ORDER BY p.startDate DESC", Project.class)
                .setMaxResults(10).getResultList();
        projects.stream().sorted(Comparator.comparing(Project::getName))
                .forEach(p -> {
                    System.out.printf("Project name: %s%n", p.getName());
                    System.out.printf("   Project Description: %s%n", p.getDescription());
                    System.out.println("   Project Start Date: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.s")
                            .format(p.getStartDate()));
                    if (p.getEndDate() != null) {
                        System.out.println("   Project End Date: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.s")
                                .format(p.getEndDate()));
                    } else {
                        System.out.println("   Project End Date: null");
                    }
                });
    }

    private void getEmployeeWithProject() throws IOException {
        System.out.println("Enter employee id:");
        int id = Integer.parseInt(this.reader.readLine());
        try {
            Employee employee = this.entityManager.createQuery("SELECT e FROM Employee AS e " +
                    "WHERE e.id = :id", Employee.class)
                    .setParameter("id", id).getSingleResult();
            System.out.printf("%s %s - %s%n",
                    employee.getFirstName(), employee.getLastName(), employee.getJobTitle());
            List<String> projects = new ArrayList<>();
            employee.getProjects().forEach(p -> projects.add(p.getName()));
            projects.stream().sorted().forEach(p -> System.out.printf("%s%n", p));
        } catch (NoResultException nre) {
            System.out.println("No such employee");
        }
    }

    private void addressesWithEmployeeCount() {
        this.entityManager.createQuery("SELECT a FROM Address AS a " +
                "ORDER BY a.employees.size DESC  ", Address.class)
                .setMaxResults(10).getResultStream()
                .forEach(a -> System.out.printf("%s, %s - %d employees%n",
                        a.getText(), a.getTown().getName(), a.getEmployees().size()));
    }

    private void addingNewAddressAndUpdatingEmployee() throws IOException {
        System.out.println("Enter employee last name:");
        String lastName = reader.readLine();
        Employee employee = this.entityManager.createQuery("SELECT e FROM Employee AS e " +
                "WHERE e.lastName = :name", Employee.class)
                .setParameter("name", lastName).getSingleResult();
        Address address = this.createNewAddress("Vitoshka 15");
        this.entityManager.getTransaction().begin();
        this.entityManager.detach(employee);
        employee.setAddress(address);
        this.entityManager.merge(employee);
        this.entityManager.flush();
        this.entityManager.getTransaction().commit();
    }

    private Address createNewAddress(String textContent) {
        Address address = new Address();
        address.setText(textContent);
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(address);
        this.entityManager.getTransaction().commit();

        return address;
    }

    private void employeesFromDepartmentEx() {
        List<Employee> employees = this.entityManager
                .createQuery("SELECT e FROM Employee AS e " +
                        "Where e.department.name = 'Research and Development' " +
                        "ORDER BY e.salary, e.id", Employee.class)
                .getResultList();
        employees.forEach(e -> System.out.printf("%s %s from %s - $%.2f%n",
                e.getFirstName(), e.getLastName(), e.getDepartment().getName(), e.getSalary()));
    }

    private void employeeWithSalaryOver50000() {
        this.entityManager.createQuery("SELECT e FROM Employee AS e " +
                "Where e.salary > 50000", Employee.class).getResultStream()
                .forEach(e -> System.out.printf("%s%n", e.getFirstName()));
    }

    private void containsEmployeeEx() throws IOException {
        System.out.println("Enter employee full name:");
        String fullName = this.reader.readLine();
        try {
            Employee employee = this.entityManager.createQuery("SELECT e FROM Employee AS e " +
                    "WHERE concat(e.firstName, ' ', e.lastName) = :name", Employee.class)
                    .setParameter("name", fullName).getSingleResult();
            System.out.println("Yes");
        } catch (NoResultException nre) {
            System.out.println("No");
        }
    }

    private void removeObjectsEx() {
        List<Town> towns = this.entityManager.createQuery("SELECT t FROM Town AS t " +
                "WHERE length(t.name) > 5", Town.class)
                .getResultList();
        this.entityManager.getTransaction().begin();
        towns.forEach(this.entityManager::detach);
        for (Town town : towns) {
            town.setName(town.getName().toLowerCase());
        }
        towns.forEach(this.entityManager::merge);
        this.entityManager.flush();
        this.entityManager.getTransaction().commit();
        System.out.println();
    }
}
