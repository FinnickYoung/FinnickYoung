package com.finn.start;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * 各种问题的验证和繁化简的简便方法
 *
 * @author yunzhen.yang(yz.zhen)
 */
public class TestReA8A103 {

    @JSONField(name = "NAME")
    private String nameString = "张三";

    @JSONField(name = "SALARY")
    private BigDecimal salary = new BigDecimal(1000000);

    @JSONField(name = "AGE")
    private int age;

    @JSONField(name = "ELNINO")
    private String ElNino;

    @JSONField(name = "STARTTIME")
    private LocalDateTime startTime;

    @JSONField(name = "Boolean")
    private Boolean boo;

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public String getNameString() {
        return nameString;
    }

    public int getAge() {
        return age;
    }

    public void setNameString(String nameString) {
        this.nameString = nameString;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public BigDecimal setSalary(BigDecimal salary) {
        return salary.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public String getElNino() {
        return ElNino;
    }

    public void setElNino(String elNino) {
        ElNino = elNino;
    }

    public Boolean getBoo() {
        return boo;
    }

    public void setBoo(Boolean boo) {
        this.boo = boo;
    }

    @Override
    public String toString() {
        return "com.finn.start.TestReA8A103 [nameString=" + nameString + ", salary=" + salary + ", age=" + age + ", ElNino=" + ElNino + ", startTime=" + startTime
                + "]";
    }

    private static final String DATE_FORMAT_2MS_Digits = "yyyy-MM-dd'T'HH:mm:ss.SS'Z'";

    private static DateFormat dateFormat2MsDigits = new SimpleDateFormat(DATE_FORMAT_2MS_Digits);

    /**
     * main+Tab 直接生成Main方法。
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

//        replaceFunc();

//        System.out.println(isValid(" {} {{{}}} ({}) (){{{}}}"));

        getSerialNo("C13C4WBR3052321200735,B,TRUE$,,0;$,;$@C13C4WAR4012321100494,TRUE;");

//        useEatable((x,y) -> {
//            System.out.println(x+y);
//            return x+y;
//        });
    }


    private static void useEatable(LambdaAble lambdaAble) {
//        lambdaAble.eat();
        lambdaAble.add(1, 2);
//        lambdaAble.fly("");

    }

    /**
     * 巧妙的解决方式
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        int length = s.length() / 2;
        for (int i = 0; i < length; i++) {
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        }

        return s.trim().length() == 0;
    }

    //C13C2WAR2022311400376,A,FALSE$,,0;,,0;$100006299,0.000;100000321,0.000;$@C13C2WBR2012311500506,B,FALSE$$$@
    public static String getSerialNo(String V_SERIALSLIST) {
        final String C_FLAG0 = "@";
        final String C_FLAG1 = "$";
        final String C_FLAG2 = ",";
        final String C_FLAG3 = ";";


        String V_SERIALINFO;
        String V_SINGLESERIAL;
        String V_PARTINFO;
        String V_MATINFO;
        String V_SERILANO;
        String V_PRODUCTTYPE;
        String V_PASSFLAG;
        String V_SERIALNOSLIST;
        System.out.println("V_SERIALSLIST::" + V_SERIALSLIST);

        V_SINGLESERIAL = V_SERIALSLIST.substring(0, V_SERIALSLIST.indexOf(C_FLAG0));

        V_SERIALSLIST = V_SERIALSLIST.substring(V_SERIALSLIST.indexOf(C_FLAG0) + 1);

        V_SERIALINFO = V_SINGLESERIAL.substring(0, V_SINGLESERIAL.indexOf(C_FLAG1));

        V_SINGLESERIAL = V_SINGLESERIAL.substring(V_SINGLESERIAL.indexOf(C_FLAG1) + 1);

        V_PARTINFO = V_SINGLESERIAL.substring(1, V_SINGLESERIAL.indexOf(C_FLAG1));
        System.out.println("V_PARTINFO:" + V_PARTINFO);
        //零部件信息

        V_SINGLESERIAL = V_SINGLESERIAL.substring(V_SINGLESERIAL.indexOf(C_FLAG1) + 1);


        V_MATINFO = V_SINGLESERIAL.substring(0, V_SINGLESERIAL.indexOf(C_FLAG1));
        System.out.println("V_MATINFO:" + V_MATINFO);
        V_SINGLESERIAL = V_SINGLESERIAL.trim();

        //------------------------


        V_SERILANO = V_SERIALINFO.substring(0, V_SERIALINFO.indexOf(C_FLAG2));

        V_SERIALINFO = V_SERIALINFO.substring(V_SERIALINFO.indexOf(C_FLAG2) + 1);

        V_PRODUCTTYPE = V_SERIALINFO.substring(0, V_SERIALINFO.indexOf(C_FLAG2));

        System.out.println("V_PRODUCTTYPE:" + V_PRODUCTTYPE);
        V_SERIALINFO = V_SERIALINFO.substring(V_SERIALINFO.indexOf(C_FLAG2) + 1);

        V_PASSFLAG = V_SERIALINFO;
        V_SINGLESERIAL = V_SINGLESERIAL.trim();
        System.out.println("V_SINGLESERIAL:" + V_SINGLESERIAL);

        V_SERIALNOSLIST = V_SERIALSLIST + V_SERILANO + C_FLAG2 + V_PASSFLAG + C_FLAG3;

        System.out.println("V_SERIALNOSLIST:" + V_SERIALNOSLIST);

        return V_SERIALNOSLIST;
    }

    /**
     * //异或运算 是基于电路中的正负电荷运算的
     * //相同为0 不同为1；结合到计算机中就是二进制的位运算
     * //10^01 = 11  11^11 = 00；
     * 例子：8^9 = (4+2+0) ^ (4+2+1) = 110^111 = 001 = 1；
     *
     * @param i
     * @param j
     * @return
     */
    private static Integer XORGate(int i, int j) {
        //i ^= i 相当于自己和自己异或  一定等于0；
        return i ^ j;
    }

    /**
     * 与非门（全1为0，有0为1）  其实有点像java中的||运算 只不过是反向的
     * 或非门（全0为1，有1为0）
     *
     * @param i
     * @param j
     * @return
     */
    private static Integer NANDGate(int i, int j) {
        //i ^= i 相当于自己和自己异或  一定等于0；
        return i ^ j;
    }


    /**
     * 关于时间和控件复杂度的认知：
     * 一般使用O（N^2）这种形式来表达 而且一般作用于 !循环! 用来表达在未知次数上的方法运行所需要的时间
     * <p>
     * 例如一个方法需要运行2*N^2 +2*N +10次  那么这个方法所需要的时间复杂度为O（N^2）（仅保留最高阶指数）
     * 但是如果是一个确定时间的比如说这个方法必定只会循环一百次  那么他的空间复杂度为O(1)）（常数全部视为1）
     * 两次未知次数的循环M+N次 那么时间复杂度需要O(M+N) 但这其中有一个问题：M ~= N 时 视为O（N）
     * 但是M>>N时 视为O（M） 反之视为O（N） （时间复杂度的不确定值可为多个）
     * <p>
     * 复杂度对比：
     * O(n!) > O(2n) > O(n2) > O(nlog2n) > O(n) > O(log2n) > O(1) （基本就是数学中的N趋向于无穷大时的数值比较）
     */


    //2.创建一个求出BMI指数的getBMI方法，返回值类型使用void
    public static void getBMI(double height, double weight) {
//2.1定义bmi变量来保存根据提供的BMI指数公式求出BMI指数
        double bmi = weight / (height * height);
//2.2定义一个String字符串类型的变量r来接受BMI指数范围结果
        String r = "";
//2.3用if...else...语句根据BMI指数范围，来给r想赋值
        if (bmi < 18.5) {
            r = "过轻";
        }
        else if (bmi <= 22.9 && bmi >= 18.5) {
            r = "正常";
        }
        else if (bmi <= 24.9 && bmi >= 23) {
            r = "偏胖";
        }
        else if (bmi <= 29.9 && bmi >= 25) {
            r = "肥胖";
        }
        else if (bmi <= 39.9 && bmi >= 30) {
            r = "重度肥胖";
        }
        else if (bmi > 40) {
            r = "极度肥胖";
        }
//2.4打印输出最终结果
//你的BMI体重指数：xxx
        System.out.println("您的BMI指数是：" + bmi);
//你的体重属于：xx
        System.out.println("您的体重属于：" + r);
    }


    private static void getBMI() {
        //1.提示并接受用户输入的身高与体重信息，此处直接使用匿名对象创建Scaner对象
        System.out.println("请输入您的身高（单位：m）:");
//接受身高信息数据
        double height = new Scanner(System.in).nextDouble();//使用链式编程
        System.out.println("请输入您的体重（单位：kg）:");
//接受体重信息数据
        double weight = new Scanner(System.in).nextDouble();//使用链式编程
//3.主方法中调用getBMI()方法，根据身高和体重信息，输出结果
        getBMI(height, weight);
    }

    private static Boolean isSameDay(LocalDateTime time1, LocalDateTime time2) {
        String t1 = time1.toString();
        String t2 = time2.toString();
        return t1.substring(0, 11).equals(t2.substring(0, 11));

    }

    public static String insertStr(String str, int n) {
        StringBuilder newStr = new StringBuilder(str);
        newStr.insert(n, "=");
        return newStr.toString();
    }

    public static String replaceFunc() {

        String str1 = "ABC ABC abc abc 123 123";
        //只会替换第一个符合的字符
        System.out.println(str1.replaceFirst("B", "*"));
        //会替换素有符合的字符
        System.out.println(str1.replace("B", "*"));
        /**
         * 根据正则表达式进行替换
         * \w 匹配字母或数字或下划线或汉字 等价于 '[^A-Za-z0-9_]'
         * \s 匹配任意的空白符
         * \d 匹配数字
         * \b 匹配单词的开始和结束
         * ^ 匹配字符串的开始
         * $ 匹配字符串的结束
         */
        System.out.println(str1.replaceAll("\\w", "*"));
        System.out.println(str1.replaceAll("\\s", "*"));
        System.out.println(str1.replaceAll("\\d", "*"));
        System.out.println(str1.replaceAll("\\b", "*"));
        System.out.println(str1.replaceAll("^", "*"));
        System.out.println(str1.replaceAll("$", "*"));
        return "";
    }

    public static void MathFunc() {

        //Math.ceil/Math.floor向上取整，向下取整
        Math.ceil(1.2); //= 2
        Math.ceil(-1.6); // = -1

        Math.floor(1.8);// = 1
        Math.floor(-1.1);// = -2

        //取绝对值
        Math.abs(-1); //= 1

        //四舍五入
        //正数的话，还是正常的，之前理解的，但是如果是负数，临界点必须大于5
        Math.round(1.5); // =2
        Math.round(-1.5); // = -1
        Math.round(-1.51);// = -2

        //Math.sqrt()开平方
        Math.sqrt(9); //= 3

        //Math.pow(n,m)取幂
        Math.pow(3, 2);//  ==> 9

        //Math.PI  ===>3.141592653589793

        //Math.max/Math.min  获取最大值和最小值
        Math.max(1, 3); // = 3
        Math.min(4, 6); // =4

        //Math.random()获取0~1之间的随机数(大于等于0小于1)
        Math.random();
        //获取n到m之间的随机数:Math.random()*(m-n)+n;
        //获取10到20之间的随机数 Math.random()*10+10

        BigDecimal b1 = BigDecimal.ZERO;
        BigDecimal b2 = BigDecimal.ONE;
        BigDecimal b3 = BigDecimal.TEN;
        BigDecimal b4 = new BigDecimal(3);
        //加法 +
        b1.add(b2);
        //减法
        b2.subtract(b1);
        //乘法
        b3.multiply(b4);
        //除法(保留两位小数精度)
        if (b4 != null && b4 != BigDecimal.ZERO)
            b3.divide(b4, 2, BigDecimal.ROUND_HALF_UP);

    }


    // IO流的使用
    private static void IORW() throws IOException {
        // 1、创建你文件夹的方式
        String filePath = "C:/Users/LENOVO/Desktop/兮易 开发/buildTextFile";
        File file = new File(filePath);
        file.mkdir();// 根据路径创建文件夹

        // 2、创建文件的方式 根据路径并且使用输出流将字符写入文件中
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("C:/Users/LENOVO/Desktop/兮易 开发/buildTextFile/bufferedWriter.text"));

        bufferedWriter.write("文本内容-----");// 将字符文本写入到对应的创建的文件中
        bufferedWriter.close();// 书写完毕记得关闭输出流。
        System.out.println("已写入文件");

        // 3、文件数据的读取和写入（写入分为控制台和其他新建文件）
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("C:/Users/LENOVO/Desktop/兮易 开发/buildTextFile/bufferedWriter.text"));
        // 可以根据这个处理信息写入的位置，可以再其他的文件中，也可以在控制台上。
        BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(System.out));// 这样能将文件的内容显示在控制台上
        // 写入到另一个文件的时候也是使用同样的方式，只是最后的路径不一致。

