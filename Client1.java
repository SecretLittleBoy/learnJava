import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Client1 extends JFrame {

	private JTextField enter; // 输入文本框
	private JTextArea display; // 展示区域文本框
	PrintStream output; // 输出流
	DataInputStream input; // 输入流
	String message = "";

	public Client1() {
		super("Client");
		Container c = getContentPane();
		enter = new JTextField(); // 初始化输入文本框
		enter.setEnabled(false);
		enter.addActionListener(new ActionListener() { // 为输入文本框添加监听器
			public void actionPerformed(ActionEvent e) {
				sendData(enter.getText()); // 获取输入文本框中的数据
			}
		});
		c.add(enter, BorderLayout.NORTH); // 将输入文本框添加到指定位置
		display = new JTextArea(); // 初始化展示区域文本框
		c.add(new JScrollPane(display), BorderLayout.CENTER);
		setSize(300, 150);
		show();
	}

	public void connect() {
		Socket socket; // 客户端的Socket对象
		try {
			// 步骤1：连接到服务器，地址为127.0.0.1，端口为4321
			display.setText("准备连接...\n");
			socket = new Socket(InetAddress.getByName(""), 4321);
			display.append("连接到:" + socket.getInetAddress().getHostName());
			// 显示服务器名称
			display.append("\n服务器IP为:" + socket.getInetAddress().toString());
			// 显示服务器IP地址
			// 步骤2：创建输入/输出流
			output = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
			output.flush();
			input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			// 步骤3：实现通信，接收并显示服务器发送的消息
			enter.setEnabled(true);
			do {
				try {
					message = (String) input.readLine();
					// 读取输入流中的数据，也就是从服务器的PrintStream对象中的数据，即服务器发送过来的消息
					display.append("\n" + message); // 将服务器发送的消息添加到展示区域文本框
				} catch (IOException e) {
					display.append("\n无法接收消息");
				}
			} while (!message.equals("Server:  end")); // 当服务器发送消息"end"时，通信结束
			// 步骤4：关闭连接
			display.append("\n关闭连接");
			output.close();
			input.close();
			socket.close();
		} catch (EOFException eof) {
			System.out.println("服务器断开连接");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void sendData(String s) { // 将客户端的数据发送给服务器
		try {
			message = s;
			output.println("Client:  " + s); // 将输入文本框中的数据发送到PrintStream对象中
			output.flush();
			enter.setText("");
		} catch (Exception e) {
			display.append("\n数据发送错误");
		}
	}

	public static void main(String args[]) {
		Client1 app = new Client1();
		app.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		app.connect();
	}
}