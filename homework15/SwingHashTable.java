package homework15;

import javax.swing.*;
import java.awt.*;

public class SwingHashTable extends JFrame {
    private final int WIDTH_SIZE = 1024;
    private final int HEIGHT_SIZE = 600;
    private HashTable<String, String> hashTable = new HashTable<>(4);

    public static void main(String[] args) {
        new SwingHashTable();
    }

    public SwingHashTable() {  // это конструктор, в котором создаются соостветсвующие объект и методы, ниже
        setTitle("HashTable");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //initHashTable();

        // создается объект для рисования на основании класса CanvasPanel
        CanvasPanel canvasPanel = new CanvasPanel(); // создаем объект класса CanvasPanel
        canvasPanel.setPreferredSize(new Dimension(WIDTH_SIZE, HEIGHT_SIZE)); // устанавливаем размер Canvas
        canvasPanel.setBackground(Color.lightGray); // устанавливаем цвет фона

        JTextField textField = new JTextField();    // создаем поле ввода текста
        JButton enterButton = new JButton("Enter"); // создаем кнопку
        enterButton.addActionListener(e -> {  // обработчик который ждет когда мы нажмем на кнопку // прослушиватель
            // TODO
            // System.out.println("You write: " + textField.getText());
            String[] tokens = textField.getText().split(" ");
            if (tokens[0].equals("put")) {
                hashTable.put(tokens[1], tokens[2]);
            }
            textField.setText("");
            canvasPanel.repaint();  // картинка перерисовывается
        });
        // текст и кнопка размещяются в панеле bottomPanel
        JPanel bottomPanel = new JPanel(); // создаем нижний панель
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS)); // назначаем ему компоновщик // элементы должны быть вытянуты
        bottomPanel.add(textField);     //
        bottomPanel.add(enterButton);


// то что выводит на экран размещаем в центре
        // выполняем метод add, который добавляет объекты в созданное окно (самый простой компоновщик экрана)
        add(canvasPanel, BorderLayout.CENTER);  // дополнительный параметр BorderLayout указывает позицию,
                                                // куда устанавливаем объект на окне // BorderLayout делит экран на 5 частей
        add(bottomPanel, BorderLayout.SOUTH);   // нижняя панель (полоска) устанавливаем внизу

        pack();
        setLocationRelativeTo(null);  // станавливает окно в центре экрана
        setVisible(true);               // делает окно видимым
    }

    private void initHashTable() {
        hashTable.put("Kiev", "Ukraine");
        hashTable.put("Paris", "France");
        hashTable.put("Moscow", "Russia");
        hashTable.put("Berlin", "Germany");
        hashTable.put("Prague", "Czech Republic");
        hashTable.put("Warsaw", "Poland");
        hashTable.put("Madrid", "Spain");
    }

    // создали отдельный класс для рисования
    private class CanvasPanel extends JPanel {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            // это код, изображающее что-либо на экране
            HashTable<String, String>.Entry<String, String>[] table = hashTable.getTable();
            for (int i = 0; i < table.length; i++) {
                int link = 0;
                int x = 10 + i * 70;
                int y = 20;
                int dx = 65;
                int dy = 65;
                if (table[i] != null) {
                    g.setColor(Color.cyan);
                    g.fillRect(x, y, dx, dy);
                    g.setColor(Color.black);
                    g.drawString(String.format("%d %s", i, table[i].key), x + 5, y + 25);
                    g.drawString(table[i].value, x + 5, y + 40);
                    String next = (table[i].next == null) ? "n-> null" : "n-> " + table[i].next.key;
                    g.drawString(next, x + 5, y + 55);
                    HashTable<String, String>.Entry<String, String> pointer = table[i];
                    while (pointer.next != null) {
                        y = 20 + 65 + dy * link + 10 * (link + 1);
                        link++;
                        g.setColor(Color.cyan);
                        g.fillRect(x, y, dx, dy);
                        g.setColor(Color.black);
                        g.drawString(String.format("%d %s", i, pointer.next.key), x + 5, y + 25);
                        g.drawString(pointer.next.value, x + 5, y + 40);
                        String next2 = (pointer.next.next == null) ? "n-> null" : "n-> " + pointer.next.next.key;
                        g.drawString(next2, x + 5, y + 55);
                        pointer = pointer.next;
                    }
                } else {
                    g.getColor();
                    g.drawRect(x, y, dx, dy);
                    g.setColor(Color.black);
                    g.drawString(String.valueOf(i), x + 5, y + 25);
                }
            }
        }
    }
}
