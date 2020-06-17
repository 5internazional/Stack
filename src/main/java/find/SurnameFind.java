package find;

import data.Student;
import stack.Stack;
import stack.Stackable;

import java.util.Iterator;

public class SurnameFind implements Finder<Student> {
    @Override
    public Stackable<Student> stack(String line, Stackable<Student> stack) {
        Stackable<Student> search = new Stack<>();
        Iterator<Student> iterator = stack.iterator();
        while (iterator.hasNext()){
            Student student = iterator.next();
            if(student.getSurname().toLowerCase().contains(line.toLowerCase())){
                search.push(student);
            }
        }
        return search;
    }
}


