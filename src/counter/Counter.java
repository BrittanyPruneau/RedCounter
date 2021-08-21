package counter;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

/**
 * Displays a GUI which includes a button and a counter. The button changes the
 * background to a random color of 5 colors and counts the number of times the
 * color red is displayed.
 * 
 * @author Brittany Pruneau
 *
 */
public class Counter extends JFrame
{

	private JPanel contentPane;
	private int temp = (int) Math.floor(Math.random() * 6) + 1;
	private int count;

	/*
	 * Launch's the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Counter frame = new Counter();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Creates the look and functionality of the GUI.
	 */
	public Counter()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lblRedCounter = new JLabel("Red Counter: 00");
		lblRedCounter.setPreferredSize(new Dimension(200, 20));
		nameLabel();
		redCounter(lblRedCounter);
		buttonChangesColors(lblRedCounter);
	}

	/*
	 * Generates a random number that is different from the previous number.
	 */
	public int getRandomColor()
	{
		int n = (int) Math.floor(Math.random() * 5) + 1;

		if (n == temp)
		{
			int s = getRandomColor();
			n = s;
		}
		this.temp = n;

		return n;
	}

	/*
	 * Keeps track of the number of times the red background is displayed 
	 * and changes the text to Red: {count}; 
	 */
	private void counter(int n, JLabel lblRedCounter)
	{
		if (n == 1)
		{
			this.count = count + 1;
			lblRedCounter.setText("Red: 0" + count);
		}
	}

	/*
	 * Responds to a click of the button by changing the background to a random color
	 * of 5 different specified colors. 
	 */
	private void buttonChangesColors(JLabel lblRedCounter)
	{
		JButton btnChangeColors = new JButton("Click Me");
		btnChangeColors.setMinimumSize(new Dimension(0, 0));
		btnChangeColors.setPreferredSize(new Dimension(0, 0));
		btnChangeColors.setHorizontalTextPosition(SwingConstants.CENTER);
		btnChangeColors.setForeground(Color.WHITE);
		btnChangeColors.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int n = getRandomColor();
				counter(n, lblRedCounter);
				if (n == 1)
				{
					btnChangeColors.setBackground(Color.RED);
				}
				if (n == 2)
				{
					btnChangeColors.setBackground(Color.BLUE);
				}
				if (n == 3)
				{
					btnChangeColors.setBackground(Color.GREEN);
				}
				if (n == 4)
				{
					btnChangeColors.setBackground(Color.ORANGE);
				}
				if (n == 5)
				{
					btnChangeColors.setBackground(Color.MAGENTA);
				}
			}
		});
		btnChangeColors.setFont(new Font("Tahoma", Font.PLAIN, 33));
		btnChangeColors.setBackground(Color.BLUE);
		contentPane.add(btnChangeColors, BorderLayout.CENTER);
	}

	/*
	 * Displays a label {Name}'s GUI 
	 */
	private void nameLabel()
	{
		{
			JLabel lblName = new JLabel("Brittany's GUI");
			lblName.setPreferredSize(new Dimension(62, 38));
			lblName.setOpaque(true);
			lblName.setBackground(SystemColor.controlHighlight);
			lblName.setHorizontalAlignment(SwingConstants.CENTER);
			lblName.setFont(new Font("Arial", Font.BOLD, 19));
			contentPane.add(lblName, BorderLayout.SOUTH);
		}
	}

	/*
	 * Displays the look of the red counter label. 
	 */
	private void redCounter(JLabel lblRedCounter)
	{
		lblRedCounter.setOpaque(true);
		lblRedCounter.setBackground(SystemColor.activeCaptionBorder);
		lblRedCounter.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 26));
		lblRedCounter.setText("Red: 00");

		lblRedCounter.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblRedCounter, BorderLayout.WEST);
	}
}
