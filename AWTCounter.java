import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class AWTCounter extends Frame implements ActionListener
{
private Label lblCount;
private TextField tfCounts;
private TextField tfCounte;
private TextField tfCount;
private TextField tfOutput;
private TextField tfOpen;
private TextField tfC;
private Button btnCount;
private Button btnadd;
private Button exit;
private int count = 0;
public AWTCounter ()
{
setLayout(new FlowLayout());
add(new Label("Search From: "));
tfCounts = new TextField(count + "", 15);
add(tfCounts); 
add(new Label("Upto : "));
tfCounte = new TextField(count + "", 15);
add(tfCounte);
lblCount = new Label("HOSTName :");
add(lblCount); 
tfCount = new TextField(30);
tfCount.setEditable(false);
add(tfCount); 

tfOutput = new TextField(10);
tfOutput.setEditable(false);


tfOpen = new TextField(15);
tfOpen.setEditable(false);

tfC = new TextField(15); 
tfC.setEditable(false);

btnCount = new Button("Hostname");
add(btnCount); 
btnadd= new Button("Detailed Report");
add(btnadd);
exit= new Button("EXIT");
add(exit);
btnCount.addActionListener(this);
btnadd.addActionListener(this);
exit.addActionListener(this);
setTitle("PROJECT");
setSize(250, 400);
setVisible(true);}
private static boolean isPortInUse(String hostName, int portNumber) 
{
boolean result;
try 
{
Socket s = new Socket(hostName, portNumber);
s.close();
result = true;
}
catch(Exception e)
{
result = false;
}
return(result);
}
public class MyTable extends JFrame implements ActionListener 
{
private JTable table;
private DefaultTableModel model;
private JButton addButton; 
public MyTable() {
table = new JTable(0,4); 
model = (DefaultTableModel) table.getModel();
JScrollPane tablePanel = new JScrollPane(table);
addButton = new JButton("Get LIVE Data");
addButton.addActionListener(this);
JPanel buttonPanel = new JPanel();
buttonPanel.add(addButton); 
setLayout(new BorderLayout());
add(tablePanel);
add(buttonPanel, BorderLayout.PAGE_END);
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
pack();
setVisible(true);
}
public void actionPerformed(ActionEvent et) 
{
if(et.getSource() == addButton) 
{
boolean a;
InetAddress ip ;
String hostname="null";
try 
{
ip = InetAddress.getLocalHost();
hostname = ip.getHostName();
System.out.println("Your current IP address : " + ip);
System.out.println("Your current Hostname : " + hostname);
} 
catch (UnknownHostException e) 
{
e.printStackTrace();
}
int sv= Integer.parseInt(tfCounts.getText());
int stv = Integer.parseInt(tfCounte.getText());
tfCount.setText(hostname + ""); 
for(int i=sv;i<stv;i++)
{             a=isPortInUse(hostname,i);
              System.out.println("result:" + a + i);
              if(a==true)
              { tfOutput.setText(i + "");
                   if(i==53)
                   {tfOpen.setText("DNS");} 
                   if(i==80)
                   {tfOpen.setText("HTTP for Web");} 
                   if(i==443)
                   {tfOpen.setText("HTTPS for Web(Secure)");}
                   if(i==20||i==21)
                   {tfOpen.setText("FTP for File Transfer");}
                   if(i==22)
                   {tfOpen.setText("SFTP For Secured File Transfer");}
                   if(i==989||i==990)
                   {tfOpen.setText("FTPS File Transfer(secure)");}
                   if(i==25)
                   tfOpen.setText("SMTP For Internet Mail");
                   if(i==110)
                   tfOpen.setText("POP3 For POP Mailbox"); 
                   if(i==143)
                   tfOpen.setText("IMAP For IMAP mailbox"); 
                   if(i==23)
                   tfOpen.setText("Telnet for Remote Login");
                   if(i==22)
                   tfOpen.setText("SSH For Secured Remote login"); 
                   if(i==119)
                   tfOpen.setText("NNTP for Usenet newsgroups");
                   if(i==563)
                   tfOpen.setText("NNTPS For Secured Usenet");
                   if(i==194)
                   tfOpen.setText("IRC For Chat");
                   if(i==123)
                   tfOpen.setText("NTP FOR Network Time of Day");
                   if(i==161||i==162)
                   tfOpen.setText("SNMP for Network management");
                   if(i==163||i==164)
                   tfOpen.setText("CMIP for Network management"); 
                   if(i==514)
                   tfOpen.setText("Syslog For Event Logging");
                   if(i==88)
                   tfOpen.setText("Kerberos For Authentication"); 
                   if(i==137||i==138||i==139)
                   tfOpen.setText("NetBIOS For DOS/Windows naming");
                    if(i>1024)
                    tfOpen.setText("-");
                   if(i==5060)
                   tfOpen.setText("SIP For VoIP(internet phone)");
                   Update("new Row text"); 
                  } 
          }
}
}
public void Update(String neu) 
{      Date date = new Date();
       String data;
       data=date.toString();
       model.addRow(new String[] {tfCount.getText(),tfOutput.getText(),tfOpen.getText(),data}); 
  }
}
public static void main(String[] args) 
{
AWTCounter app = new AWTCounter();
}
@Override
   public void actionPerformed(ActionEvent evt)
  { if(evt.getSource()==btnCount)
     {     boolean a;
        InetAddress ip ;


        String hostname="null";
        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            System.out.println("Your current IP address : " + ip);
            System.out.println("Your current Hostname : " + hostname);
            } 
        catch (UnknownHostException e) 
           {

            e.printStackTrace();
           }
int sv= Integer.parseInt(tfCounts.getText()); 
int stv = Integer.parseInt(tfCounte.getText());
tfCount.setText(hostname + ""); 
       int tru=0;
            for(int i=sv;i<stv;i++)
            {
              a=isPortInUse(hostname,i);
              System.out.println("result:" + a + i);
              if(a==true)
              { 
                tru++; 
                tfOutput.setText(i + "");
                   if(i==53)
                   {tfOpen.setText("DNS");} 
                   if(i==80)
                   {tfOpen.setText("HTTP for Web");} 
                   if(i==443)
                   {tfOpen.setText("HTTPS for Web(Secure)");}
                   if(i==20||i==21)
                   {tfOpen.setText("FTP for File Transfer");}
                   if(i==22)
                   {tfOpen.setText("SFTP For Secured File Transfer");}
                   if(i==989||i==990)
                   {tfOpen.setText("FTPS File Transfer(secure)");}
                   if(i==25)
                   tfOpen.setText("SMTP For Internet Mail");
                   if(i==110)
                   tfOpen.setText("POP3 For POP Mailbox"); 
                   if(i==143)
                   tfOpen.setText("IMAP For IMAP mailbox"); 
                   if(i==23)
                   tfOpen.setText("Telnet for Remote Login");
                   if(i==22)
                   tfOpen.setText("SSH For Secured Remote login"); 
                   if(i==119)
                   tfOpen.setText("NNTP for Usenet newsgroups");
                   if(i==563)
                   tfOpen.setText("NNTPS For Secured Usenet");
                   if(i==194)
                   tfOpen.setText("IRC For Chat");
                   if(i==123)
                   tfOpen.setText("NTP FOR Network Time of Day");
                   if(i==161||i==162)
                   tfOpen.setText("SNMP for Network management");
                   if(i==163||i==164)
                   tfOpen.setText("CMIP for Network management"); 
                   if(i==514)
                   tfOpen.setText("Syslog For Event Logging");
                   if(i==88)
                   tfOpen.setText("Kerberos For Authentication"); 
                   if(i==137||i==138||i==139)
                   tfOpen.setText("NetBIOS For DOS/Windows naming");
                    if(i>1024)
                    tfOpen.setText("-"); 
                   if(i==5060)
                   tfOpen.setText("SIP For VoIP(internet phone)"); 
                    } 
                   tfC.setText(tru + " ");
   }
}
if(evt.getSource()==btnadd)
     { new MyTable();

}
if(evt.getSource()==exit)
     { System.exit(0);

}

}    
}
