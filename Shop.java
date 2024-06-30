import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Shop {
    private String username;
    private Frame frame;
    private File file;
    private File shopFile=new File("shopFile.txt");
    private ArrayList<String> products=new ArrayList<>();
    Shop(String username,Frame frame,File file){
        this.username=username;
        this.frame=frame;
        this.file=file;
    }
    public void startShopping() {
        SwingUtilities.invokeLater(() -> {
            try {
                FileWriter fileWriter=new FileWriter(shopFile,true);
                FileReader fileReader=new FileReader(shopFile);
                BufferedReader reader=new BufferedReader(fileReader);
                BufferedWriter writer=new BufferedWriter(fileWriter);
                String line=reader.readLine();
                Boolean flag=false;

                // checking if user added to file or not
                while (line!=null){
                    if(line.contains(username)){
                        flag=true;
                    }
                    line= reader.readLine();
                }
                if(!(flag)){
                    writer.write("\n");
                    writer.write(username+":");
                }
                writer.close();
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Font font=new Font("font",Font.BOLD,25);
            JFrame frame = new JFrame("online shop");
            frame.setSize(1000, 1000);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel mainPanel = new JPanel(new BorderLayout());
            JPanel topPanel = new JPanel();
            JPanel shopBoxPanel=new JPanel();
            shopBoxPanel.setLayout(null);


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
            JButton shopButton1=new JButton("Add it to shopping box");
            shopButton1.setFont(font);
            shopButton1.setBounds(320,400,400,100);
            JButton backButton=new JButton("Back");
            backButton.setFont(font);
            backButton.setBounds(470,700,100,50);
            firstPanel.add(label);
            firstPanel.add(backButton);
            firstPanel.add(shopButton1);
            scrollablePanel.add(firstProduct);
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
            shopButton1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        products=addToShopBox("pink");
                        JLabel doneShopping=new JLabel("this product successfully added to your shop box");
                        doneShopping.setBounds(500,900,100,80);
                        firstPanel.add(doneShopping);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
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
            profileButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.remove(mainPanel);
                    Profile profile=new Profile(frame,file,username,mainPanel);
                    profile.setprofile();
                }
            });
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
            JButton search=new JButton("Search");
            settingPanel.add(search);
            search.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JPanel searchpanel=new JPanel();
                    searchpanel.setLayout(null);
                    searchpanel.setBounds(0,0,1000,1000);
                    JTextField searchField=new JTextField("");
                    searchField.setBounds(350,100,400,100);
                    searchpanel.add(searchField);
                    JButton enterbutt=new JButton("Enter");
                    enterbutt.setBounds(800,100,200,50);
                    enterbutt.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String search=searchField.getText();
                            // for searching button we get the name of product of textField then compare it to every product
                            if(search.contains("pink")){
                                firstProduct.setBounds(300,400,300,300);
                                firstProduct.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        frame.remove(searchpanel);
                                        frame.repaint();
                                        frame.revalidate();
                                    }
                                });
                                searchpanel.add(firstProduct);
                                frame.repaint();
                                frame.revalidate();
                            }
                            else if (search.contains("lemon")){
                                secondProduct.setBounds(300,400,300,300);
                                secondProduct.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        frame.remove(searchpanel);
                                        frame.repaint();
                                        frame.revalidate();
                                    }
                                });
                                searchpanel.add(secondProduct);
                                frame.repaint();
                                frame.revalidate();
                            }
                            else if (search.contains("orange")){
                                fifthProduct.setBounds(300,400,300,300);
                                fifthProduct.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        frame.remove(searchpanel);
                                        frame.repaint();
                                        frame.revalidate();
                                    }
                                });
                                searchpanel.add(fifthProduct);
                                frame.repaint();
                                frame.revalidate();
                            }
                            else if (search.contains("minit")){
                                thirdProduct.setBounds(300,400,300,300);
                                thirdProduct.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        frame.remove(searchpanel);
                                        frame.repaint();
                                        frame.revalidate();
                                    }
                                });
                                searchpanel.add(thirdProduct);
                                frame.repaint();
                                frame.revalidate();
                            }
                            else if (search.contains("purple")){
                                fourthProduct.setBounds(300,400,300,300);
                                fourthProduct.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        frame.remove(searchpanel);
                                        frame.repaint();
                                        frame.revalidate();
                                    }
                                });
                                searchpanel.add(fourthProduct);
                                frame.repaint();
                                frame.revalidate();
                            }

                        }
                    });
                    searchpanel.add(enterbutt);
                    frame.remove(mainPanel);
                    frame.add(searchpanel);
                    frame.repaint();
                    frame.revalidate();

                    JButton backsearch=new JButton("Back");
                    backsearch.setBounds(800,155,200,50);
                    backsearch.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            frame.remove(searchpanel);
                            frame.add(mainPanel);
                            frame.repaint();
                            frame.revalidate();
                        }
                    });
                    searchpanel.add(backsearch);
                }
            });
            // make panel scrollable
            JScrollPane scrollPane = new JScrollPane(scrollablePanel);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            mainPanel.add(topPanel, BorderLayout.NORTH);
            mainPanel.add(scrollPane, BorderLayout.CENTER);
            mainPanel.add(settingPanel, BorderLayout.EAST);

            frame.add(mainPanel);
            frame.setVisible(true);
        });
    }
    // make a arrayList of products user has bought
    public ArrayList<String> addToShopBox(String toBuy) throws IOException {
        FileReader reader=new FileReader(shopFile);
        BufferedReader bufferedReader=new BufferedReader(reader);
        FileWriter fileWriter=new FileWriter(shopFile,true);
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
        ArrayList<String> usersArray=new ArrayList<>();
        Scanner scanner=new Scanner(shopFile);
        String line = scanner.nextLine();
        while (scanner.hasNext()){
            line=scanner.nextLine();
            if(line.contains(""+username)){
                bufferedWriter.write(toBuy+":");
                usersArray.add(toBuy);
            }

        }
        bufferedWriter.close();
        bufferedReader.close();
        return usersArray;
    }
}







































