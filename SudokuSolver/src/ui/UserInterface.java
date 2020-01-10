package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import logic.Grid;

public class UserInterface implements Runnable {

	private JFrame frame;
	private Grid theGrid;
	
	public UserInterface(Grid aGrid) {
		this.theGrid = aGrid;
	}
	
	@Override
	public void run() {
		
		frame = new JFrame("Title");
        frame.setPreferredSize(new Dimension(500, 700));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
		
	}
	
	public void createComponents(Container container) {
		GridLayout theLayout = new GridLayout(3, 1);
		container.setLayout(theLayout);
		
		JPanel theGridPanel = new JPanel(new GridLayout(9,9));
		theGridPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		for(int rowCounter=0; rowCounter<9; rowCounter++) {
			JPanel tempRowPanel = new JPanel();
			for(int squareCounter=0; squareCounter<9; squareCounter++) {
				JPanel tempSquarePanel = new JPanel();
				JTextField tempLabel = new JTextField(""+this.theGrid.getCellFromCoordinates(squareCounter, rowCounter).getNumber());
				tempSquarePanel.add(tempLabel);
				tempRowPanel.add(tempSquarePanel);
			}
			theGridPanel.add(tempRowPanel);
		}
		
		JButton solveButton = new JButton("Solve");
		JLabel headerLabel = new JLabel("Enter Sudoku Numbers");
		
		SolveListener theListener = new SolveListener();
		solveButton.addActionListener(theListener);
		
		container.add(headerLabel);
		container.add(theGridPanel);
		container.add(solveButton);
	}

}
