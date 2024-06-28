import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Shop{
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
            topPanel.setBackground(Color.LIGHT_GRAY);
            JLabel title= new JLabel("let's start shop");
            title.setFont(font);
            topPanel.add(title);

            JPanel scrollablePanel = new JPanel();
            scrollablePanel.setLayout(new GridLayout(0,1,10,10));

            ImageIcon imageIcon=new ImageIcon("IMG_1767.jpg");
            JButton button=new JButton(imageIcon);

            scrollablePanel.add(button);

            for (int i = 0; i <3; i++) {
                scrollablePanel.add(new JButton("Item " + (i + 1)));
            }
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
                    mainPanel.remove(scrollablePanel);
                    mainPanel.add(shopBoxPanel, BorderLayout.CENTER);
                    mainPanel.repaint();
                    mainPanel.revalidate();

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









