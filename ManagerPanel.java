import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class ManagerPanel {
    // a panel to add product

    File product;
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel mainManagerPanel=new JPanel();
    ArrayList<String> productInfo =new ArrayList<>();
    JTextField nameField=new JTextField();
    JTextField priceField=new JTextField();
    JTextField inventoryfield=new JTextField();
    JTextField iconField=new JTextField();


    public ManagerPanel(JFrame frame,JPanel mainPanel){
        this.product=product;
        this.frame=frame;
        this.mainPanel=mainPanel;
    }
    public void addProduct(){
        // gui part
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

                // some textField added to get products information9
                frame.remove(mainManagerPanel);
                JPanel panel=new JPanel();
                panel.setBounds(0,0,800,800);
                panel.setLayout(new GridLayout(5,2));
                JLabel nameLabel= new JLabel("name of product");
                nameLabel.setPreferredSize(new Dimension(50,50));
                panel.add(nameLabel);
                panel.add(nameField);

                JLabel priceLabel=new JLabel("price of product");
                panel.add(priceLabel);
                panel.add(priceField);

                JLabel inventoryLabel=new JLabel("Inventory");
                panel.add(inventoryLabel);

                panel.add(inventoryfield);

                JLabel iconLabel=new JLabel("Icon");
                panel.add(iconLabel);
                panel.add(iconField);


                JButton enter=new JButton("Enter");
                panel.add(enter);
                enter.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        productInfo.add(nameField.getText());
                        productInfo.add(priceField.getText());
                        productInfo.add(inventoryfield.getText());
                        productInfo.add(iconField.getText());
                        FileWriter writer=null;
                        try {
                            writer = new FileWriter(product);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        BufferedWriter bufferedWriter=new BufferedWriter(writer);
                        for (int i = 0; i < productInfo.size(); i++) {

//                            try {
////                                bufferedWriter.write(productInfo.get(i)+":");
//                            } catch (IOException ex) {
//                                throw new RuntimeException(ex);
//                            }
                        }
                        try {
                            bufferedWriter.write("\n");
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        try {
                            bufferedWriter.close();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
                JButton backBut=new JButton("Back");
                panel.add(backBut);
                backBut.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.remove(panel);
                        frame.repaint();
                        frame.revalidate();
                        frame.add(mainManagerPanel);

                    }
                });
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
