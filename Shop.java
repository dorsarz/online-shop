import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

 public class Shop{
   private ArrayList<String> userInformation=new ArrayList<>();
   public Shop(){

   }
    public  static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Font font=new Font("font",Font.BOLD,25);
            JFrame frame = new JFrame("online shop");
            frame.setSize(1000, 1000);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel mainPanel = new JPanel(new BorderLayout());
            JPanel topPanel = new JPanel();
            JPanel shopBoxPanel=new JPanel();

            shopBoxPanel.setLayout(null);
            JButton backButton=new JButton("Back");
            backButton.setFont(font);
            backButton.setBounds(470,700,100,50);
            shopBoxPanel.add(backButton);
            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.remove(shopBoxPanel);
                    frame.add(mainPanel);
                    frame.repaint();
                    shopBoxPanel.revalidate();
                }
            });

            topPanel.setBackground(Color.LIGHT_GRAY);
            JLabel title= new JLabel("let's shop crocs,it's good for your heart!");
            title.setFont(font);
            topPanel.add(title);

            JPanel scrollablePanel = new JPanel();
            scrollablePanel.setLayout(new GridLayout(0,1,10,10));

            ImageIcon firstIcon=new ImageIcon("pink.jpeg");
            JButton firstProduct=new JButton(firstIcon);
            JPanel firstPanel=new JPanel();
            firstPanel.setLayout(null);
            JLabel label=new JLabel("Classic pink lemonade crocs "+"Price:1800$");
            label.setFont(font);
            label.setBounds(270,180,600,300);
            JButton shopButton=new JButton("Add it to shopping box");
            shopButton.setFont(font);
            shopButton.setBounds(320,400,400,100);

            firstPanel.add(label);
            firstPanel.add(backButton);
            firstPanel.add(shopButton);
            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.remove(firstPanel);
                    frame.add(mainPanel);
                    frame.repaint();
                    shopBoxPanel.revalidate();
                }
            });
            firstProduct.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.remove(mainPanel);
                    frame.add(firstPanel);
                    frame.repaint();
                    frame.revalidate();
                }
            });
            ImageIcon secondIcon=new ImageIcon("lemon.jpeg");
            JButton secondProduct=new JButton(secondIcon);
            ImageIcon thirdIcon=new ImageIcon("mint.jpeg");
            JButton thirdProduct=new JButton(thirdIcon);
            ImageIcon fourthIcon=new ImageIcon("purple.jpeg");
            JButton fourthProduct=new JButton(fourthIcon);
            ImageIcon fifthIcon=new ImageIcon("orange.jpeg");
            JButton fifthProduct=new JButton(fifthIcon);


            scrollablePanel.add(firstProduct);
            scrollablePanel.add(secondProduct);
            scrollablePanel.add(thirdProduct);
            scrollablePanel.add(fourthProduct);
            scrollablePanel.add(fifthProduct);

            JPanel settingPanel=new JPanel();
            settingPanel.setBackground(Color.LIGHT_GRAY);
            settingPanel.setLayout(new GridLayout(0,1,5,5));
            JButton profileButton=new JButton("Profile");
            settingPanel.add(profileButton);
            JButton shoppingBox=new JButton("Shopping Box");
            settingPanel.add(shoppingBox);
            shoppingBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.remove(mainPanel);
                    frame.add(shopBoxPanel);
                    frame.repaint();
                    frame.revalidate();

                }
            });
            JButton contactUs=new JButton("Contact with us");
            settingPanel.add(contactUs);

            JScrollPane scrollPane = new JScrollPane(scrollablePanel);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            mainPanel.add(topPanel, BorderLayout.NORTH);
            mainPanel.add(scrollPane, BorderLayout.CENTER);
            mainPanel.add(settingPanel, BorderLayout.EAST);

            frame.add(mainPanel);
            frame.setVisible(true);
        });
    }
}









