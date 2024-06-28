import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Shop{
    public  static void main() {
        SwingUtilities.invokeLater(() -> {
            Font font=new Font("font",Font.BOLD,25);
            JFrame frame=new JFrame("OnlineShop");
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
            JPanel shopBoxPanel=new JPanel();
            shopBoxPanel.setBounds(0,0,1000,1000);
            shoppingBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.remove(mainPanel);
                    frame.add(shopBoxPanel);
                    frame.repaint();
                    frame.revalidate();
                }
            });
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









