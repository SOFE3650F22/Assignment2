import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Cashier implements ActionListener{
    
    //initializing variables
    private static JPanel panel;
    private static JFrame frame;
    private static JLabel label, payment, price, items, itemPrice, removeCode, finalBill, bill, finalPrice;
    private static JButton scanitem, debit, credit, start, remove;
    private static JTextField scanText, removeText;

    private static Ticket tick = new Ticket();
    private static Scanner scan = new Scanner();
    private static String totalPrice = "0";
    private static String currentBill = "";

    public static void main(String []args) {

        //GUI Framework
        panel = new JPanel();
        frame = new JFrame();
        frame.setSize(1500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);

        panel.setLayout(null);

        label = new JLabel("Scan Item");
        label.setBounds(10,20,80,25);
        panel.add(label);

        removeCode = new JLabel("Remove Item");
        removeCode.setBounds(10,60,80,25);
        panel.add(removeCode);

        payment = new JLabel("Payment Options");
        payment.setBounds(350,20,100,25);
        panel.add(payment);

        scanText = new JTextField(20);
        scanText.setBounds(100,20,165,25);
        panel.add(scanText);

        removeText = new JTextField(20);
        removeText.setBounds(100,60,165,25);
        panel.add(removeText);

        scanitem = new JButton("Scan");
        scanitem.setBounds(10, 100, 80, 25);
        panel.add(scanitem);

        remove = new JButton("Remove Item");
        remove.setBounds(110, 100, 110, 25);
        panel.add(remove);

        start = new JButton("Start Program");
        start.setBounds(10, 300, 120, 25);
        start.addActionListener(new Cashier());
        panel.add(start);

        debit = new JButton("Debit");
        debit.setBounds(350, 80, 80, 25);
        panel.add(debit);

        credit = new JButton("Credit");
        credit.setBounds(450, 80, 80, 25);
        panel.add(credit);

        items = new JLabel("");
        items.setBounds(10,160,300,25);
        panel.add(items);

        itemPrice = new JLabel("");
        itemPrice.setBounds(10,210,300,25);
        panel.add(itemPrice);

        price = new JLabel("");
        price.setBounds(10,130,50,25);
        panel.add(price);

        bill = new JLabel("Ticket");
        bill.setBounds(250,165,300,25);
        panel.add(bill);

        finalBill = new JLabel("");
        finalBill.setBounds(250,200,1400,25);
        panel.add(finalBill);

        finalPrice = new JLabel("");
        finalPrice.setBounds(250,250,50,25);
        panel.add(finalPrice);

        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        ActionListener buttonListener = new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                //Every time the Scan button is pressed, it is added to the cart
                String barcode = scanText.getText();
                String currentItem[] = scan.match(barcode, totalPrice);
                totalPrice = currentItem[2];
                price.setText("$" + totalPrice);
                items.setText(currentItem[1]);
                itemPrice.setText("$" + currentItem[0]);

                currentBill = tick.ticketRecord(currentItem[1], currentItem[0], currentBill);
            }
        };

        ActionListener buttonListener2 = new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                //when the user presses on payment method, they have paid for the items and a ticket will be printed
                JOptionPane.showMessageDialog(panel, "Your payment is successful! You Ticket has been printed");
                finalBill.setText("Items" + "\n" + currentBill);
                finalPrice.setText("$" + totalPrice);
            }
        };

        ActionListener buttonListener3 = new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        };

        scanitem.addActionListener(buttonListener);
        debit.addActionListener(buttonListener2);
        credit.addActionListener(buttonListener2);
    }
}