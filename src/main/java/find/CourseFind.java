package find;

import data.Student;
import stack.Stack;
import stack.Stackable;

import java.util.Iterator;

public class CourseFind implements Finder<Student> {
    @Override
    public Stackable<Student> stack(String line, Stackable<Student> stack) {
        Stackable<Student> search = new Stack<>();
        Iterator<Student> iterator = stack.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getCourse() == Integer.parseInt(line)) {
                search.push(student);
            }

        }
        return search;
    }
}