        String readLineString = "";

        //这是读取文件内容的一种方式  还有一种方式是
        while ((readLineString = bufferedReader.readLine()) != null) {
            bufferedWriter2.write(readLineString);
            bufferedWriter2.newLine();
        }
        bufferedReader.close();
        bufferedWriter2.close();

    }

//    private static void repate(SqlSession session) {
//        DictionaryMapper dictionaryMapper = session.getMapper(DictionaryMapper.class);
//        Map<String,String> prod_codeQM02 = new HashMap<String, String>();
//        ArrayList<String> key = new ArrayList<String>();
//        String keyString = "QM02";
//        key.add(keyString);
//        List<DictionariyMap>  dictionariyMapList = dictionaryMapper.searchListByItem(key);
//
//        for (DictionariyMap comDic : dictionariyMapList) {
//            if ("QM02".equals(comDic.getItem())) {
//                prod_codeQM02.put(comDic.getKey(), comDic.getValue());
//            }
//        }
//
//        for (Map.Entry<String, String> entry : prod_codeQM02.entrySet()) {// 这是一个foreach循环
//            // 冒号前面的是数据类型和对象名字，后面的是map集合对象的entrySet
//            System.out.println(" WHEN HR.品名 = '"+entry.getKey()+"' THEN '"+entry.getValue()+"'");
//        }

