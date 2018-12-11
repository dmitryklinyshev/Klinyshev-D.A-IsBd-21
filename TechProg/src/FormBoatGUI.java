
import javafx.scene.control.skin.TextInputControlSkin;

import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.util.Random;
public class FormBoatGUI
{
    public MainLabaClass plane;
    public JFrame frame;
    private JPanel paint_panel;

    public FormBoatGUI() {
        initialize();
    }
    private void Draw() {
        paint_panel.repaint();
    }
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel first_panel = new JPanel();
        frame.getContentPane().add(first_panel, BorderLayout.CENTER);
        first_panel.setLayout(new BorderLayout(0, 0));
        // Create
        JPanel create_panel = new JPanel();
        create_panel.setLayout(new BorderLayout(0,0));
        first_panel.add(create_panel, BorderLayout.NORTH);

        paint_panel = new PanelForPaint();
        first_panel.add(paint_panel, BorderLayout.CENTER);

        JPanel for_control_panel = new JPanel();
        for_control_panel.setLayout(new BorderLayout(0,0));
        first_panel.add(for_control_panel, BorderLayout.SOUTH);
        //
        JButton create_button = new JButton();
        String create_string = "Create";
        create_button.setText(create_string);
        create_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rnd = new Random();
                plane = new MainLabaClass(rnd.nextInt(200) + 100, rnd.nextInt(1000) + 1000, Color.RED, Color.BLUE);
                plane.SetPosition(rnd.nextInt(90) + 100, rnd.nextInt(90) + 100, paint_panel.getWidth(), paint_panel.getHeight());
                Draw();
            }
        });
        create_panel.add(create_button, BorderLayout.WEST);
        //
        JPanel control_panel = new JPanel();
        control_panel.setLayout(new GridLayout(2, 1));
        for_control_panel.add(control_panel, BorderLayout.EAST);
        // "Up"
        JPanel up_control_panel = new JPanel();
        up_control_panel.setLayout(new FlowLayout());
        control_panel.add(up_control_panel);
        // "Left", "Down", "Right"
        JPanel down_control_panel = new JPanel();
        down_control_panel.setLayout(new FlowLayout());
        control_panel.add(down_control_panel);
        //
        int width_icon = 20;
        int height_icon = 20;
        ImageIcon up_icon = new ImageIcon("resource/images/buttonUp.png");
        Image up_image = up_icon.getImage().getScaledInstance(width_icon, height_icon, Image.SCALE_SMOOTH);
        up_icon = new ImageIcon(up_image);
        ImageIcon left_icon = new ImageIcon("resource/images/buttonLeft.png");
        Image left_image = left_icon.getImage().getScaledInstance(width_icon, height_icon, Image.SCALE_SMOOTH);
        left_icon = new ImageIcon(left_image);
        ImageIcon down_icon = new ImageIcon("resource/images/buttonDown.png");
        Image down_image = down_icon.getImage().getScaledInstance(width_icon, height_icon, Image.SCALE_SMOOTH);
        down_icon = new ImageIcon(down_image);
        ImageIcon right_icon = new ImageIcon("resource/images/buttonRight.png");
        Image right_image = right_icon.getImage().getScaledInstance(width_icon, height_icon, Image.SCALE_SMOOTH);
        right_icon = new ImageIcon(right_image);
        //
        JButton up_button = new JButton();
        up_button.setIcon(up_icon);
        up_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plane.MoveTransport(Direction.Up);
                Draw();
            }
        });
        up_control_panel.add(up_button);
        JButton left_button = new JButton();
        left_button.setIcon(left_icon);
        left_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plane.MoveTransport(Direction.Left);
                Draw();
            }
        });
        down_control_panel.add(left_button);
        JButton down_button = new JButton();
        down_button.setIcon(down_icon);
        down_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plane.MoveTransport(Direction.Down);
                Draw();
            }
        });
        down_control_panel.add(down_button);
        JButton right_button = new JButton();
        right_button.setIcon(right_icon);
        right_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plane.MoveTransport(Direction.Right);
                Draw();
            }
        });
        down_control_panel.add(right_button);
    }
}