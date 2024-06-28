import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class Shop{
    public  static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Font font=new Font("font",Font.BOLD,25);
            JFrame frame = new JFrame("online shop");
            frame.setSize(1000, 1000);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel mainPanel = new JPanel(new BorderLayout());


            JPanel topPanel = new JPanel();
            topPanel.setBackground(Color.LIGHT_GRAY);
            JLabel title= new JLabel("Online Shop");
            title.setFont(font);
            topPanel.add(title);

            JPanel scrollablePanel = new JPanel();
            scrollablePanel.setLayout(new GridLayout(0,2,10,10));

            ImageIcon imageIcon=new ImageIcon("/Users/dorsarezaei/IdeaProjects/last project/src/images");
            JButton button=new JButton(imageIcon+"first");
            scrollablePanel.add(button);

            for (int i = 0; i < 49; i++) {
                scrollablePanel.add(new JButton("Item " + (i + 1)));
            }
            JPanel settingPanel=new JPanel();
            settingPanel.setBackground(Color.LIGHT_GRAY);
            settingPanel.setLayout(new GridLayout(0,1,5,5));
            JButton profileButton=new JButton("Profile");
            settingPanel.add(profileButton);
            JButton shoppingBox=new JButton("Shopping Box");
            settingPanel.add(shoppingBox);
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









