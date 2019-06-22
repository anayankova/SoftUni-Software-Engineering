package g_Generics.JarOfT;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Jar<T> {

    private List<T> element;

    public Jar() {
        this.element = new ArrayList<>();
    }

    public void add(T element) {
        this.element.add(element);
    }

    public T remove() {
        return this.element.remove(this.element.size() - 1);
    }

    //private Deque<T> content;
    //public Jar() { this.content = new ArrayDeque<>(); }

    //public void add(T entity) {
    //    this.content.push(entity);
    //}

    //public T remove() { return this.content.pop(); }


}
