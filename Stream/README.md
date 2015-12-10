
  在java程序中，将整个对象存储至文件，在下一次程序运行
时，可以从文件中读出数据并还原为对象．
使用java.io.ObjectInputStream 和java.io.ObjectOutputStream
来完成．
  如果要直接存储对象，定义该对象的类必须实现java.io.Serializable
接口，不过Serializable接口中并没有规范任何必须实现的方法，所以这
里所谓实现的意义，其实像是对对象贴上一个标志，代表该对象是可序列
化的(Serializable)．
　


实现一个User类，为说明如何直接存储对象准备．
public class User implements Serializable{
	private static final long serialVersionUID = 1L;	

	private String name;
	private int number;

	public void User(){
		
	}

	public void User(String name, int number){
		this.name = name;
		this.number = number;
	}

	public void setName(String name){
		this.name = name;
	}

	public void setNumber(int number){
		this.number = number;
	}

	public String getName(){
		return name;
	}

	public String getNumber(){
		return number;
	}
}







