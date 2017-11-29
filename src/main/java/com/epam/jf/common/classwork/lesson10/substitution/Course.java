package com.epam.jf.common.classwork.lesson10.substitution;

class Course{}
class BaseCourse extends Course{}

class CourseHelper {
    public Course getCourse(){
        System.out.println("Course");
        return new Course();
    }
}
class BaseCourseHelper extends CourseHelper {

    @Override
    public BaseCourse getCourse(){
        System.out.println("BaseCourse");
        return new BaseCourse();
    }
}

class CourseInspector {
    public static void main(String[] args) {
        CourseHelper bch = new BaseCourseHelper();
//        Course course = bch.getCourse();
        BaseCourse course = (BaseCourse) bch.getCourse();
        //ошибка компиляции
        bch.getCourse();
        bch.getClass();
    }
}

