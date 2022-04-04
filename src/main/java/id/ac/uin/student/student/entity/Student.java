package id.ac.uin.student.student.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "First name is required")
    @NotNull(message = "FirstName can not be null!!")
    @Column(nullable = false, name = "first_Name")
    private String firstName;

    @NotEmpty(message = "Last name is required")
    @NotNull(message = "LastName can not be null!!")
    @Column(nullable = false, name = "last_Name")
    private String lastName;

    @NotNull(message = "Please enter birth date")
    @Past(message = "Birth date should be less than current date!!")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDate;

    @NotEmpty(message = "email is required")
    @Email
    @Column(nullable = false, name = "email", unique = true)
    private String email;

    @NotEmpty(message = "Phone number is required")
    @NotNull(message = "Phone can not be null!!")
    @Column(nullable = false, unique = true)
    private String phone;

    @NotEmpty(message = "Jurusan is required")
    @NotNull(message = "Jurusan can not be null!!")
    @Column(nullable = false, unique = true)
    private String jurusan;
}