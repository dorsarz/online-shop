import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class ManagerPanel {
     private JFrame frame;
     private JPanel mainPanel;
     private JPanel mainManagerPanel=new JPanel();
     private ArrayList<String> productInfo=new ArrayList<>();
     public  ManagerPanel(JFrame frame,JPanel mainPanel){
        this.frame=frame;
        this.mainPanel=mainPanel;
    }
    public void addProduct(){
        frame.repaint();
        frame.revalidate();
        mainManagerPanel.setBounds(0,0,1000,1000);
        mainManagerPanel.setBackground(Color.lightGray);
        mainManagerPanel.setLayout(new GridLayout(2,4));
        ImageIcon pinkyIcon=new ImageIcon("pink.jpeg");
        JButton pink=new JButton(pinkyIcon);
        ImageIcon lemonIcon=new ImageIcon("lemon.jpeg");
        JButton lemon=new JButton(lemonIcon);
        ImageIcon mintIcon=new ImageIcon("mint.jpeg");
        JButton mint=new JButton(mintIcon);
        ImageIcon purpleIcon=new ImageIcon("purple.jpeg");
        JButton purple=new JButton(purpleIcon);
        ImageIcon orangeIcon=new ImageIcon("orange.jpeg");
        JButton orange=new JButton(orangeIcon);
        JButton backButton=new JButton("back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(mainManagerPanel);
                frame.add(mainPanel);
                frame.repaint();
                frame.revalidate();
            }
        });
        JButton addProduct=new JButton("add product");
        addProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(mainManagerPanel);
                JPanel panel=new JPanel();
                panel.setBounds(0,0,800,800);
                panel.setLayout(new GridLayout(3,2));
                JLabel nameLabel= new JLabel("name of product");
                nameLabel.setPreferredSize(new Dimension(50,50));
                panel.add(nameLabel);
                JTextField nameField=new JTextField();

                if(nameField.equals("pink")){
                    productInfo.add("pink.jpeg");
                } else if (nameField.equals("lemon")) {
                    productInfo.add("lemon.jpeg");
                }else if (nameField.equals("mint")) {
                    productInfo.add("lemon.jpeg");
                } else if (nameField.equals("orange")) {
                    productInfo.add("orange.jpeg");
                } else if (nameField.equals("purple")) {
                    productInfo.add("purple.jpeg");
                }

                panel.add(nameField);
                JLabel priceLabel=new JLabel("price of product");
                panel.add(priceLabel);
                JTextField priceField=new JTextField();
                productInfo.add(priceField.getText());
                panel.add(priceField);
                JLabel inventoryLabel=new JLabel("inventory of product");
                panel.add(inventoryLabel);
                JTextField inventoryField=new JTextField();
                productInfo.add(inventoryField.getText());
                panel.add(inventoryField);

                frame.add(panel);
                frame.repaint();
                frame.revalidate();

            }
        });
        mainManagerPanel.add(pink);
        mainManagerPanel.add(lemon);
        mainManagerPanel.add(mint);
        mainManagerPanel.add(purple);
        mainManagerPanel.add(orange);
        mainManagerPanel.add(addProduct);
        mainManagerPanel.add(backButton);


        frame.add(mainManagerPanel);
        frame.setVisible(true);

    }
}
