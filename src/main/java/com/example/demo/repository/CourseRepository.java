package com.example.demo.repository;

import com.example.demo.modal.Course;
import com.example.demo.modal.Instructor;
import com.example.demo.modal.dto.CourseDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class CourseRepository {
    List<Course> courses = new ArrayList<>();

    public CourseRepository() { // lombok packet constructor, get/set
        Course javaOne = Course.builder()
                .className("Java I")
                .instructor(new Instructor("Steve", "Jobs", "Phd", "TownHall201"))
                .startDate(new Date("8/1/2018"))
                .endDate(new Date("12/24/2018"))
                .timeFrame("8am-10am")
                .build();

//        ==> equals to
//        Course javaTwo = new Course("Java I",
//                new Instructor("Steve", "Jobs", "Phd", "TownHall201"),
//                new Date("8/1/2018"),
//                new Date("12/24/2018"),
//                "8am-10am");

        courses.add(javaOne);
    }

    public List<Course> findAllClasses(){
        // get data from dataset
        return courses;
    }

    public List<CourseDto> findAllClasses2() {
        List<CourseDto> courseDtos = new ArrayList<>();
        for (Course course : courses)
            courseDtos.add(CourseDto.builder()
                    .courseName(course.getClassName())
                    .build());
        return courseDtos;
    }

    public List<Course> findAllCourse(String searchByCourseName) {
        if (searchByCourseName.equals("Java I"))
            return courses;
        return new ArrayList<>();
    }
}