//    }

    /********************************************************************************************************
     * 关于json字符串和 实体类、string、数组 的相互转换
     */
    private static void JSONchange() {

        String data = "{\"REMARK\":\"练习\"}";
        JSONObject jsonObject = JSONObject.parseObject(data);// string类型的转换为json对象
        String value = jsonObject.getString("REMARK");// 获取对应的元素的value值

        TestReA8A103 testReA8A103 = new TestReA8A103();
        TestReA8A103 testReA8A1032 = new TestReA8A103();

        List<TestReA8A103> testReA8A103List = new ArrayList<TestReA8A103>();
        testReA8A103.setNameString("211");
        testReA8A103List.add(testReA8A103);
        testReA8A103List.add(testReA8A1032);


        /**
         * 实体类和数组转化为json格式
         */
        // SerializerFeature属性不要使用错误，这个属性可以使value为空的字段也变成json格式
        // 实体类对象转换为json格式的对象
        SerializerFeature[] feature = {SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullNumberAsZero};
//                版权声明：本文为CSDN博主「codingveaf」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//                原文链接：https://blog.csdn.net/qq_21758475/article/details/111892009

        JSONObject testReA8A103Entity = JSONObject
                .parseObject(JSONObject.toJSONString(testReA8A103, feature));

        // arrarylist集合的转换为json格式字符//需要使用正确的jar包
        // JSONArray jsonArray = JSONArray.fromObject(testReA8A103List);
        // 这个当出现重复的对象的时候，转换json格式出现错误
        JSONArray jsonArray = JSONArray
                .parseArray(JSONObject.toJSONString(testReA8A103List, feature));
        /**
         * json格式转化实体类和数组
         */
        // 1、json中获取value值（string形式）
        String nameValue = testReA8A103Entity.getString("NAME");// 获取对应元素的value值
        // 2、json转化实体类
        TestReA8A103 entity = JSONObject.toJavaObject(testReA8A103Entity, TestReA8A103.class);
        // 3、json转化数组
        JSONArray jsonArray2 = new JSONArray(jsonArray);// 将一个json格式的数据进行jsonarray格式化

        List<TestReA8A103> list = new ArrayList<TestReA8A103>();

        for (int i = 0; i < jsonArray2.size(); i++) {
            TestReA8A103 entityList = JSONObject.toJavaObject(jsonArray2.getJSONObject(i), TestReA8A103.class);
            list.add(entityList);
        }
        //4、jsonArray 转换为ArrayList
        List<TestReA8A103> totalList = JSONObject.parseArray(jsonArray.toJSONString(), TestReA8A103.class);
    }

    // 标签的使用***********************************************************************************************************

    /**
     * 在循环外面标注<标签> continue 不再继续进行内层循环 而是进入下一次外层循环 break则是直接跳过外层循环，程序结束
     * label的作用就是将break和continue的对象由最底层的内部循环，更改为被label标注的循环体
     */
    public static void LableUse() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Lable:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 3 && i == 0) {
                    continue Lable;
                }
                else if (j == 7 && i == 1) {
                    break Lable;
                }
                int num = i * 10 + j;
                arrayList.add(num);
            }
        }
        System.out.println(arrayList);
    }

    // 通过反射获取实体类的方法和字段*******************************************************************************************
    public static void reflect() throws Exception {// 抛出异常的地方，定有引用他的地方进行try
        // catch 对错误进行捕捉
        // 以M1A111为栗子
        TestReA8A103 m1a111 = new TestReA8A103();
        Class<? extends TestReA8A103> m1a111class = m1a111.getClass();
        // 获取字段
        m1a111class.getDeclaredFields();// 获取类中所有声明的字段，无论是私有的还是公开的。 但是不包括继承父类的字段
        m1a111class.getFields();// 获取类中所有的公开声明的字段。
        // 获取方法
        m1a111class.getDeclaredMethods();// 获取所有实体类中声明的方法，包括私有的和公开的以及重写继承父类的方法。
        m1a111class.getMethods();// 获取所有实体类中公共声明的方法
        // 获取构造器
        m1a111class.getDeclaredConstructors();
        m1a111class.getConstructors();

        Field[] fields = m1a111class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            field.getName();// 获取字段
            if (field.getName().equals("ST_NO")) {
                field.set(m1a111, "SS438000121");// 通过反射的方式将引用类型赋给对应的M1A111的ST_NO;
                field.get(m1a111);// 获取引用类型的ST_NO的值。
                // 注解：不同的数据类型还可以有特有的get set方法。这里暂不进行描述getInt/setInt 之类的东西
            }
        }
    }

