import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private JTextArea fortuneArea;
    private ArrayList<String> fortunes;
    private int lastFortuneIndex = -1;

    public FortuneTellerFrame() {
        // Set frame title
        setTitle("Fortune Teller");

        // Set up the layout
        setLayout(new BorderLayout());

        // Call methods to build UI components
        setupTopPanel();
        setupMiddlePanel();
        setupBottomPanel();

        // Setup frame size and location
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setSize(screenSize.width * 3 / 4, screenSize.height * 3 / 4);
        setLocationRelativeTo(null);  // Center the frame
    }

    private void setupTopPanel() {
        JPanel topPanel = new JPanel();
        JLabel titleLabel = new JLabel("Fortune Teller", new ImageIcon("./resources/fortune.jpg"), JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 48));
        titleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        titleLabel.setVerticalTextPosition(SwingConstants.BOTTOM);

        topPanel.add(titleLabel);
        add(topPanel, BorderLayout.NORTH);
    }

    private void setupMiddlePanel() {
        fortuneArea = new JTextArea(10, 30);
        fortuneArea.setEditable(false);  // Prevent user from editing the text area
        fortuneArea.setFont(new Font("Serif", Font.PLAIN, 18));
        JScrollPane scrollPane = new JScrollPane(fortuneArea);

        add(scrollPane, BorderLayout.CENTER);

        // Populate fortunes
        fortunes = new ArrayList<>();
        fortunes.add("You will have a great day!");
        fortunes.add("An exciting opportunity is coming your way.");
        fortunes.add("Your future looks bright.");
        fortunes.add("Good news will arrive soon.");
        fortunes.add("Someone will make you smile today.");
        fortunes.add("You will find success in your endeavors.");
        fortunes.add("A surprise awaits you around the corner.");
        fortunes.add("You will meet someone important today.");
        fortunes.add("Luck will be on your side.");
        fortunes.add("A positive change is coming.");
        fortunes.add("You will accomplish something big.");
        fortunes.add("Great things are in store for you.");
    }

    private void setupBottomPanel() {
        JPanel bottomPanel = new JPanel();

        JButton readFortuneButton = new JButton("Read My Fortune!");
        readFortuneButton.setFont(new Font("Serif", Font.BOLD, 24));
        readFortuneButton.addActionListener(e -> displayFortune());

        JButton quitButton = new JButton("Quit");
        quitButton.setFont(new Font("Serif", Font.BOLD, 24));
        quitButton.addActionListener(e -> System.exit(0));

        bottomPanel.add(readFortuneButton);
        bottomPanel.add(quitButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void displayFortune() {
        Random random = new Random();
        int newIndex;

        do {
            newIndex = random.nextInt(fortunes.size());
        } while (newIndex == lastFortuneIndex);

        String fortune = fortunes.get(newIndex);
        fortuneArea.append(fortune + "\n");

        lastFortuneIndex = newIndex;
    }
}
