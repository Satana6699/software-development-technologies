import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HotDogManager extends JFrame {
    private DefaultListModel<HotDog> listModel;
    private JList<HotDog> hotDogList;
    private ArrayList<HotDog> hotDogs;

    public HotDogManager() {
        hotDogs = new ArrayList<>();

        // Create the list model and JList
        listModel = new DefaultListModel<>();
        hotDogList = new JList<>(listModel);
        hotDogList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Set up the JFrame
        setTitle("HotDog Manager");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Add components to the frame
        add(new JScrollPane(hotDogList), BorderLayout.CENTER);

        // Create a panel for buttons
        JPanel panel = new JPanel();
        JButton addButton = new JButton("Add HotDog");
        JButton editButton = new JButton("Edit HotDog");
        JButton removeButton = new JButton("Remove HotDog");
        panel.add(addButton);
        panel.add(editButton);
        panel.add(removeButton);
        add(panel, BorderLayout.SOUTH);

        // Add action listeners for the buttons
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addHotDog();
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editHotDog();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeHotDog();
            }
        });

        setVisible(true);
    }

    private void addHotDog() {
        HotDogDialog dialog = new HotDogDialog(this);
        dialog.setVisible(true);
        HotDog hotDog = dialog.getHotDog();
        if (hotDog != null) {
            hotDogs.add(hotDog);
            listModel.addElement(hotDog);
        }
    }

    private void editHotDog() {
        int selectedIndex = hotDogList.getSelectedIndex();
        if (selectedIndex != -1) {
            HotDog hotDog = hotDogs.get(selectedIndex);
            HotDogDialog dialog = new HotDogDialog(this, hotDog);
            dialog.setVisible(true);
            HotDog updatedHotDog = dialog.getHotDog();
            if (updatedHotDog != null) {
                hotDogs.set(selectedIndex, updatedHotDog);
                listModel.set(selectedIndex, updatedHotDog);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a HotDog to edit.");
        }
    }

    private void removeHotDog() {
        int selectedIndex = hotDogList.getSelectedIndex();
        if (selectedIndex != -1) {
            hotDogs.remove(selectedIndex);
            listModel.remove(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a HotDog to remove.");
        }
    }

    public static void main(String[] args) {
        new HotDogManager();
    }
}
