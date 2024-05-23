import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class HotDogDialog extends JDialog {
    private JTextField nameField;
    private JTextField costField;
    private JComboBox<String> typeComboBox;
    private HotDog hotDog;

    public HotDogDialog(JFrame owner) {
        super(owner, "Add/Edit HotDog", true);
        setupDialog();
    }

    public HotDogDialog(JFrame owner, HotDog hotDog) {
        super(owner, "Add/Edit HotDog", true);
        this.hotDog = hotDog;
        setupDialog();
        if (hotDog != null) {
            nameField.setText(hotDog._name);
            costField.setText(String.valueOf(hotDog._cost));
            if (hotDog instanceof Berlinka) {
                typeComboBox.setSelectedItem("Berlinka");
            } else if (hotDog instanceof HunterDog) {
                typeComboBox.setSelectedItem("HunterDog");
            } else if (hotDog instanceof MasterDog) {
                typeComboBox.setSelectedItem("MasterDog");
            }
        }
    }

    private void setupDialog() {
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Cost:"));
        costField = new JTextField();
        add(costField);

        add(new JLabel("Type:"));
        typeComboBox = new JComboBox<>(new String[]{"Berlinka", "HunterDog", "MasterDog"});
        add(typeComboBox);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onSave();
            }
        });
        add(okButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        add(cancelButton);

        pack();
        setLocationRelativeTo(getOwner());
    }

    private void onSave() {
        String name = nameField.getText();
        int cost;
        try {
            cost = Integer.parseInt(costField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Cost must be a number.");
            return;
        }
        String type = (String) typeComboBox.getSelectedItem();

        if (type.equals("Berlinka")) {
            hotDog = new Berlinka(name, cost);
        } else if (type.equals("HunterDog")) {
            hotDog = new HunterDog(name, cost);
        } else if (type.equals("MasterDog")) {
            hotDog = new MasterDog(name, cost);
        }

        setVisible(false);
    }

    public HotDog getHotDog() {
        return hotDog;
    }
}
