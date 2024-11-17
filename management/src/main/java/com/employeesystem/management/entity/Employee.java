//package com.employeesystem.management.entity;
//
//import jakarta.persistence.*;
//import lombok.*;
//import org.springframework.data.annotation.Id;
////import jakarta.persistence.Id;
//
//
//
//@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Builder
//@Table(name =" employee")
//public class Employee {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    private Long id;
//
////    public Employee(Long id, String name, String manager, Integer salary) {
////        this.id = id;
////        this.name = name;
////        this.manager = manager;
////        this.salary = salary;
////    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getManager() {
//        return manager;
//    }
//
//    public Integer getSalary() {
//        return salary;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setManager(String manager) {
//        this.manager = manager;
//    }
//
//    public void setSalary(Integer salary) {
//        this.salary = salary;
//    }
//
//    @Column(name = "name")
//    private  String name;
//    @Column(name = "manager")
//    private String manager;
//    @Column(name = "salary")
//    private Integer salary;
//}
package com.employeesystem.management.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "employee") // Removed the space after "name =" to ensure correctness
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Primary key auto-generation
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "manager")
    private String manager;

    @Column(name = "salary")
    private Integer salary;
}
