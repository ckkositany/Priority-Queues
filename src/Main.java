import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // Create the main window (frame)
        JFrame frame = new JFrame("Shortest Path Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Get screen dimensions
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Set frame size to half screen width and 3/4 screen height
        int frameWidth = screenWidth / 2;
        int frameHeight = (3 * screenHeight) / 4;
        frame.setSize(frameWidth, frameHeight);

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        // Set layout
        frame.setLayout(new BorderLayout());

        // Create components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel startLocationLabel = new JLabel("Enter Start Location: (A, B, C, D) ");
        JTextField startLocationField = new JTextField();

        JButton calculateButton = new JButton("Calculate Shortest Path");

        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        // Add components to the panel
        panel.add(startLocationLabel);
        panel.add(startLocationField);
        panel.add(calculateButton);
        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Example graph initialization
        Graph graph = new Graph();
        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 10);
        graph.addEdge("B", "C", 2);
        graph.addEdge("B", "D", 4);
        graph.addEdge("C", "D", 1);

        // Button action listener for calculating shortest path
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String startLocation = startLocationField.getText().toUpperCase(); // Normalize input

                // Validate input
                if (startLocation.isEmpty()) {
                    resultArea.setText("Please enter a start location.");
                    return;
                }

                if (!graph.getAdjacencyList().containsKey(startLocation)) {
                    resultArea.setText("Error: Start location not found in the graph.");
                    return;
                }

                // Calculate shortest paths from the start location
                Map<String, Integer> shortestPaths = Dijkstra.calculateShortestPath(graph, startLocation);

                // Display the results
                StringBuilder resultText = new StringBuilder();
                resultText.append("Shortest paths from " + startLocation + ":\n");
                for (Map.Entry<String, Integer> entry : shortestPaths.entrySet()) {
                    resultText.append("To " + entry.getKey() + ": " + entry.getValue() + "\n");
                }
                resultArea.setText(resultText.toString());
            }
        });

        // Show the frame
        frame.setVisible(true);
    }
}
