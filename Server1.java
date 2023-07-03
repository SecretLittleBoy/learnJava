import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Server1 extends JFrame {

	private JTextField enter; // 输入文本框
	private JTextArea display; // 展示区域文本框
	PrintStream output; // 输出流
	DataInputStream input; // 输入流

	public Server1() {
		super("Server"); // 调用父类构造方法
		Container c = getContentPane();
		enter = new JTextField(); // 初始化输入文本框
		enter.addActionListener(new ActionListener() { // 为文本框添加事件监听器
			public void actionPerformed(ActionEvent e) {
				sendData(enter.getText());
			} // 将输入文本框内的字符串发送给客户端
		});
		c.add(enter, BorderLayout.NORTH); // 添加输入文本框到指定位置
		enter.setEnabled(false);
		display = new JTextArea(); // 初始化展示区域文本框
		display.setEditable(false);
		c.add(new JScrollPane(display), BorderLayout.CENTER);
		setSize(300, 150);
		setVisible(true);
	}

	private void sendData(String s) { // 将输入文本框内的字符串发送给客户端
		try {
			output.println("Server:  " + s); // 将输入文本框内的数据发送到PrintStream对象中
			output.flush(); // 将缓冲区内的数据发送给客户端
			enter.setText(""); // 清空输入文本框内容
			display.append("\nServer:  " + s); // 将输入文本框内的数据添加到展示区域文本框中
		} catch (Exception e) {
			display.append("\nError writing object");
		}
	}

	public void connect() {
		ServerSocket server; // 服务器端的Socket接口对象
		Socket socket; // 客户端的Socket接口对象
		int counter = 1; // 计数器
		try {
			// 步骤1：创建一个监听端口号为4321的服务器，并设置最大连接数为10
			server = new ServerSocket(4321, 10);
			while (true) {
				// 步骤2：等待一个客户端连接
				display.setText("等待客户端的连接\n");
				socket = server.accept(); // 等待客户端的连接
				display.append("连接" + counter + "号客户端:" + socket.getInetAddress().getHostName());
				// 步骤3：创建输入输出流对象
				output = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
				output.flush();
				input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
				// 步骤4：发送连接成功信息
				String message = "Server Connection successful!";
				output.println(message); // 将message字符串数据发送到PrintStream对象中
				output.flush(); // 将缓冲区内的数据发送给客户端
				enter.setEnabled(true);
				do {
					try {
						message = (String) input.readLine();
						/*
						 * 读取InputStream对象中的数据，也就是从服务器接收到的数据，
						 * 也就是从客户端的PrintStream对象中的数据，即客户端发送过来的消息
						 */
						display.append("\n" + message); // 在展示区域文本框显示客户端发送过来的消息
					} catch (IOException e) {
						display.append("Data Error");
					}
				} while (!message.equals("Client: end"));
				// 步骤5：关闭连接
				display.append("\n关闭连接");
				enter.setEnabled(false);
				output.close();
				input.close();
				socket.close(); // 关闭当前客户端连接，准备接受下一个客户端连接
				++counter;
			}
		} catch (EOFException eof) {
			System.out.println("Client terminated connection");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		Server1 app = new Server1();
		app.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		app.connect();
	}
}