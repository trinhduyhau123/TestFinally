import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TodoList {
    List<Todo> listTodo = new ArrayList<Todo>();
    public int sizeList() {
        return listTodo.size();
    }

    public Date setDue(String dataString) throws ParseException {
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
            Date date = formater.parse(dataString);
            return date;
    }

    public void add(Todo todo) {
        listTodo.add(todo);
    }

    public Todo find(String title) {
        for (int i = 0; i < listTodo.size(); i++) {
            if (title == listTodo.get(i).getTitle()) {
                return listTodo.get(i);
            }
        }
        return null;
    }

    public List<Todo> showAll() {
        return listTodo;
    }

    public List<Todo> showDone() {
        List<Todo> listDone = new ArrayList<>();
        for (int i = 0; i < listTodo.size(); i++) {
            if (listTodo.get(i).isDone() == false) {
                listDone.add(listTodo.get(i));
            }
        }
        return listDone;
    }

    public List<Todo> showNotDone() {
        List<Todo> listNotDone = new ArrayList<>();
        for (int i = 0; i < listTodo.size(); i++) {
            if (listTodo.get(i).isDone() == false) {
                listNotDone.add(listTodo.get(i));
            }
        }
        return listNotDone;
    }

    public List<Todo> showPasDue() throws ParseException {
        List<Todo> listPasDue = new ArrayList<>();
        for (int i = 0; i < listTodo.size(); i++) {
            int result = listTodo.get(i).getDue().compareTo(setDue("09/29/2018"));
            if (result < 0 && (listTodo.get(i).isDone() == false)) {
                listPasDue.add(listTodo.get(i));
            }
        }
        return listPasDue;
    }

    public Todo getElement(int i) {
        return listTodo.get(i);

    }

    public void removeDone() {
        boolean check = false;
        for (int i = 0; i < listTodo.size(); i++) {
            if (listTodo.get(i).isDone() == true) {
                listTodo.remove(i);
                check = true;
            } else {
                check = false;
            }
        }
        if (check == true) {
            System.out.println("Delete Done");
        }

    }

    public static void main(String[] args) throws ParseException {
        try {
            Todo todo_1 = new Todo();
            todo_1.setTitle("Hoc tieng anh");
            todo_1.setDescription("Hoc tu vung");
            todo_1.setDone(false);
            todo_1.setDue(new Date());

            Todo todo_2 = new Todo();
            todo_2.setTitle("Code java");
            todo_2.setDescription("Array List");
            todo_2.setDone(true);
            todo_2.setDue(new Date());

            Todo todo_3 = new Todo();
            todo_3.setTitle("Tap the duc");
            todo_3.setDescription("Plank");
            todo_3.setDone(false);
            todo_3.setDue(new Date());


            TodoList todoLists = new TodoList();
            todoLists.add(todo_1);
            todoLists.add(todo_2);
            todoLists.add(todo_3);


            System.out.println("--------------Show all: -------------------");
            for (int i = 0; i < todoLists.sizeList(); i++) {
                System.out.println("------------------");
                todoLists.getElement(i).showInfor();
            }

            System.out.println("--------------Show Not Done: -------------------");
            for (int i = 0; i < todoLists.showNotDone().size(); i++) {
                System.out.println("-----------------");
                todoLists.showNotDone().get(i).showInfor();
            }

            System.out.println("--------------Show Pass Date------------------");
            for (int i = 0; i < todoLists.showPasDue().size(); i++) {
                System.out.println("----------------");
                todoLists.showPasDue().get(i).showInfor();
            }

            System.out.println("--------------Show Done: -------------------");
            for (int i = 0; i < todoLists.showNotDone().size(); i++) {
                System.out.println("-----------------");
                todoLists.showDone().get(i).showInfor();
            }

            System.out.println("-------------Remove Item-----------------");
            todoLists.removeDone();

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