//    BeanUtils.copyProperties(赋予者,接收者（被赋予者）);

    // Map的循环遍历***********************************************************************************************************

    /**
     * TreeMap：是按key升序,进行排序的； LinkedHashMap：是按加入顺序进行排序的； HashMap：内部数
     * 值的顺序并不是以存放的先后顺序为主，而是以hash值的顺序为主，其次才是存放的先后顺序。 在这里我们只讨论如何实现HashMap的排序。
     */
    public static void mapForeach() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "第一个");
        map.put(2, "第二个");
        map.put(3, "第三个");
        map.put(4, "第四个");

        // 第一种、通过keySet方法，获取map的key值
        Set<Integer> mapKeys = map.keySet();// 这里的泛型为是key的数据类型
        for (Integer key : mapKeys) {
            System.out.println(key + " : " + map.get(key));
        }

        // 第二种:通过Map.values()遍历所有的value但是不能遍历key
        for (String value : map.values()) {
            System.out.println(value);
        }

        // 第三种:直接通过Map.entrySet遍历key和value
        // 最常见
        // 注：Map.Entry方法解释
        // Map.Entry是Map声明的一个内部接口，此接口为泛型，定义为Entry<K,V>。它表示Map中的一个实体（一个key-value对）

        for (Map.Entry<Integer, String> entry : map.entrySet()) {// 这是一个foreach循环
            // 冒号前面的是数据类型和对象名字，后面的是map集合对象的entrySet
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }

        // 第四种 使用迭代器进行遍历，方法过于古老，顺带一提 不推荐使用（本来咩打算写的）
        // 第四种:通过Map.entrySet使用迭代器iterator遍历key和value
        Iterator<Map.Entry<Integer, String>> iterable = map.entrySet().iterator();
        while (iterable.hasNext()) {
            Map.Entry<Integer, String> entry = iterable.next();
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
    }

    /**
     * 读取Excel测试，兼容 Excel2003/2007/2010
     * ***********************************************************************************************************
     */
    public static String readExcel() {
        int r = 0, c = 0;
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // 同时支持Excel 2003、2007"C:\Users\LENOVO\Desktop\兮易 开发\111
            File excelFile = new File("C:/Users/LENOVO/Desktop/兮易 开发/存放数据库导出表格的文件夹/999.xlsx"); // 创建文件对象
            FileInputStream is = new FileInputStream(excelFile); // 文件流
            XSSFWorkbook workbook = new XSSFWorkbook(is); // 这种方式 Excel
            // 2003/2007/2010
            // 都是可以处理的
            int sheetCount = workbook.getNumberOfSheets(); // Sheet的数量
            // 遍历每个Sheet
            for (int s = 0; s < 1; s++) {
                Sheet sheet = workbook.getSheetAt(0);
                int rowCount = sheet.getPhysicalNumberOfRows(); // 获取总行数
                List<String> rlList = new ArrayList<String>();
                List<String> planNoList = new ArrayList<String>();
                List<String> hot_treat_method_codeList = new ArrayList<String>();
                List<BigDecimal> ThickList = new ArrayList<BigDecimal>();
                List<BigDecimal> OutDia = new ArrayList<BigDecimal>();

                List<Integer> integers = new ArrayList<>();
                List<Integer> nullI = new ArrayList<>();
                // 遍历每一行
                for (r = 1; r < rowCount; r++) {

                    Row row = sheet.getRow(r);
                    int cellCount = row.getPhysicalNumberOfCells(); // 获取总列数
                    // 遍历每一列
                    for (c = 1; c < cellCount; c++) {

                        Cell cell = row.getCell(c);
                        CellType cellType = cell.getCellType();
                        String cellValue = null;
                        switch (cellType) {
                            case STRING: // 文本
                                cellValue = cell.getStringCellValue();
                                break;
                            case NUMERIC: // 数字、日期
                                if (DateUtil.isCellDateFormatted(cell)) {
                                    cellValue = fmt.format(cell.getDateCellValue()); // 日期型
                                }
                                else {
                                    cellValue = String.valueOf(cell.getNumericCellValue()); // 数字
                                }
                                break;
                            case BOOLEAN: // 布尔型
                                cellValue = String.valueOf(cell.getBooleanCellValue());
                                break;
                            case BLANK: // 空白
                                cellValue = cell.getStringCellValue();
                                break;
                            case ERROR: // 错误
                                cellValue = "错误";
                                break;
                            case FORMULA: // 公式
                                cellValue = "错误";
                                break;
                            default:
                                cellValue = "错误";
                        }

                        if (c == 1) {
                            rlList.add(cellValue);
                        }
                        if (c == 2) {
                            planNoList.add(cellValue);
                        }
                        if (c == 3)
                            hot_treat_method_codeList.add(cellValue);

                    }
                }
                for (int i = 0; i < rlList.size(); i++) {

                }
            }
        } catch (Exception e) {
            System.out.println("出现问题位于表格的第" + r + 1 + "行" + c + 1 + "列");
            e.printStackTrace();
        }
        return "";
    }

    /*************************************************************************************************************
     * 交集是两个集合中都有的元素、
     *
     * 差集是两个集合中各自独有的元素、
     *
     * 合集是两个集合全部的元素、
     *
     * 两个集合去交集 ArraryList获取交集不会去重
     *
     * set集合取交集会去重
     */
    public static void retianAllTest() {

        List<Integer> list1 = new ArrayList<Integer>() {
            {
                this.add(1);
                this.add(2);
                this.add(3);
            }
        };

        List<Integer> list2 = new ArrayList<Integer>() {
            {
                this.add(2);
                this.add(3);
                this.add(4);
            }
        };

        Set<Integer> list3 = new HashSet<Integer>() {
            {
                this.add(1);
                this.add(2);
                this.add(3);
            }
        };

        Set<Integer> list4 = new HashSet<Integer>() {
            {
                this.add(2);
                this.add(3);
                this.add(4);
            }
        };

        // list 浅拷贝
        // 浅度copy***********************************************************************************************************
        List<Integer> newList = new ArrayList<Integer>();
        // System.arraycopy(src, srcPos, dest, destPos, length);

        // list 深拷贝 深度copy deepcopy
        List<Integer> copyList = new ArrayList<Integer>();// copy形成的list
        CollectionUtils.addAll(copyList, new Object[list1.size()]);
        Collections.copy(copyList, list1);// (新的形成List,原List)
        Collection ar = CollectionUtils.union(list1, list2);
        System.out.println(ar);
        System.out.println(list1);

        // 取两者并集
        list3.retainAll(list4);
        list3.forEach(System.out::println);
        System.out.println("-----------------------");
        CollectionUtils.intersection(list1, list2);// 直接获取两者的（并集）。且不会修改原list内容

        // 取List3和List4的合集
        list1.addAll(list2);
        list1.forEach(System.out::println);
        System.out.println("-----------------------");
        CollectionUtils.union(list3, list4);// 直接获取两者的合集
        // 使用collectionUtils这个方法集.且不会修改原list的内容

        // 取List3和List4中List3单方面的差集
        list3.removeAll(list4);
        list3.forEach(System.out::println);
        System.out.println("-----------------------");
        CollectionUtils.subtract(list3, list4);// 直接返回第一个对第二个集合的差集 且不会修改原list内容
    }

    /**
     * 获取实体类字段
     * 书写前段繁复工作。***********************************************************************************************************
     */
    public static void getModelMethod() {
        String string = "";
        TestReA8A103 tq = new TestReA8A103();
        // Tqmto3a
        Field[] fields = tq.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            string = "{" + "	\"title\": \"" + fields[i].getName() + "\"," + "	\"name\": \"" + fields[i].getName()
                    + "\"," + "	\"width\": \"140px\"," + "	\"sort\": false" + "},";

            System.out.println(string);
        }
    }

    // 型如XXX_YYY_ZZZ的子串改为xxxYyyZxx的子串
    // 大写下划线转换为小驼峰书写方式***********************************************************************************************************
    private static String slashToFirstLetterUpper(String input) {
        String spliter = "_";
        StringBuffer output = new StringBuffer();
        String[] words = input.toLowerCase().split(spliter);
        for (int i = 0; i < words.length; i++) {
            if (i != 0) {
                output.append(fistLetterToUpper(words[i]));
            }
            else {
                output.append(words[i]);
            }
        }
        return output.toString();
    }

    // ******************************首字母大写的修改方法*****************************************************************************
    private static String fistLetterToUpper(String input) {
        if (input == null)
            return "";
        if (input.length() <= 0)
            return "";

        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

    // 数组去重 且会保留被重复数据的位置，后续重复的数据将会被删除
    public static List<String> removeDuplicate(List list) {
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
        return list;
    }

    // 用于读取配置文件 properties 可以方便的获取中文 英文交换
    public static Map<String, String> loaderProperties(String propertiesName) {
        // 资源包类
        ResourceBundle resource = ResourceBundle
                .getBundle("/FGMMS0DC~fgmms0~mes-web~liuzhousteel.com/WebContent/WEB-INF/qm/qmtq/tqmtqc1/i18n/" + propertiesName);
        Set<String> dString = resource.keySet();
        // set类有 普通的hashset(无序(效率最快)) treeSet(自动排序) linkedSet(记录插入顺序)
        List<String> collect = dString.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        Map<String, String> map = new LinkedHashMap<String, String>();

        // 将i18n中的属性 和 值 变成map类型进行使用
        try {
            for (String i : collect) {
                String columnName = new String(resource.getString(String.valueOf(i)).getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
                map.put(i, columnName);
            }
        } finally {

        }
        return map;
    }

    //----------------------------跨天数时间的修改   使用calender日历类进行实现---------------------------------------------------
    public static void nextDayTime8clock(String startDate) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(startDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 1);
        String lastDay = sdf.format(calendar.getTime()) + " 08:00:00";
        System.out.println(lastDay);
    }

    /**
     * 通过反射进行set invoke 对对象进行赋值
     *
     * @param obj       对象
     * @param clazz     类名
     * @param filedName 方法名字
     * @param typeClass 返回值类型 （基础类型）
     * @param value     值
     */
    // class是类，object是对象 对象是类的实例。
    private static void setValue(Object obj, Class<?> clazz, String filedName, Class<?> typeClass, Object value) {
        // 设置get方法的名字 其中subString(1)代表着从字符串下标为1开始到最后的字符串截取
        // 这样就可以获取一般的get和set方法。从而根据反射的方式进行类赋值
        String methodName = "set" + fistLetterToUpper(filedName);
        try {
            // 通过反射获取类方法
            Method method = clazz.getDeclaredMethod(methodName, typeClass);
            // invoke 进行反射赋值
            method.invoke(obj, value == null ? 0 : value);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @author: Longjun
     * @Description: 使用commons的jexl可实现将字符串变成可执行代码的功能
     * @date:2016年3月21日 下午1:45:13
     */
    public static Object convertToCode(String jexlExp, Map<String, Object> map) {

        //所需依赖
        /**
         *    <dependency>
         *             <groupId>org.apache.commons</groupId>
         *             <artifactId>commons-jexl</artifactId>
         *             <version>2.0</version>
         *         </dependency>
         */
        /**
         * 场景描述： 传入S<10的字符串  中含有 [S:9] 的键值对
         * 然后返回true的结果值  （用于大冶特钢的工艺匹配机制中!）
         */
        JexlEngine jexl = new JexlEngine();
        Expression e = jexl.createExpression(jexlExp);
        MapContext jc = new MapContext();
        for (String key : map.keySet()) {
            jc.set(key, map.get(key));
        }
        if (null == e.evaluate(jc)) {
            return "";
        }
        return e.evaluate(jc);
    }


    public static List<String> rightMove(List<String> list, int b) {
        int originSize = list.size();
        b = originSize - b % originSize;
        for (int i = 0; i < b; i++) {
            list.add(list.get(i));
        }
        return list.subList(1, originSize + 1);
    }

    //java 8 新特性合集（常用）
    //根据某一属性进行删选的  java8 新特性。
//    roleNameList=list.stream().map(AutRoleInfoVo::getRoleName).collect(Collectors.toList());

    //获取list 中某个属性最小的元素(对象) (元素不得为null)
//    List.stream().min(Comparator.comparing(Entity::getAge)).get();


    //根据属性进行排序 (由小到大)
    //    students.sort((x, y) -> Double.compare(x.getAge(), y.getAge()));

    //java8 新特性  根据一个字段进行分组
//    Map<Integer, List<T>> devideMap = list.stream().collect(
//            Collectors.groupingBy(
//                    entity -> entity.getParam()
//            ));


    //注意  localDateTime 转为String 类型的时候会在一定情况下丢失秒数 在秒 = :00时。
    public static void culTime() {

        //数据转换为long类型 然后在重新转置为对应的时间类型
        long milliseconds = 123456789123l;
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String str1 = sdf1.format(new Date(milliseconds));
        System.out.println(str1);


        //localDateTime 的计算方式
        Duration mid = Duration.between(LocalDateTime.now(), LocalDateTime.now().plusHours(2));
        System.out.println(mid.toHours());
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDateTime.now().plusHours(mid.toHours()));

        //String 和 LocalDateTime 的时间转换
        String time = "2022-03-11 03:05:33";
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime createDateTime = LocalDateTime.parse(time, fmt).plusDays(-1);
        LocalDate createDate = LocalDate.parse(time, fmt);
        System.out.println(createDate + "\n" + createDateTime);

        //localDateTime 和 date  格式的转换
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy 年 MM 月 dd 日");
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        Date date = Date.from(zdt.toInstant());
        String str = sdf.format(date);
    }

    public static void UseQueue() {
    }

    //对记录进行时间排序的方法eventData(List<Event> eventList)
    public static List<TestReA8A103> eventData(List<TestReA8A103> eventList) {
        Collections.sort(eventList, (e1, e2) -> {
            int diff = e1.getStartTime().compareTo(e2.getStartTime());
            if (diff > 0) {
                return 1;
            }
            else if (diff < 0) {
                return -1;
            }
            return 0;//相等为0
        });
        return eventList;
    }

    //MYSQL 的使用  去除字段为空的数据 test_id is null || (LENGTH(TRIM(test_id)) = 0)
    //ORCALE 的使用  去除null 和字段为空的数据   ID is not  null or (length(trim(ID))>0);
    //保留为空的   test_id is not null && (LENGTH(TRIM(test_id)) > 0)


    /**
     * 1、线程数量和cpu有关，使用线程时一定要注意线程的释放，否则会导致cpu线程数量耗尽；
     * 2、使用注解完成的线程操作，不可以在自己的类中实现调用，因为注解最后也是通过代理的方式完成异步线程的，最好时在单独的一个service中写；
     * 3、线程池最好单独写，使用static和final修饰，保证所有使用该线程池的地方使用的是一个线程池，而不能每次都new一个线程池出来，每次都new一个就没有意义了。
     * ————————————————
     * 版权声明：本文为CSDN博主「天河归来」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/nhx900317/article/details/125478681
     */

    /**
     * 异步执行操作
     */
    //具体产生何种线程池看个人需求，Executors提供多种线程池供选择
    //不推荐使用Executor创建线程池（可能会引发oom：内存溢出），此处只是演示,推荐根据实际场景用原生ThreadPoolExecutor创建。
    public static ExecutorService executor = Executors.newCachedThreadPool();

    /**
     * 线程池信息： 核心线程数量5，最大数量10，队列大小20，超出核心线程数量的线程存活时间：30秒， 指定拒绝策略的
     * <p>
     * corePoolSize： 线程池维护线程的最少数量
     * maximumPoolSize：线程池维护线程的最大数量
     * keepAliveTime： 线程池维护线程所允许的空闲时间
     * unit： 线程池维护线程所允许的空闲时间的单位
     * workQueue： 线程池所使用的缓冲队列
     * handler： 线程池对拒绝任务的处理策略
     * <p>
     * <p>
     * 核心线程corePoolSize、任务队列workQueue、最大线程maximumPoolSize，如果三者都满了，使用handler处理被拒绝的任务。
     * <p>
     * 当线程池中的线程数量大于 corePoolSize时，如果某线程空闲时间超过keepAliveTime，线程将被终止。这样，线程池可以动态的调整池中的线程数。
     * 也就是说当线程数量少于核心线程数的时候  是不会启用线程终止下闲置线程的。
     * <p>
     * unit:可以使用的几个 时间 单位  NANOSECONDS、MICROSECONDS、MILLISECONDS、SECONDS。 纳秒 微秒 毫秒 秒。
     * <p>
     * workQueue:可以使用 java.util.concurrent.ArrayBlockingQueue 和 java.util.concurrent.LinkedBlockingQueue;
     * <p>
     * link对GC 压力大  链表不能直接移除或添加对象  需要Node 来协助
     * 两者的区别见：https://blog.csdn.net/u011016373/article/details/110384103
     * 建议使用ArrayBlockingQueue
     * <p>
     * handler:
     * 1、ThreadPoolExecutor.AbortPolicy() 抛出java.util.concurrent.RejectedExecutionException异常
     * 2、ThreadPoolExecutor.CallerRunsPolicy() 重试添加当前的任务，他会自动重复调用execute()方法
     * 3、ThreadPoolExecutor.DiscardOldestPolicy() 抛弃旧的任务
     * 4、ThreadPoolExecutor.DiscardPolicy() 抛弃当前的任务
     * <p>
     * 用法：
     * private static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 30, TimeUnit.SECONDS,
     * new ArrayBlockingQueue<Runnable>(20), new ThreadPoolExecutor.CallerRunsPolicy());
     * <p>
     * <p>
     * 信息来源: https://www.gaodaima.com/113167.html
     */
    private static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(20), new RejectedExecutionHandler() {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            //线程池对拒绝任务的处理策略
            System.out.println("有任务被拒绝执行了");
        }
    });

    public static void ThreadAsyn() {
        AsynFunc();
        System.out.println("业务执行开始！");
    }

    //异步实现方法
    private static void AsynFunc() {
        //即使核心线程空闲超时也会遵循线程销毁的规则。默认为false ↓↓↓ ↓↓↓
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.submit(() -> {
            System.out.println("正在执行业务，请稍等");
            //获取当前线程
            Thread currentThread = Thread.currentThread();
            try {
                Thread.sleep(3000);
                //TODO 执行具体的业务逻辑
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("业务执行完成");
        });
        /**
         * 拒收新任务，不会立即终止线程池。而是要等所有任务缓存队列中的任务都执行完后才终止。
         */
        threadPoolExecutor.shutdown();
        /**
         * 拒收新任务，立即终止线程池。并尝试打断正在执行的任务。
         * 并且清空任务缓存队列，返回尚未执行的任务
         */
//        threadPoolExecutor.shutdownNow();


        //**线程**
        //资料来源：https://blog.csdn.net/qq_43019156/article/details/121956733

        /**
         * 线程于进程的区别：
         *
         * 进程是程序的一次执行过程，是资源分配的最小单位
         * 线程是CPU调度的最小单位
         * 线程是进程的一部分
         * 一个线程只能属于一个进程，而一个进程可以有多个线程，但至少有一个线程
         *
         *
         * 线程的创建的四种方式：
         * 1、extends Thread 会重写run方法创建
         * 2、implements Runnable 会重写run方法创建
         * 3、 lambda 表达式直接创建 ：
         * new Thread(() ->{
         *             System.out.println(Thread.currentThread().getName() + "正在运行");
         *         }).start();
         * 4、线程池创建
         * threadPoolExecutor.submit(() -> {
         *             System.out.println("正在执行业务，请稍等");
         *             //获取当前线程
         *             Thread currentThread = Thread.currentThread();
         *             try {
         *                 currentThread.sleep(3000);
         *             } catch (InterruptedException e) {
         *                 e.printStackTrace();
         *             }
         *             System.out.println("业务执行完成");
         *         });
         *5、实现Callable接口结合FutureTask （不常用且不推荐！）
         *
         *
         * 线程的5种状态:新建（new Thread）、就绪（runnable）、运行（running）、阻塞（blocked）、结束（dead）
         *
         * 其中 run 方法 和start 方法两者之间的区别是：run是直接运行的Thread中的方法，并不会启用一个新线程，
         * 但start则会启用一个新的线程将其处于就绪状态，等待获取CPU时间片段后直接执行run方法，实现了多线程。
         * 所以run方法更多的是直接
         *
         * 线程的join 方法：join()方法的作用就是让主线程等待子线程执行结束之后再运行主线程。
         *
         * 主线程中调用子线程的join方法，当线程调用了join方法时，子线程会强占CPU资源，直到线程执行结果为止（谁调用join方法，谁就强占cpu资源，直至执行结束）
         * 来源;https://blog.csdn.net/xiaozhu0301/article/details/111579801
         */

    }
}