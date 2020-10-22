import java.util.HashMap;

public class StudentStorage {
    private HashMap<String, Student> storage;

    public StudentStorage() {
        storage = new HashMap<>();
    }

    public void addStudent(String data) {
        String[] components = data.split("\\s+");
        String name = components[0] + " " + components[1];
        components[3] = "+" + components[3].replaceAll("[^0-9]", "");
        if (components[3].length() != 12) throw new IllegalArgumentException("Номер телефона должен состоять из цифр");
        if (!components[2].contains("@")) throw new IllegalArgumentException("email должен содержать знак @");
        storage.put(name, new Student(name, components[3], components[2]));
    }

    public void listStudent() {
        storage.values().forEach(System.out::println);
    }

    public void removeStudent(String name) {
        if (!storage.containsKey(name)) throw new IllegalArgumentException("Нет такого имени для удаления");
        storage.remove(name);
    }

    public Student getStudentByName(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}