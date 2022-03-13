import java.util.*;
public class Admin {

	String msg="\t编号\t姓名\t年龄\tjava\tC#\tHtml\tSql\t总分\t平局分";
	public void print(Student[] arr) {
		System.out.println(msg);
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=null){
				arr[i].setSum();
				arr[i].setAvg();
				System.out.println(arr[i]);
			}
		}

	}

	
	public boolean exist(int on,Student stu) {//判断学生是否存在
		if(stu!=null) {//  上面传进来的学生类对象与你输入编号进行对照
			if(stu.getOn()==on) {//这个只是判断当前的对象是否与int on是否一样
				return true;     //如果不一样的话下面有for循环会接着调用接着判断
			}else { 			//直到找到   编号  或者for循环结束
				return false;
			}
		}
		return false;
	}

	
	public void create(String name,int age,Student[]arr){
		Student stu=new Student();
		stu.setName(name);
		stu.setAge(age);
		int i=this.setIndex(arr);
		stu.setOn(i);
		if(i==99999){
			System.out.println("学生人数已到达最大不能添加了");
		}else{
			arr[i]=stu;
		}
		this.print(arr);
	}


	public int setIndex(Student[] arr){//返回为空的下标
		for(int i=0;i<arr.length;i++){
			if(arr[i]==null){
				return i;
			}
		}
		return 99999;
	}

	
	public void select(int on,Student[] arr) {//查询方法
		System.out.println(msg);
		for(int i=0;i<arr.length;i++) {//如果超过数组的边界 arr.lengh会约束   而且是前提
			if(this.exist(on, arr[i])==true) {//如果你出输出的编号超过边界哪儿买for循环不会执行
				System.out.println(arr[i]);//如果没有超过则会调用print方法判断是否为空
				return;
			}
		}
		System.out.println("没有这个学生存在");
	}

	
	public void update(int on,String name,int age,Student[]arr) {//不成立的条件arr  学生类数组为0或者
		for(int i=0;i<arr.length;i++) {
			if(this.exist(on, arr[i])) {
				arr[i].setName(name);
				arr[i].setAge(age);
				System.out.println("-----更新学生信息成功-----");
				this.print(arr);
				return;
			}
		}
		System.out.println("-----没有这个学生更新信息失败-----");
	}
	
	
	public void delete(int on,Student []arr){//删除学生的方法
		for(int i=0;i<arr.length;i++){
			if(this.exist(on, arr[i])){
				arr[i]=null;
				this.print(arr);
				return;
			}
		}
		System.out.println("您所指定的编号没有存在");
	}

	
	public void inport(int on,Student[]arr) {//输入学生成绩操作
		for(int i=0;i<arr.length;i++) {
			if(this.exist(on, arr[i])) {
				Scanner in=new Scanner(System.in);

				System.out.println("请输入"+arr[i].getName()+"java成绩");
				if(in.hasNextInt()) {
					arr[i].setJava(in.nextInt());
				}
				System.out.println("请输入"+arr[i].getName()+"C#成绩");
				if(in.hasNextInt()) {
					arr[i].setC_shar(in.nextInt());
				}

				System.out.println("请输入"+arr[i].getName()+"Html成绩");
				if(in.hasNextInt()) {
					arr[i].setHtml(in.nextInt());
				}
				System.out.println("请输入"+arr[i].getName()+"Sql成绩");
				if(in.hasNextInt()) {
					arr[i].setSql(in.nextInt());
				}
				this.print(arr);
				return;
			}
		}
		System.out.println("没有这个学生存在！");
	}
	
	
	public void courseSort(int num,Student[] arr) {//根据指定科目排序
		if(num==1) {
			for(int i=0;i<arr.length-1;i++){
				for(int j=i+1;j<arr.length;j++){
					if(arr[i]!=null&&arr[j]!=null){//&&arr[j]!=null
						if(arr[i].getJava()<arr[j].getJava()){
							Student stu=arr[i];
							arr[i]=arr[j];
							arr[j]=stu;
						}
					}
				}
				this.print(arr);
			}
		}else if(num==2) {
			for(int i=0;i<arr.length-1;i++){
				for(int j=i+1;j<arr.length;j++){
					if(arr[i]!=null&&arr[j]!=null){//&&arr[j]!=null
						if(arr[i].getC_shar()<arr[j].getC_shar()){
							Student stu=arr[i];
							arr[i]=arr[j];
							arr[j]=stu;
						}
					}
				}
				this.print(arr);
			}
		}else if(num==3) {
			for(int i=0;i<arr.length-1;i++){
				for(int j=i+1;j<arr.length;j++){
					if(arr[i]!=null&&arr[j]!=null){//&&arr[j]!=null
						if(arr[i].getHtml()<arr[j].getHtml()){
							Student stu=arr[i];
							arr[i]=arr[j];
							arr[j]=stu;
						}
					}
				}
				this.print(arr);
			}
		}else if(num==4) {
			for(int i=0;i<arr.length-1;i++){
				for(int j=i+1;j<arr.length;j++){
					if(arr[i]!=null&&arr[j]!=null){//&&arr[j]!=null
						if(arr[i].getSql()<arr[j].getSql()){
							Student stu=arr[i];
							arr[i]=arr[j];
							arr[j]=stu;
						}
					}
				}
			}
		}
		this.print(arr);
	}
	
	
	public void sumSort(Student[]arr){//根据总分进行排序
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]!=null&&arr[j]!=null){
					if(arr[i].getSum()<arr[j].getSum()){
						Student stu=arr[i];
						arr[i]=arr[j];
						arr[j]=stu;
					}
				}
			}
		}
		this.print(arr);
	}
}