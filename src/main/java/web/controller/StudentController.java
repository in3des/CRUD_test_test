package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import web.model.Student;
import web.services.StudentServices;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentServices studentServices;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Student> studentList = studentServices.listAll();
        model.addAttribute("studentList", studentList);
        return "index";
    }

    @RequestMapping("/new")
    public String newStudentPage(Model model) {
        Student student = new Student();
        model.addAttribute(student);
        return "new_student";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute ("student") Student student) {
        studentServices.save(student);
        return "redirect:/";
    }

    @RequestMapping("edit/{sid}")
    public ModelAndView showEditStudentPage(@PathVariable ("sid") Long sid) {
        ModelAndView mav = new ModelAndView("edit_student");
        Student student = studentServices.get(sid);
        mav.addObject("student", student);
        return mav;
    }

    @RequestMapping("delete/{sid}")
    public String deleteStudentPage(@PathVariable ("sid") Long sid) {
        studentServices.delete(sid);
        return "redirect:/";
    }


}
