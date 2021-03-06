package com.ilker.controller.Student;

import com.ilker.model.Student.Student;
import com.ilker.service.Student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    private StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService){
        this.studentService= studentService;
    }

    @GetMapping()
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent( @RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path="{studentId}")
    public void deleteStudentById(@PathVariable("studentId") String studentId){
        studentService.deleteStudent(studentId);
    }

    @DeleteMapping(path="/number/{studentNumber}")
    public void deleteStudentByNumber(@PathVariable("studentNumber") Integer studentNumber){
        studentService.deleteStudentByNumber(studentNumber);
    }
    @PutMapping(path="{studentId}")
    public void updateStudent(
            @PathVariable("studentId") String studentId,
            @RequestParam(required = false) Optional<String> name,
            @RequestParam(required = false) Optional<String> surname
            ){
        studentService.updateStudent(studentId, name,surname);
    }
}
